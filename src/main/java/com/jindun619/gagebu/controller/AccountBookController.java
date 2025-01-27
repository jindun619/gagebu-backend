package com.jindun619.gagebu.controller;

import com.jindun619.gagebu.entity.AccountBook;
import com.jindun619.gagebu.service.AccountBookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/records")
@RequestMapping("/records")
public class AccountBookController {
    private final AccountBookService service;

    public AccountBookController(AccountBookService service) {
        this.service = service;
    }

    @GetMapping
    public List<AccountBook> getRecords() {
        return service.getAllRecords();
    }

    @PostMapping
    public ResponseEntity<String> addRecord(@RequestBody @Valid AccountBook record, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()).append(" "));
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addRecord(record).toString());
    }
}
