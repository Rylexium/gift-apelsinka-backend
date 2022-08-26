package com.gift_apelsinka.service;

import com.gift_apelsinka.entity.Notifications;
import com.gift_apelsinka.repo.NotificationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationsRepository notificationsRepository;

    public HashMap<String, Object> getNotification() {
        return new HashMap<>() {
            {
                put("notifications", notificationsRepository.findAllByStatus(false));
            }
        };
    }
    public HashMap<String, String> setNotificationsStatus(Integer id) {
        Notifications notification = notificationsRepository.findById(id).orElse(null);
        if(notification != null){
            notification.setStatus(true);
            notificationsRepository.save(notification);
        }
        return new HashMap<>() {
            {
                put("status", "successfully");
            }
        };
    }
}
