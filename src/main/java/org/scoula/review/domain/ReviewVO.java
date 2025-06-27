package org.scoula.review.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewVO {
    private Long reviewId;
    private Long userId;
    private Long productId;
    private int rating;
    private String comment;
}