package com.example.gamestore.services;

import com.example.gamestore.model.Review;
import com.example.gamestore.repositories.ReviewRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepo reviewRepository;

    public ReviewService(ReviewRepo reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return this.reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return this.reviewRepository.findById(id);
    }

    public Review saveReview(Review review) {
        return (Review)this.reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        this.reviewRepository.deleteById(id);
    }
}
