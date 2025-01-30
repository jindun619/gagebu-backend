package com.jindun619.gagebu.service;

import com.jindun619.gagebu.entity.Transaction;
import com.jindun619.gagebu.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Transaction addTransaction(Transaction record) {
        return repository.save(record);
    }
}
