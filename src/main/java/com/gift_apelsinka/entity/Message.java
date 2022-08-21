package com.gift_apelsinka.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String text;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Message(String message) {
        this.text = message;
    }
    @PrePersist
    @PreUpdate
    private void onCreateOrUpdate() {
        date = new Date();
    }
}
