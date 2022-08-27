package com.gift_apelsinka.repo.notification;

import com.gift_apelsinka.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationsRepository extends JpaRepository<Notifications, Integer> {
    @Query(value = "select * from notifications where status=:status", nativeQuery = true)
    List<Notifications> findAllByStatus(@Param("status") Boolean status);
}
