package com.example.attendease.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendease.repository.StudentRepository;

@Service
public class DashboardService {

    @Autowired
    private StudentRepository studentRepository;

    public Map<String, Object> getDashboardData() {
        long totalStudents = studentRepository.count();

        // Example logic (replace with real attendance calculations)
        double attendancePercent = 87.0;
        int todaysClasses = 5;

        Map<String, Object> data = new HashMap<>();
        data.put("totalStudents", totalStudents);
        data.put("attendancePercent", attendancePercent);
        data.put("todaysClasses", todaysClasses);

        return data;
    }
}
