package com.harshmali.ratingservice.services;

import com.harshmali.ratingservice.config.MyConfig;
import com.harshmali.ratingservice.model.Hotel;
import com.harshmali.ratingservice.model.Rating;
import com.harshmali.ratingservice.repositories.RatingRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class RatingService {

    @Autowired
    RatingRespository rr;

    @Autowired
    RestTemplate rt;



    //create reating

    public Rating createRating(Rating rating){
        return rr.save(rating);

    }

    //getallratings

    public List<Rating> allratings(){
        return rr.findAll();

    }


    //getratingbyuser

    public List<Rating> userRating(String userId){

        List<Rating> ratings= rr.findByUserId(userId);
        ArrayList<Rating> newlist= new ArrayList<>();
        for(Rating r: ratings){
            Hotel hotel= rt.getForObject("http://HOTEL-SERVICE/hotel/getHotel/"+r.getHotelId(), Hotel.class);
            r.setHotel(hotel);
            newlist.add(r);


        }

        return newlist;


    }

    //getratingbyhotel

    public List<Rating> hotelRatings(String hotelId){
        return rr.findByHotelId(hotelId);

    }


}
