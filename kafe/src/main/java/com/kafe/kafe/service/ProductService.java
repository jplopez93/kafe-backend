package com.kafe.kafe.service;

import com.kafe.kafe.dto.response.ProductResponseDTO;
import com.kafe.kafe.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    Product saveProduct(Product product);
}
