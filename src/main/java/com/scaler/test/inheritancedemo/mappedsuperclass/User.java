package com.scaler.test.inheritancedemo.mappedsuperclass;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User {
    private Long id;
    private String name;
    private String email;
}
