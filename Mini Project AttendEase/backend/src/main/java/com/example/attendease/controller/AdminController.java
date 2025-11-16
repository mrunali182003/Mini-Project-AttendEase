package com.example.attendease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/login")
    public String login(@RequestBody Admin admin) {
        Admin found = adminRepository.findByUsername(admin.getUsername());
        if (found != null && found.getPassword().equals(admin.getPassword())) {
            return "success";
        }
        return "failure";
    }
}
