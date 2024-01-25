package com.harshmali.hotelservice.controllers;


import com.harshmali.hotelservice.model.Hotel;
import com.harshmali.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel")
public class HotelController {


    @Autowired
    HotelService hs;

    @PostMapping("addHotel")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        return  ResponseEntity.status(HttpStatus.CREATED).body(hs.saveHotel(hotel));

    }

    @GetMapping("getHotel/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        return  ResponseEntity.ok(hs.getHotel(hotelId));

    }

    @GetMapping("getAllHotels")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel>hotels= hs.getallhotels();
        return ResponseEntity.ok(hotels);

    }

}
