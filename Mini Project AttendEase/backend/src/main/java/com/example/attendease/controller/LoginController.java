package com.example.attendease.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendease.model.User;
import com.example.attendease.repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> userData) {
        String id = userData.get("id");
        String password = userData.get("password");
        String role = userData.get("role");

        // Check in DB
        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(id, password);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String userRole = user.getRole();

            // Verify role
            if (role.equalsIgnoreCase(userRole)) {
                return ResponseEntity.ok(Map.of(
                        "status", "success",
                        "role", userRole,
                        "message", userRole + " login successful"));
            } else {
                return ResponseEntity.status(403).body(Map.of(
                        "status", "error",
                        "message", "Role mismatch"))
        
        
            );
            }
        }
@PostMapping("/login")
        public ResponseEntity<?> login
        (@RequestBody
        Map<String, String> userData
            
        ) {
    String id = userData.get("id");
            String password = userData.get("password");
            String role = userData.get("role");

            if ("admin".equalsIgnoreCase(id) && "admin123".equals(password) && "admin".equalsIgnoreCase(role)) {
                return ResponseEntity.ok(Map.of("status", "success", "role", "admin", "message", "Admin login successful"));
            } else if ("student1".equalsIgnoreCase(id) && "stud123".equals(password) && "student".equalsIgnoreCase(role)) {
                return ResponseEntity.ok(Map.of("status", "success", "role", "student", "message", "Student login successful"));
            } else if ("faculty1".equalsIgnoreCase(id) && "fac123".equals(password) && "faculty".equalsIgnoreCase(role)) {
                return ResponseEntity.ok(Map.of("status", "success", "role", "faculty", "message", "Faculty login successful"));
            } else {
                return ResponseEntity.status(401).body(Map.of("status", "error", "message", "Invalid credentials or role"));
            }
        }

        // Fallback for static testing (remove later)
        if ("admin".equalsIgnoreCase(id) && "admin123".equals(password) && "admin".equalsIgnoreCase(role)) {
            return ResponseEntity.ok(Map.of("status", "success", "role", "admin", "message", "Admin login successful"));
        } else if ("faculty1".equalsIgnoreCase(id) && "fac123".equals(password) && "faculty".equalsIgnoreCase(role)) {
            return ResponseEntity.ok(Map.of("status", "success", "role", "faculty", "message", "Faculty login successful"));
        } else if ("student1".equalsIgnoreCase(id) && "stud123".equals(password) && "student".equalsIgnoreCase(role)) {
            return ResponseEntity.ok(Map.of("status", "success", "role", "student", "message", "Student login successful"));
        }

        return ResponseEntity.status(401).body(Map.of("status", "error", "message", "Invalid ID or password"));
    }
}
