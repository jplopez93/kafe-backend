package com.kafe.kafe.controller;

import com.kafe.kafe.dto.request.ProductRequestDTO;
import com.kafe.kafe.dto.response.ProductResponseDTO;
import com.kafe.kafe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/prices/{max}/{min}")
    public ResponseEntity<List<ProductResponseDTO>> getAllProductsByPriceRange(@PathVariable BigDecimal max, @PathVariable BigDecimal min) {
        return new ResponseEntity<>(productService.getAllProductsByPriceRange(max, min), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/product/save")
    public ResponseEntity<ProductResponseDTO> saveProduct(@RequestBody ProductRequestDTO product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody ProductRequestDTO product, @PathVariable Integer id) {
        return new ResponseEntity<>(productService.updateProduct(product, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Map<String, Integer>> deleteProduct(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }

}
