package com.gift_apelsinka;

import com.gift_apelsinka.service.notification.NotificationRunner;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Runner implements ApplicationRunner {

    private final NotificationRunner notificationRunner;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        notificationRunner.scheduleCheckNotifications();
    }
}
