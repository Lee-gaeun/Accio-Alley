package org.scoula.product.domain;

import lombok.Data;

// VO -> DB 테이블과 1:1 매핑, DB 데이터를 담기 위한 객체!
// DB 테이블의 한 줄(ROW)을 자바 객체로 담는 그릇 역할
// DB처리 용도의 Object
// 변환작업은 service에서 용도에 따라 바꿔줌
@Data
public class ProductVO {
    private Long productId;
    private String productName;
    private String description;
    private int price;
    private int quantity;
}
