package org.scoula.product.controller;


import org.scoula.product.dto.ProductDTO;
import org.scoula.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getProductDtoList();
    }

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable("id") Long productId) {
        return productService.getProductById(productId);
    }
}
