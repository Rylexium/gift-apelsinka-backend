package com.gift_apelsinka.repo.notification;

import com.gift_apelsinka.entity.IpNotifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IpNotificationRepository extends JpaRepository<IpNotifications, String> {
    @Query(value = "select * from ip_notifications where android_id=:android_id", nativeQuery = true)
    List<IpNotifications> findAllByAndroidId(@Param("android_id") String androidId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from ip_notifications where id=:value", nativeQuery = true)
    void deleteIpNotificationById(@Param("value") Integer id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE ip_notifications " +
            "SET \"is_delivered\"=true " +
            "WHERE android_id = :android_id and id = :notification_id", nativeQuery = true)
    void setDeliveredNotification(@Param("android_id") String androidId,
                                  @Param("notification_id") Integer notificationId);
}
