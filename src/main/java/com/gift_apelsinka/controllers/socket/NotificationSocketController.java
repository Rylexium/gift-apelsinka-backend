package com.gift_apelsinka.controllers.socket;

import com.gift_apelsinka.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gift_apelsinka.controllers.socket.util.Const.NOTIFICATIONS_TOPIC;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationSocketController {

    private final SimpMessagingTemplate simpleMessageTemplate;
    private final NotificationService notificationService;

    @MessageMapping("/sock")
    public void notificationsSocket(String androidId) {
        simpleMessageTemplate.convertAndSend(NOTIFICATIONS_TOPIC, notificationService.getNotification(androidId));
    }
}
