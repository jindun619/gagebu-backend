package com.jindun619.gagebu.dto;

import com.jindun619.gagebu.entity.Currency;
import com.jindun619.gagebu.entity.TransactionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionUpdateDTO {

    @Size(min = 1, message = "내용(content)은 비어 있을 수 없습니다.")
    private String content;

    private LocalDate date;

    @Size(min = 1, message = "카테고리(category)는 비어 있을 수 없습니다.")
    private String category;

    @DecimalMin(value = "0.01", message = "금액(amount)은 0보다 커야 합니다.")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private String description;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    // Getter 및 Setter
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
