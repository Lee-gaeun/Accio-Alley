package org.scoula.review.service;

import lombok.RequiredArgsConstructor;
import org.scoula.review.domain.ReviewVO;
import org.scoula.review.dto.ReviewDTO;
import org.scoula.review.mapper.ReviewMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;

    @Override
    public void createReview(ReviewDTO dto) {
        ReviewVO vo = convertToVO(dto);
        reviewMapper.insertReview(vo);
    }

    @Override
    public List<ReviewDTO> getReviews(Long productId) {
        return reviewMapper.selectByProductId(productId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void updateReview(ReviewDTO dto) {
        ReviewVO vo = convertToVO(dto);
        reviewMapper.updateReview(vo);
    }

    @Override
    public void deleteReview(Long reviewId) {
        reviewMapper.deleteReview(reviewId);
    }

    // DTO → VO 변환
    private ReviewVO convertToVO(ReviewDTO dto) {
        return ReviewVO.builder()
                .reviewId(dto.getReviewId())
                .userId(dto.getUserId())
                .productId(dto.getProductId())
                .rating(dto.getRating())
                .comment(dto.getComment())
                .build();
    }

    // VO → DTO 변환
    private ReviewDTO convertToDTO(ReviewVO vo) {
        return ReviewDTO.builder()
                .reviewId(vo.getReviewId())
                .userId(vo.getUserId())
                .productId(vo.getProductId())
                .rating(vo.getRating())
                .comment(vo.getComment())
                .build();
    }
}