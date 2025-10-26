package com.example.attendease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.attendease.model.AttendanceReport;

public interface AttendanceRepository extends JpaRepository<AttendanceReport, Long> {}
