package com.amponsem.controller;

import com.amponsem.service.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        // Replace with actual authentication logic
        if ("user".equals(username) && "password".equals(password)) {
            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
