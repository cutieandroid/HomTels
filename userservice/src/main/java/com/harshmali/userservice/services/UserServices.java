package com.harshmali.userservice.services;

import com.harshmali.userservice.exceptions.ResourceNotFound;
import com.harshmali.userservice.model.AppUsers;
import com.harshmali.userservice.model.Rating;
import com.harshmali.userservice.repositories.AppUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class UserServices {

    @Autowired
    private AppUsersRepository ur;
    @Autowired
    RestTemplate restTemplate;

    public AppUsers saveuser(AppUsers appuser){
        String randomuid=UUID.randomUUID().toString();
        appuser.setUserId(randomuid);

        return ur.save(appuser);

    }
    public List<AppUsers> getAllUsers(){

        return ur.findAll();

    }


    public AppUsers getUser(String userId) throws Throwable {
        AppUsers user= ur.findById(userId).orElseThrow(()->new ResourceNotFound("user not found with given id"));
        ArrayList<Rating> ratingsbyuser= restTemplate.getForObject("http://RATING-SERVICE/rating/userRating/"+userId, ArrayList.class);
       /* Arrays.stream(ratingsbyuser).toList();
        ArrayList <Rating>ratinglist= new ArrayList<>();
        for(Rating r : ratingsbyuser){
            Hotel hotel= restTemplate.getForObject("http://localhost:8082/hotel/getHotel/"+r.getHotelId(), Hotel.class);
            r.setHotel(hotel);
            ratinglist.add(r);
        }*/
        user.setRatings(ratingsbyuser);
        return user;



    }


}
