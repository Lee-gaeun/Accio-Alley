package org.scoula.review.service;

import lombok.RequiredArgsConstructor;
import org.scoula.review.domain.ReviewVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final org.scoula.review.mapper.ReviewMapper reviewMapper;

    @Override
    public void createReview(ReviewVO review) {
        reviewMapper.insertReview(review);
    }

    @Override
    public List<ReviewVO> getReviews(Long productId) {
        return reviewMapper.selectByProductId(productId);
    }

    @Override
    public void updateReview(ReviewVO review) {
        reviewMapper.updateReview(review);
    }

    @Override
    public void deleteReview(Long reviewId) {
        reviewMapper.deleteReview(reviewId);
    }
}