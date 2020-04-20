package com.example.demo.dto.user;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserDTO userToUserDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }

    public User userDtoToUser(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .roles(userDTO.getRoles())
                .build();
    }

    public Page<UserDTO> userToUserDTOs(Page<User> users) {
        return users.map(this::userToUserDto);
    }
}
