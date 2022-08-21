package com.gift_apelsinka.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Pictures {
    @Id
    private Integer id;
    private String picture;
    private String title;
    private Integer belongs;
}
