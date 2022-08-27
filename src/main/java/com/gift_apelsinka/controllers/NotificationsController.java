package com.gift_apelsinka.controllers;

import com.gift_apelsinka.model.request.RequestChangeStatusNotification;
import com.gift_apelsinka.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class NotificationsController {

    private final NotificationService notificationService;

    @GetMapping("notifications")
    public HashMap<String, Object> getNotifications(@RequestParam("androidId") String androidId) {
        return notificationService.getNotification(androidId);
    }

    @PostMapping("notifications")
    public HashMap<String, String> setStatusNotifications(@RequestBody RequestChangeStatusNotification request) {
        return notificationService.setNotificationsStatus(request.getAndroidId(), request.getIp(), request.getId());
    }

}