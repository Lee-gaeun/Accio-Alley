package org.scoula.cart.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartVO {
    private Long cartId;
    private Long userId;
    private Long productId;
    private int quantity;
    private Boolean isOrdered;

    // 상품 정보
    private String productName;
    private Integer price;
}
