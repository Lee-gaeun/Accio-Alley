package org.scoula.review.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.scoula.review.domain.ReviewVO;

import java.util.List;

@Mapper
public interface ReviewMapper {
    void insertReview(ReviewVO review);
    List<ReviewVO> selectByProductId(Long productId);
    void updateReview(ReviewVO review);
    void deleteReview(Long reviewId);
}