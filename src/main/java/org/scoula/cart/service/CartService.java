package org.scoula.cart.service;

import org.scoula.cart.dto.CartDTO;

import java.util.List;
import java.util.Map;

public interface CartService {
    // 장바구니 상품 추가
    CartDTO addToCart(CartDTO cartDTO);
    
    // 장바구니 조회
    List<CartDTO> getCart(Long userId);

    // 장바구니 항목 수량 변경
    CartDTO updateQuantity(Long cartId, Map<String, Integer> quantityUpdate);

    // 장바구니 항목 삭제
    void deleteCartItem(Long cartId);
    
}
