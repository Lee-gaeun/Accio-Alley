package org.scoula.product.service;

import org.scoula.product.dto.ProductDTO;

import java.util.List;

// 구현체가 반드시 따라야할 규칙서
// 클래스끼리 약속잡는 용도
public interface ProductService {
    List<ProductDTO> getProductDtoList();
    ProductDTO getProductById(Long productId);
}
