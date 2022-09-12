package com.gift_apelsinka.controllers.socket;

import com.gift_apelsinka.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import static com.gift_apelsinka.controllers.socket.util.Const.NOTIFICATIONS_TOPIC;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationSocketController {

    private final SimpMessagingTemplate simpleMessageTemplate;
    private final NotificationService notificationService;

    public static Map<String, String> subscribers = new HashMap<>();

    @MessageMapping("/sock")
    @SendToUser("/topic/notifications")
    public void notificationsSocket(String androidId,
                                    Principal principal) {
        notificationService.deleteNotificationAll();
        subscribers.put(androidId, principal.getName());
        Map<String, Object> list = notificationService.getNotification(androidId);
        simpleMessageTemplate.convertAndSendToUser(
                principal.getName(),
                NOTIFICATIONS_TOPIC,
                list);
    }
}
