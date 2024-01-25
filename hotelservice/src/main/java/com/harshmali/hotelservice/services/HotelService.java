package com.harshmali.hotelservice.services;

import com.harshmali.hotelservice.Exceptions.ResourceNfException;
import com.harshmali.hotelservice.model.Hotel;
import com.harshmali.hotelservice.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class HotelService {


    @Autowired
    HotelRepository hr;

    public Hotel saveHotel(Hotel hotel){
        hotel.setHotelId(UUID.randomUUID().toString());
        return hr.save(hotel);
    }

    public List<Hotel> getallhotels(){
        return hr.findAll();
    }

    public Hotel getHotel(String hotelId){
        return hr.findById(hotelId).orElseThrow(()->new ResourceNfException("hotel with given id not found"));
    }


}
