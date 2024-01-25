package com.harshmali.ratingservice.repositories;

import com.harshmali.ratingservice.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRespository extends MongoRepository<Rating,String> {

    List<Rating> findByUserId(String userId);

        List<Rating> findByHotelId(String hotellId);
}
