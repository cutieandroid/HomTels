package com.harshmali.userservice.controllers;


import com.harshmali.userservice.model.AppUsers;
import com.harshmali.userservice.services.UserServices;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("user")
public class Appuserscontroller {

    @Autowired
    private UserServices us;

    @PostMapping("adduser")
    public ResponseEntity<AppUsers> saveuser(@RequestBody AppUsers appuser) {

        AppUsers user= us.saveuser(appuser);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


    @GetMapping("getuser/{userid}")
    @RateLimiter(name="userratelimiter",fallbackMethod = "fallback")
    public ResponseEntity<AppUsers> getuser(@PathVariable String userid) throws Throwable {

        AppUsers user=us.getUser(userid);
        return ResponseEntity.ok(user);

    }
    public ResponseEntity<AppUsers> fallback(String userid, Exception ex){
        AppUsers user=new AppUsers();
        return new ResponseEntity<>(user, HttpStatus.GATEWAY_TIMEOUT);

    }
    @GetMapping("getallusers")
    @RateLimiter(name="userratelimiter",fallbackMethod = "rmfallback")
        public ResponseEntity<List<AppUsers>> getallusers(){

        List<AppUsers>allusers=us.getAllUsers();
        return ResponseEntity.ok(allusers);

        }

    public ResponseEntity<List<AppUsers>> rmfallback(String userid, Exception ex){
        AppUsers user=new AppUsers();
        AppUsers user1=new AppUsers();
        AppUsers user2=new AppUsers();
        List<AppUsers> newlist=List.of(user,user1,user2);
        return new ResponseEntity<>(newlist, HttpStatus.OK);

    }
    }


