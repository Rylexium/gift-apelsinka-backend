package com.gift_apelsinka.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ip;
    private Integer who;
    private Integer toWhom;
    private String text;
    private Boolean status = false;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Message(String ip, Integer who, Integer toWhom, String text) {
        this.ip = ip;
        this.who = who;
        this.toWhom = toWhom;
        this.text = text;
    }

    @PrePersist
    @PreUpdate
    private void onCreateOrUpdate() {
        final long hoursInMillis = 60L * 60L * 1000L;
        date = new Date(new Date().getTime() + (4L * hoursInMillis)); // adding 4 hours
    }
}
