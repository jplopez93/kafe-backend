package com.kafe.kafe.dto.request;

import com.kafe.kafe.entity.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductRequestDTO {
    private String name;
    private ProductCategory category;
    private BigDecimal priceByCm;
    private String description;
}
