package org.scoula.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.cart.domain.CartVO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {
    private Long cartId;
    private Long userId;
    private Long productId;
    private int quantity;
    private Boolean isOrdered;

    // 상품 정보
    private String productName;
    private Integer price;

    // VO -> DTO 변환
    public static CartDTO fromVO(CartVO vo){
        return vo == null ? null : CartDTO.builder()
                .cartId(vo.getCartId())
                .userId(vo.getUserId())
                .productId(vo.getProductId())
                .quantity(vo.getQuantity())
                .isOrdered(vo.getIsOrdered())
                .productName(vo.getProductName())
                .price(vo.getPrice())
                .build();
    }

    // DTO -> VO 변환
    public CartVO toVO(){
        return CartVO.builder()
                .cartId(this.cartId)
                .userId(this.userId)
                .productId(this.productId)
                .quantity(this.quantity)
                .isOrdered(this.isOrdered)
                .productName(this.productName)
                .price(this.price)
                .build();
    }
}
