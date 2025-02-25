package com.jindun619.gagebu.repository;

import com.jindun619.gagebu.dto.CategoryTotalAmountDTO;
import com.jindun619.gagebu.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {
    @Query("SELECT new com.jindun619.gagebu.dto.CategoryTotalAmountDTO(e.category, SUM(e.amount)) " +
            "FROM Transaction e " +
            "WHERE e.date BETWEEN :startDate AND :endDate " +
            "GROUP BY e.category")
    List<CategoryTotalAmountDTO> findCategoryWiseTotalAmount(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
