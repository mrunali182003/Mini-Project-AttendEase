package com.example.attendease.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendease.model.User; // ✅ Add this
import com.example.attendease.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {



    @Autowired
    private UserRepository userRepo;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Optional<User> optionalUser = userRepo.findByUsernameAndPassword(username, password);

        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            return "Welcome " + user.getUsername();
        } else {
            return "Invalid username or password";
        }
    }
}
