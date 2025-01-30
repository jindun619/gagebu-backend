package com.jindun619.gagebu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController {
    @GetMapping
    public ResponseEntity<String> getRoot() {
        return ResponseEntity.status(HttpStatus.OK).body("hi, I'm root");
    }
}
