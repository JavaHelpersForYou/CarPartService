package com.example.demo.service.user;

import com.example.demo.dto.user.UserDTO;
import com.example.demo.dto.user.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static com.example.demo.model.StatusType.ACTIVE;
import static com.example.demo.model.StatusType.DELETED;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserDTO createUser(UserDTO userDTO) {
        User user = User.builder()
                .name(userDTO.getName())
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .roles(userDTO.getRoles())
                .created(Timestamp.valueOf(LocalDateTime.now()))
                .updated(Timestamp.valueOf(LocalDateTime.now()))
                .status(ACTIVE)
                .build();

        User saveUser = userRepository.saveAndFlush(user);
        return userMapper.userToUserDto(saveUser);
    }

    public UserDTO findUserById(Long id) throws Exception {
        return userRepository
                .findByIdAndStatus(id, ACTIVE)
                .map(userMapper::userToUserDto)
                .orElseThrow(Exception::new);
    }

    public void deleteUser(Long id) throws Exception {
        User user = userRepository.findByIdAndStatus(id, ACTIVE)
                .orElseThrow(Exception::new);
        user.setStatus(DELETED);
        userRepository.saveAndFlush(user);
    }
}
