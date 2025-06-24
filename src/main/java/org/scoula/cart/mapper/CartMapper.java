package org.scoula.cart.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.scoula.cart.domain.CartVO;

import java.util.List;

@Mapper
public interface CartMapper {
    void addToCart(CartVO cart);

    List<CartVO> getCart(Long userId);

    void updateQuantity(@Param("cartId") Long cartId, @Param("quantity") int quantity);

    void deleteCartItem(Long cartId);
}
