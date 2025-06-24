package org.scoula.review.service;

import org.scoula.review.domain.ReviewVO;

import java.util.List;

public interface ReviewService {
    void createReview(ReviewVO review);
    List<ReviewVO> getReviews(Long productId);
    void updateReview(ReviewVO review);
    void deleteReview(Long reviewId);
}