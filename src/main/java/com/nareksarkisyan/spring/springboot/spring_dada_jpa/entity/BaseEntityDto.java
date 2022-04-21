package com.nareksarkisyan.spring.springboot.spring_dada_jpa.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseEntityDto {
    private int id;

    private Date dateCreated;
    private Date DateUpdated;
}
