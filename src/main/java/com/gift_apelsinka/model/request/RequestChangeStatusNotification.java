package com.gift_apelsinka.model.request;

import lombok.Data;

@Data
public class RequestChangeStatusNotification {
    private String androidId;
    private String ip;
    private Integer id;
}
