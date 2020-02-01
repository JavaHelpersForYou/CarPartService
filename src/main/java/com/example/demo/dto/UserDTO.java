package com.example.demo.dto;

import com.example.demo.model.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles;
}
