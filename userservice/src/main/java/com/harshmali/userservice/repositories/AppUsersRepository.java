package com.harshmali.userservice.repositories;

import com.harshmali.userservice.model.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AppUsersRepository extends JpaRepository< AppUsers, String> {
}
