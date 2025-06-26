package org.scoula.product.dto;

import lombok.Data;

// DTO -> 계층간 데이터 전달 전용, View/Controller와 통신하기 위한 객체!
// 클라이언트에 전달할 데이터 형태
// 데이터 이동할 때 담는 상자
// 변환작업은 service에서 용도에 따라 바꿔줌
@Data
public class ProductDTO {
    private Long productId;
    private String productName;
    private String description;
    private int price;
    private int quantity;
};
