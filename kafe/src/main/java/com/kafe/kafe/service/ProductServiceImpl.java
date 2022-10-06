package com.kafe.kafe.service;

import com.kafe.kafe.dto.response.ProductResponseDTO;
import com.kafe.kafe.entity.Product;
import com.kafe.kafe.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(x -> modelMapper.map(x, ProductResponseDTO.class)).toList();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
