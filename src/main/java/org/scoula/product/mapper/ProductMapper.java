package org.scoula.product.mapper;

import org.scoula.product.domain.ProductVO;

import java.util.List;

public interface ProductMapper {
    List<ProductVO> getProductList();
    ProductVO getProductById(Long productId);
}
