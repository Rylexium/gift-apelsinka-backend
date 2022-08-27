package com.gift_apelsinka.repo.notification;

import com.gift_apelsinka.entity.IpNotifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IpNotificationRepository extends JpaRepository<IpNotifications, String> {
    @Query(value = "select * from ip_notifications where android_id=:android_id", nativeQuery = true)
    List<IpNotifications> findAllByAndroidId(@Param("android_id") String androidId);
}
