package com.jindun619.gagebu.service;

import com.jindun619.gagebu.entity.AccountBook;
import com.jindun619.gagebu.repository.AccountBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountBookService {
    private final AccountBookRepository repository;

    public AccountBookService(AccountBookRepository repository) {
        this.repository = repository;
    }

    public List<AccountBook> getAllRecords() {
        return repository.findAll();
    }

    public AccountBook addRecord(AccountBook record) {
        return repository.save(record);
    }
}
