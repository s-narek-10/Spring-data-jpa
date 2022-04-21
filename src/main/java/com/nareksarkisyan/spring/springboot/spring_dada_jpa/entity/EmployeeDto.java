package com.nareksarkisyan.spring.springboot.spring_dada_jpa.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto extends BaseEntityDto {
    private String name;

    private String surname;

    private String department;

    private int salary;
}
