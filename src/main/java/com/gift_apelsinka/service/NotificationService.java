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

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationsRepository notificationsRepository;
    private final IpNotificationRepository ipNotificationRepository;

    public HashMap<String, Object> getNotification(String androidId) {
        List<IpNotifications> ipNotifications = ipNotificationRepository.findAllByAndroidId(androidId);
        List<Notifications> notifications = notificationsRepository.findAllByStatus(true);
        List<Notifications> result = new ArrayList<>();
        for (Notifications notification : notifications) {
            if(!notification.getStatus()) continue; //неактивный статус в базе уведомлений

            boolean flag = false;

            for (IpNotifications ipNotification : ipNotifications) {
                // если это уведомление уже есть и оно было доставлено, то идём дальше
                if (ipNotification.getId().equals(notification.getId()) && ipNotification.getIsDelivered()) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result.add(notification);
                ipNotificationRepository.save(new IpNotifications(androidId, notification.getId()));
            }
        }
        return new HashMap<>() {
            {
                put("notifications", result);
            }
        };
    }

    public HashMap<String, String> setDeliveredNotification(String androidId, Integer id) {
        ipNotificationRepository.setDeliveredNotification(androidId, id);
        return new HashMap<>() {
            {
                put("status", "successfully");
            }
        };
    }

    public HashMap<String, String> deleteNotificationById(Integer id) {

       ipNotificationRepository.deleteIpNotificationById(id);
        return new HashMap<>() {
            {
                put("status", "delete successfully");
            }
        };
    }
    public HashMap<String, String> deleteNotificationAll() {
        ipNotificationRepository.deleteAll();
        return new HashMap<>() {
            {
                put("status", "delete all successfully");
            }
        };
    }
}
