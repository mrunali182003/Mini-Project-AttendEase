package com.example.attendease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.attendease.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
