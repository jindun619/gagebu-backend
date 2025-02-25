package com.jindun619.gagebu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

//@Getter
//@Setter
//@AllArgsConstructor
//public class CategoryTotalAmountDTO {
//    private String category;
//    private BigDecimal totalAmount;
//}

public class CategoryTotalAmountDTO {
    private String category;
    private BigDecimal totalAmount;

    public CategoryTotalAmountDTO(String category, BigDecimal totalAmount) {
        this.category = category;
        this.totalAmount = totalAmount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
