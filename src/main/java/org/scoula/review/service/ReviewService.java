package org.scoula.review.service;

import org.scoula.review.dto.ReviewDTO;
import java.util.List;

public interface ReviewService {
    void createReview(ReviewDTO reviewDTO);
    List<ReviewDTO> getReviews(Long productId);
    void updateReview(ReviewDTO reviewDTO);
    void deleteReview(Long reviewId);
}