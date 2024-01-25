package com.harshmali.ratingservice.model;



import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("userratings")
@Data
public class Rating {

    private String userId;
    private String hotelId;
    @Id
    private String ratingId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
