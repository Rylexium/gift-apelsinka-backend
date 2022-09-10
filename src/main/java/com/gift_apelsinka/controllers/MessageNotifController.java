package com.gift_apelsinka.controllers;

import com.gift_apelsinka.util.Const;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/chat")
public class MessageNotifController {

    private final SimpMessagingTemplate simpleMessageTemplate;

    @MessageMapping("/sock")
    public void chatSocket(String text) {
        simpleMessageTemplate.convertAndSendToUser("", Const.CHAT_TOPIC ,"message");
    }
}
