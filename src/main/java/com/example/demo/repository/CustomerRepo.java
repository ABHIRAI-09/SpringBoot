package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.CustomerInfo;

public interface CustomerRepo extends JpaRepository<CustomerInfo, String> {
 // Optional<CustomerInfo> findById(String id);
}
