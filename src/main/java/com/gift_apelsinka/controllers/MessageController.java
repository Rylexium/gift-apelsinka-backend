package com.gift_apelsinka.controllers;


import com.gift_apelsinka.model.request.RequestMessage;
import com.gift_apelsinka.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class MessageController {

    private final MessageService messageService;

    @PostMapping("message")
    public HashMap<String, String> saveMessage(@RequestBody RequestMessage request) {
        return messageService.saveMessage(request.getIp(), request.getWho(), request.getToWhom(), request.getText());
    }
    @GetMapping("message")
    public HashMap<String, Object> getMessage() {
        return messageService.getMessages();
    }
    @GetMapping("message/gps")
    public HashMap<String, Object> getGPSMessage() {
        return messageService.getGPSMessages();
    }
    @GetMapping("message/message")
    public HashMap<String, Object> getMessages() {
        return messageService.getMessagesMessage();
    }
}
