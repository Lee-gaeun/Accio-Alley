package org.scoula.review.domain;

import lombok.Data;

@Data
public class ReviewVO {
    private Long reviewId;
    private Long userId;
    private Long productId;
    private int rating;
    private String coment;
}