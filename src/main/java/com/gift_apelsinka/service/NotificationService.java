package com.gift_apelsinka.service;

import com.gift_apelsinka.entity.IpNotifications;
import com.gift_apelsinka.entity.Notifications;
import com.gift_apelsinka.repo.notification.IpNotificationRepository;
import com.gift_apelsinka.repo.notification.NotificationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationsRepository notificationsRepository;
    private final IpNotificationRepository ipNotificationRepository;

    public HashMap<String, Object> getNotification(String androidId) {
        List<IpNotifications> ipNotifications = ipNotificationRepository.findAllByAndroidId(androidId);
        List<Notifications> notifications = notificationsRepository.findAllByStatus(false);
        List<Notifications> result = new ArrayList<>();
        for (Notifications notification : notifications)
            for (IpNotifications ipNotification : ipNotifications)
                if (!Objects.equals(notification.getId(), ipNotification.getId()))
                    result.add(notification);

        return new HashMap<>() {
            {
                put("notifications", result);
            }
        };
    }
    public HashMap<String, String> setNotificationsStatus(String androidId, String ip, Integer id) {
        ipNotificationRepository.save(new IpNotifications(androidId, ip, id));
        return new HashMap<>() {
            {
                put("status", "successfully");
            }
        };
    }
}