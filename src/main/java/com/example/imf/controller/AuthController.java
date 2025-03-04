package com.example.imf.controller;

import com.example.imf.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(JwtUtil jwtUtil){
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/token")
    public ResponseEntity<String> getToken(@RequestParam String username) {
        try {
            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok().body(token);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error generating token");
        }
    }
}
