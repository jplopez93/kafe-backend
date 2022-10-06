package com.kafe.kafe.dto.response;

import com.kafe.kafe.entity.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private String name;
    private ProductCategory category;
    private String description;
}
