package com.rankdat.controllers;

import java.util.List;
import java.util.ArrayList;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rankdat.models.Review;

@RestController
public class ReviewController {

    Logger log = LoggerFactory.getLogger(ReviewController.class);

    List<Review> reviews = new ArrayList<>();

    @GetMapping("/api/reviews")
    public List<Review> getAllReviews() {
        return reviews;
    }

    @GetMapping("/api/review/{id}")
    public ResponseEntity<Review> getReviewId(@PathVariable Long id) {
        log.info("buscando uma review com id: " + id);
        var reviewEncontrada = reviews.stream().filter(r -> r.getId().equals(id)).findFirst();

        if(reviewEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        return ResponseEntity.ok(reviewEncontrada.get());

    }

    @PostMapping("/api/review")
    public ResponseEntity<Review> postReview(@RequestBody Review review) {
        log.info("cadastrando uma review: " + review);

        review.setId(reviews.size() + 1l);
        reviews.add(review);

        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }

    @DeleteMapping("/api/review/{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable Long id) {
        log.info("excluindo uma review com id: " + id);
        var reviewEncontrada = reviews.stream().filter(r -> r.getId().equals(id)).findFirst();
        
        if(reviewEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        reviews.remove(reviewEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/api/review/{id}")
    public ResponseEntity<Review> putReview(@PathVariable Long id, @RequestBody Review review) {
        log.info("alterando uma review com id: " + id);
        var reviewEncontrada = reviews.stream().filter(r -> r.getId().equals(id)).findFirst();

        if(reviewEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        reviews.remove(reviewEncontrada.get());
        review.setId(id);
        reviews.add(review);

        return ResponseEntity.ok(review);

    }
    
}
