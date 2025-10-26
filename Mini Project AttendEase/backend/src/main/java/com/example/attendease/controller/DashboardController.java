package com.example.attendease.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendease.model.AttendanceReport;
import com.example.attendease.repository.AttendanceRepository;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {
    private final AttendanceRepository attendanceRepo;

    public DashboardController(AttendanceRepository attendanceRepo) {
        this.attendanceRepo = attendanceRepo;
    }

    @GetMapping("/reports")
    public List<AttendanceReport> getReports() {
        return attendanceRepo.findAll();
    }
}
