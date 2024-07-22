package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
@CrossOrigin
public class HealthController {
    @Operation(summary = "Test api", description = "Test api")
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("Thành công");
    }
}
