package com.jindun619.gagebu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "내용(content)은 필수입니다.")
    @Size(min = 1, message = "내용(content)은 비어 있을 수 없습니다.")
    private String content;

    @NotNull(message = "날짜(date)는 필수입니다.")
    private LocalDate date;

    @NotNull(message = "카테고리(category)는 필수입니다.")
    @Size(min = 1, message = "카테고리(category)는 비어 있을 수 없습니다.")
    private String category;

    @NotNull(message = "금액(amount)은 필수입니다.")
    @DecimalMin(value = "0.01", message = "금액(amount)은 0보다 커야 합니다.")
    private BigDecimal amount;

    @NotNull(message = "통화(currency)는 필수입니다.")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @NotNull(message = "설명(description)은 필수입니다.")
    @Size(min = 1, message = "설명(description)은 비어 있을 수 없습니다.")
    private String description;

    @NotNull(message = "거래 유형(type)은 필수입니다.")
    @Enumerated(EnumType.STRING)
    private TransactionType type;


    // Getter 및 Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
