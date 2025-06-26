package org.scoula.cart.service;

import org.scoula.cart.domain.CartVO;
import org.scoula.cart.dto.CartDTO;
import org.scoula.cart.mapper.CartMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService{
    private final CartMapper cartMapper;

    public CartServiceImpl(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    // 장바구니 상품 담기
    @Override
    public CartDTO addToCart(CartDTO cartDTO) {
        // 1) 이미 존재하는지 체크
        List<CartVO> existingCarts = cartMapper.getCart(cartDTO.getUserId());
        Optional<CartVO> existingCart = existingCarts.stream()
                .filter(c -> c.getProductId().equals(cartDTO.getProductId()))
                .findFirst();

        if (existingCart.isPresent()) {
            // 2) 있으면 수량 업데이트
            CartVO cartVO = existingCart.get();
            int newQuantity = cartVO.getQuantity() + cartDTO.getQuantity();
            cartMapper.updateQuantity(cartVO.getCartId(), newQuantity);

            // 업데이트 후 반환할 DTO 생성
            cartVO.setQuantity(newQuantity);
            return CartDTO.fromVO(cartVO);
        } else {
            // 3) 없으면 새로 추가
            CartVO vo = cartDTO.toVO();
            cartMapper.addToCart(vo);
            return CartDTO.fromVO(vo);
        }
    }

    // 특정 유저 장바구니 조회
    @Override
    public List<CartDTO> getCart(Long userId) {
        List<CartVO> voList = cartMapper.getCart(userId);
        return voList.stream()
                .map(CartDTO::fromVO)
                .collect(Collectors.toList());
    }

    // 수량 업데이트
    @Override
    public CartDTO updateQuantity(Long cartId, Map<String, Integer> quantityUpdate) {
        Integer quantity = quantityUpdate.get("quantity");
        if (quantity == null) {
            throw new IllegalArgumentException("quantity is required");
        }
        cartMapper.updateQuantity(cartId, quantity);
        CartVO updatedVO = new CartVO();
        updatedVO.setCartId(cartId);
        updatedVO.setQuantity(quantity);
        return CartDTO.fromVO(updatedVO);
    }

    // 특정 상품 삭제
    @Override
    public void deleteCartItem(Long cartId) {
        cartMapper.deleteCartItem(cartId);
    }
}
