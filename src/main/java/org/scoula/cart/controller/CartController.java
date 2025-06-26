package org.scoula.cart.controller;


import org.scoula.cart.dto.CartDTO;
import org.scoula.cart.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    // 1) 장바구니 상품 추가
    @PostMapping
    public ResponseEntity<CartDTO> addToCart(@RequestBody CartDTO cartDTO) {
        CartDTO saved = cartService.addToCart(cartDTO);
        return ResponseEntity.ok(saved);
    }

    // 2) 특정 유저 장바구니 조회
    @GetMapping("/{id}")
    public ResponseEntity<List<CartDTO>> getCart(@PathVariable("id") Long userId) {
        List<CartDTO> cartList = cartService.getCart(userId);
        return ResponseEntity.ok(cartList);
    }

    // 3) 장바구니 수량 변경
    @PatchMapping("/{id}")
    public ResponseEntity<CartDTO> updateQuantity(@PathVariable("id") Long cartId,
                                                  @RequestBody Map<String, Integer> quantityUpdate) {
        CartDTO updated = cartService.updateQuantity(cartId, quantityUpdate);
        return ResponseEntity.ok(updated);
    }

    // 4) 장바구니 항목 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable("id") Long cartId) {
        cartService.deleteCartItem(cartId);
        return ResponseEntity.noContent().build();
    }
}
