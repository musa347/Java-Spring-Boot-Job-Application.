package com.musa.spring.repo;

import com.musa.spring.entity.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
    static List<Review> findByCompanyId(Long companyId) {
        return List.of(new Review());
    }
}
