package com.jindun619.gagebu.service;

import com.jindun619.gagebu.entity.Currency;
import com.jindun619.gagebu.entity.Transaction;
import com.jindun619.gagebu.entity.TransactionType;
import com.jindun619.gagebu.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional // 테스트 후 롤백하여 DB 상태를 유지
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;

    private Transaction transaction;

    @BeforeEach
    void setUp() {
        // 테스트용 데이터 준비
        transaction = new Transaction();
        transaction.setContent("Test Transaction");
        transaction.setDate(LocalDate.now());
        transaction.setCategory("Test Category");
        transaction.setAmount(BigDecimal.valueOf(1000));
        transaction.setCurrency(Currency.KRW);
        transaction.setDescription("Test Description");
        transaction.setType(TransactionType.EXPENSE);
    }

    @Test
    void testAddTransaction() {
        Transaction savedTransaction = transactionService.addTransaction(transaction);

        assertThat(savedTransaction).isNotNull();
        assertThat(savedTransaction.getId()).isNotNull();
        assertThat(savedTransaction.getContent()).isEqualTo(transaction.getContent());
    }

    @Test
    void testGetAllTransactions() {
        transactionService.addTransaction(transaction);
        List<Transaction> transactions = transactionService.getAllTransactions();

        assertThat(transactions).isNotEmpty();
        assertThat(transactions.size()).isGreaterThan(0);
    }

    @Test
    void testGetTransactionById() {
        Transaction savedTransaction = transactionService.addTransaction(transaction);

        Optional<Transaction> retrievedTransaction = transactionRepository.findById(savedTransaction.getId());
        assertThat(retrievedTransaction).isPresent();
        assertThat(retrievedTransaction.get().getId()).isEqualTo(savedTransaction.getId());
    }

    @Test
    void testUpdateTransaction() {
        Transaction savedTransaction = transactionService.addTransaction(transaction);
        savedTransaction.setContent("Updated Content");

        boolean updatedTransaction = transactionService.updateTransaction(savedTransaction.getId(), savedTransaction);

        assertThat(updatedTransaction).isEqualTo(true);
    }

    @Test
    void testDeleteTransaction() {
        Transaction savedTransaction = transactionService.addTransaction(transaction);

        transactionService.deleteTransaction(savedTransaction.getId());

        Optional<Transaction> deletedTransaction = transactionRepository.findById(savedTransaction.getId());
        assertThat(deletedTransaction).isNotPresent();
    }

}
