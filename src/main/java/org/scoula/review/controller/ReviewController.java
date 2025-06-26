package org.scoula.review.controller;

import lombok.RequiredArgsConstructor;
import org.scoula.review.dto.ReviewDTO;
import org.scoula.review.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody ReviewDTO reviewDTO) {
        reviewService.createReview(reviewDTO);  // DTO로 서비스에 전달
        return ResponseEntity.ok("리뷰 등록 완료");
    }

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getReviews(@RequestParam("product_id") Long productId) {
        return ResponseEntity.ok(reviewService.getReviews(productId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        reviewDTO.setReviewId(id);  // path variable로 받은 ID 설정
        reviewService.updateReview(reviewDTO);
        return ResponseEntity.ok("리뷰 수정 완료");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok("리뷰 삭제 완료");
    }
}