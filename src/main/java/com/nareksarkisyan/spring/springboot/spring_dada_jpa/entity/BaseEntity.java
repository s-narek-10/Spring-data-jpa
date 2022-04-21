package com.nareksarkisyan.spring.springboot.spring_dada_jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private Date dateCreated;
    private Date DateUpdated;

    @PrePersist
    @PreUpdate
    public void setAuditFields() {
        Date now = new Date();
        if (getDateCreated() == null) {
            setDateCreated(now);
        }
        setDateUpdated(now);
    }
}
