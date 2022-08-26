package com.gift_apelsinka.controllers;


import com.gift_apelsinka.model.request.RequestMessage;
import com.gift_apelsinka.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
