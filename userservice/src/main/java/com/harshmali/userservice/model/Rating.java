package com.harshmali.userservice.model;

import lombok.Data;

@Data

public class Rating {
    private String userId;
    private String hotelId;
    private String ratingId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
