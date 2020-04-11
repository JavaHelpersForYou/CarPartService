package com.example.demo.service.user;

import com.example.demo.dto.user.UserDTO;
import com.example.demo.dto.user.UserMapper;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static com.example.demo.model.StatusType.ACTIVE;
import static com.example.demo.model.StatusType.DELETED;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

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

    public UserDTO findById(Long id) {
        return userRepository
                .findByIdAndStatus(id, ACTIVE)
                .map(userMapper::userToUserDto)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findByIdAndStatus(id, ACTIVE)
                .orElseThrow(ResourceNotFoundException::new);
        user.setStatus(DELETED);
        userRepository.saveAndFlush(user);
    }

    public Page<UserDTO> findAllUsers(Pageable pageable) {
        return userMapper.userToUserDTOs(userRepository.findAll(pageable));
    }

    public UserDTO updateUser(long id, UserDTO userDTO) {
        User userUpdateById = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        User actualUser = userMapper.userDtoToUser(userDTO);

        userUpdateById.setName(actualUser.getName());
        userUpdateById.setUsername(actualUser.getUsername());
        userUpdateById.setEmail(actualUser.getEmail());
        userUpdateById.setPassword(actualUser.getPassword());
        userUpdateById.setRoles(actualUser.getRoles());

        return userMapper.userToUserDto(userRepository.saveAndFlush(userUpdateById));
    }
}
