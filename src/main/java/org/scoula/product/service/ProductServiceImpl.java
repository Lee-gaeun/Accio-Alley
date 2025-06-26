package org.scoula.product.service;

import org.scoula.product.domain.ProductVO;
import org.scoula.product.dto.ProductDTO;
import org.scoula.product.mapper.ProductMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//BeanUtils는 VO → DTO 변환용
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDTO> getProductDtoList() {
        return productMapper.getProductList()
                .stream()
                .map(vo -> {
                    ProductDTO dto = new ProductDTO();
                    BeanUtils.copyProperties(vo, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        ProductVO vo = productMapper.getProductById(productId);
        ProductDTO dto = new ProductDTO();
        BeanUtils.copyProperties(vo, dto);
        return dto;
    }
}
