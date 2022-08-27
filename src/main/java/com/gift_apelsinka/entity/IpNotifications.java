package com.gift_apelsinka.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class IpNotifications {
    @Id
    private String androidId;
    private String ip;
    private Integer id;

    public IpNotifications(String androidId, String ip, Integer id) {
        this.androidId = androidId;
        this.ip = ip;
        this.id = id;
    }
    public IpNotifications() {}
}
