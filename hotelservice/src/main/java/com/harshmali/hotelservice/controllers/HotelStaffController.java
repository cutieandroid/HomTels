package com.harshmali.hotelservice.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hotelstaff")
public class HotelStaffController {

    @GetMapping("/allstaff")
    public ResponseEntity<List<String>> getStaffs(){
        return ResponseEntity.ok(List.of("Ganesh","Krishna","Shiva","Brahma"));
    }
}
