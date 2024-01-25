package com.harshmali.ratingservice.controllers;


import com.harshmali.ratingservice.model.Rating;
import com.harshmali.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rating")
public class RatingController {

    @Autowired
    RatingService rs;


    @PostMapping("/createRating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){

        return ResponseEntity.status(HttpStatus.CREATED).body(rs.createRating(rating));


    }

    @GetMapping("allRatings")

    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.ok(rs.allratings());

    }

    @GetMapping("userRating/{userId}")

    public ResponseEntity<List<Rating>> userRating(@PathVariable String userId){
        return ResponseEntity.ok(rs.userRating(userId));
    }

    @GetMapping("hotelRating/{hotelId}")

    public ResponseEntity<List<Rating>> hotelRating(@PathVariable String hotelId){
        return ResponseEntity.ok(rs.hotelRatings(hotelId));
    }

}
