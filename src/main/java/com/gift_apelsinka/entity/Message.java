package com.gift_apelsinka.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Message {
    @Id
    private Integer id;
    private String message;
}
