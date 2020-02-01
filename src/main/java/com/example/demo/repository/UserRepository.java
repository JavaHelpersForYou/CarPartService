package com.example.demo.repository;

import com.example.demo.model.StatusType;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.id = :id and u.status = :status")
    Optional<User> findByIdAndStatus(Long id, StatusType statusType);
}
