package com.gift_apelsinka.controllers;

import com.gift_apelsinka.model.request.RequestNotificationDelivered;
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
    @PostMapping("notifications/delivered")
    public HashMap<String, String> setDeliveredNotification(@RequestBody RequestNotificationDelivered request) {
        return notificationService.setDeliveredNotification(request.getAndroidId(), request.getId());
    }

    @GetMapping("notifications/delete/{id}")
    public HashMap<String, String> deleteFromIpNotifications(@PathVariable("id") Integer id) {
        return notificationService.deleteNotificationById(id);
    }
    @GetMapping("notifications/delete/all")
    public HashMap<String, String> deleteAllFromIpNotifications() {
        return notificationService.deleteNotificationAll();
    }
}
