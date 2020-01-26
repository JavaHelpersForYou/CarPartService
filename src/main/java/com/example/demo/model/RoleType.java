package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum  RoleType {
    ADMIN("ADMIN"),
    USER("USER");

    @Getter
    private String name;
}
