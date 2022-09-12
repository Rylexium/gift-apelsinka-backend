package com.gift_apelsinka.service.notification;

import com.gift_apelsinka.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.gift_apelsinka.controllers.socket.NotificationSocketController.subscribers;
import static com.gift_apelsinka.controllers.socket.util.Const.NOTIFICATIONS_TOPIC;

@Service
@EnableScheduling
@EnableAsync
@RequiredArgsConstructor
public class NotificationRunner {

    private final SimpMessagingTemplate simpleMessageTemplate;
    private final NotificationService notificationService;

    @Async
    @Scheduled(fixedDelay = 5000)
    public void scheduleCheckNotifications() {
        for (Map.Entry<String, String> subscriber : subscribers.entrySet()) {
            Map<String, Object> notificationsByAndroidID = notificationService.getNotification(subscriber.getKey());
            List<Object> list = (List<Object>) notificationsByAndroidID.get("notifications");
            if(!list.isEmpty())
                simpleMessageTemplate.convertAndSendToUser(
                        subscriber.getValue(),
                        NOTIFICATIONS_TOPIC,
                        notificationsByAndroidID);
        }
    }
}
