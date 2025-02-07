package com.jindun619.gagebu.specification;

import com.jindun619.gagebu.entity.Transaction;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionSpecification {
    public static Specification<Transaction> hasDateBetween(LocalDate startDate, LocalDate endDate) {
        return (root, query, criteriaBuilder) -> {
            if (startDate == null || endDate == null) return null;
            return criteriaBuilder.between(root.get("date"), startDate, endDate);
        };
    }

    public static Specification<Transaction> hasCategory(String category) {
        return (root, query, criteriaBuilder) ->
                category == null ? null : criteriaBuilder.equal(root.get("category"), category);
    }

    public static Specification<Transaction> hasAmountBetween(BigDecimal minAmount, BigDecimal maxAmount) {
        return (root, query, criteriaBuilder) -> {
            if (minAmount == null || maxAmount == null) return null;
            return criteriaBuilder.between(root.get("amount"), minAmount, maxAmount);
        };
    }

    public static Specification<Transaction> hasCurrency(String currency) {
        return (root, query, criteriaBuilder) ->
                currency == null ? null : criteriaBuilder.equal(root.get("currency"), currency);
    }

    public static Specification<Transaction> hasTransactionType(String transactionType) {
        return (root, query, criteriaBuilder) ->
                transactionType == null ? null : criteriaBuilder.equal(root.get("transactionType"), transactionType);
    }

}
