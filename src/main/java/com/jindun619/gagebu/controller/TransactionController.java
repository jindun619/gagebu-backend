package com.jindun619.gagebu.controller;
//

import com.jindun619.gagebu.dto.CategoryTotalAmountDTO;
import com.jindun619.gagebu.dto.TransactionUpdateDTO;
import com.jindun619.gagebu.entity.Transaction;
import com.jindun619.gagebu.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service, TransactionService transactionService) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> addTransaction(@RequestBody @Valid Transaction transaction, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()).append(" "));
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        Transaction createdTransaction = service.addTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(
            @RequestParam(defaultValue = "date") String sortBy,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(defaultValue = "0000-01-01", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(defaultValue = "2100-01-01", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "0", required = false) BigDecimal minAmount,
            @RequestParam(defaultValue = "99999999", required = false) BigDecimal maxAmount,
            @RequestParam(required = false) String currency,
            @RequestParam(required = false) String transactionType
            ) {
        List<Transaction> allTransactions = service.getAllTransactions(
                sortBy,
                direction,
                startDate,
                endDate,
                category,
                minAmount,
                maxAmount,
                currency,
                transactionType
        );
        return ResponseEntity.status(HttpStatus.OK).body(allTransactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Optional<Transaction> transaction = service.getTransactionById(id);
        if (transaction.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(transaction.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/category-wise-amount")
    public List<CategoryTotalAmountDTO> getCategoryWiseTotalAmount(
            @RequestParam(defaultValue = "0000-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(defaultValue = "2100-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return service.getCategoryWiseTotalAmount(startDate, endDate);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateTransaction(@PathVariable Long id, @RequestBody @Valid TransactionUpdateDTO transaction, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()).append(" "));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.toString());
        }

        boolean didSuccess = service.updateTransaction(id, transaction);
        System.out.println(didSuccess);
        if (didSuccess) {
            return ResponseEntity.status(HttpStatus.OK).body("id " + id + " updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id " + id + " update failed");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id) {
        boolean deleted = service.deleteTransaction(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).body("id " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id " + id + " delete failed");
        }
    }

}
