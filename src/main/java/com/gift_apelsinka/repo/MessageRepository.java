package com.gift_apelsinka.repo;

import com.gift_apelsinka.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query(value = "select * from message where text like 'GPS : %' order by date desc", nativeQuery = true)
    List<Message> findAllGPSMessages();

    @Query(value = "select * from message order by date desc", nativeQuery = true)
    List<Message> findAllOrderByDateDesc();

    @Query(value = "select * from message where who!=0 and who!=1 order by date desc", nativeQuery = true)
    List<Message> findAllNotDebugAndNotGPS();
}
