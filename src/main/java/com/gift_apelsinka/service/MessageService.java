package com.gift_apelsinka.service;

import com.gift_apelsinka.entity.Message;
import com.gift_apelsinka.entity.Notifications;
import com.gift_apelsinka.repo.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public HashMap<String, String> saveMessage(String message) {
        messageRepository.save(new Message(message));
        return new HashMap<>() {{ put("status", "successful"); }};
    }
}
