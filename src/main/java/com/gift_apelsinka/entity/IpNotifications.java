package com.gift_apelsinka.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Data
@Entity
@IdClass(IpNotifications.class)
public class IpNotifications implements Serializable {
    @Id
    private String androidId;
    @Id
    private Integer id;
    private Boolean isDelivered;

    public IpNotifications(String androidId, Integer id) {
        this.androidId = androidId;
        this.id = id;
        this.isDelivered = false;
    }
    public IpNotifications() {}
}
