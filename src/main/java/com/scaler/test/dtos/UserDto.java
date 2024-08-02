package com.scaler.test.dtos;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.ManyToMany;

import javax.management.relation.Role;
import java.util.*;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private List<Role> roles;
    private boolean isEmailVerified;
}
