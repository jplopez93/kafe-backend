package com.kafe.kafe.service;

import com.kafe.kafe.dto.request.ProductRequestDTO;
import com.kafe.kafe.dto.response.ProductResponseDTO;
import com.kafe.kafe.entity.Product;
import com.kafe.kafe.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public ProductResponseDTO saveProduct(ProductRequestDTO product) {
        Product productToSave = modelMapper.map(product, Product.class);
        return modelMapper.map(productRepository.save(productToSave), ProductResponseDTO.class);
    }

    @Override
    public ProductResponseDTO updateProduct(ProductRequestDTO product, Integer id) {
        Product productToUpdate = modelMapper.map(product, Product.class);
        Optional<Product> productInDatabase = productRepository.findById(id);
        Product updatedProduct = null;
        if(productInDatabase.isPresent()) {
            productInDatabase.get().setCategory(productToUpdate.getCategory());
            productInDatabase.get().setDescription(productToUpdate.getDescription());
            productInDatabase.get().setName(productToUpdate.getName());
            productInDatabase.get().setPriceByCm(productToUpdate.getPriceByCm());
            updatedProduct = productRepository.save(productInDatabase.get());
        }
        return modelMapper.map(updatedProduct, ProductResponseDTO.class);
    }

    @Override
    public Map<String, Integer> deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return Map.of("Product deleted", id);
    }

    @Override
    public ProductResponseDTO getProductById(Integer id) {
        return modelMapper.map(productRepository.findById(id).orElse(null), ProductResponseDTO.class);
    }

    @Override
    public List<ProductResponseDTO> getAllProductsByPriceRange(BigDecimal max, BigDecimal min) {
        List<Product> products = productRepository.findByPriceByCmBetween(max, min);
        return products.stream().map(x -> modelMapper.map(x, ProductResponseDTO.class)).collect(Collectors.toList());
    }
}
