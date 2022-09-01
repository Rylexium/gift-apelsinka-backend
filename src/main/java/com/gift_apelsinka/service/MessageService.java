package com.gift_apelsinka.service;

import com.gift_apelsinka.entity.Message;
import com.gift_apelsinka.entity.Notifications;
import com.gift_apelsinka.repo.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public HashMap<String, String> saveMessage(String ip, Integer who, Integer toWhom, String text) {
        messageRepository.save(new Message(ip, who, toWhom, text));
        return new HashMap<>() {{ put("status", "successful"); }};
    }
    public HashMap<String, Object> getGPSMessages() {
        return new HashMap<>() { { put("message", messageRepository.findAllGPSMessages()); } };
    }

    public HashMap<String, Object> getMessages() {
        return new HashMap<>() { { put("message", messageRepository.findAllOrderByDateDesc()); } };
    }

    public HashMap<String, Object> getMessagesMessage() {
        return new HashMap<>() { { put("message", messageRepository.findAllNotDebugAndNotGPS()); } };
    }
}
