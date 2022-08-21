package com.gift_apelsinka.repo;

import com.gift_apelsinka.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
