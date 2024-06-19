package com.musa.spring.impl;

import com.musa.spring.entity.Company;
import com.musa.spring.entity.Review;
import com.musa.spring.repo.CompanyRepository;
import com.musa.spring.repo.ReviewRepository;
import com.musa.spring.service.CompanyService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl {
    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }
    public List<Review> getAllReviews(Long companyId){
        List<Review> reviews = ReviewRepository.findByCompanyId(companyId);
            return reviews;
        }
    }
//    public boolean addReview(Long companyId, Review review){
//    }
//    Review getReview(Long companyId, Long reviewId);
//    boolean updateReview(Long companyId, Long reviewId, Review review);
//    boolean deleteReview(Long companyId, Long reviewId);
//}
