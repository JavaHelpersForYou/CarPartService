package com.example.demo.repository;

import com.example.demo.model.PartDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartDetailsRepository extends JpaRepository<PartDetails, Long> {
}
