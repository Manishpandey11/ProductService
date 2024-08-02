package com.scaler.test.inheritancedemo.mappedsuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Instructor extends User {
    private String favouriteStudent;
}
