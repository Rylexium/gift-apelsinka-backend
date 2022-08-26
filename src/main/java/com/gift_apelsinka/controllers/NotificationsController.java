package com.gift_apelsinka.controllers;

import com.gift_apelsinka.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class NotificationsController {

    private final NotificationService notificationService;

    @GetMapping("notifications")
    public HashMap<String, Object> getNotifications() {
        return notificationService.getNotification();
    }
}
