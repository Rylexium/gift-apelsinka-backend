package com.gift_apelsinka.model.request;

import lombok.Data;

@Data
public class RequestMessage {
    private String ip;
    private Integer who;
    private Integer toWhom;
    private String text;
}
