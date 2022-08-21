package com.gift_apelsinka.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Statements {
    @Id
    private Integer id;
    private String text;
    private String author;
}
