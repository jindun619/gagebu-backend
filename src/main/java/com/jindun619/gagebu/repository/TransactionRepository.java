package com.jindun619.gagebu.repository;

import com.jindun619.gagebu.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
