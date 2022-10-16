package com.codehustle.ems.controller;

import com.codehustle.ems.entity.UserEntity;
import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup")
    public ResponseEntity<UserEntity> signUpUser(@RequestBody UserEntity userEntity) throws ServiceException {
        return ResponseEntity.ok().body(userService.signUpUser(userEntity));
    }

    @GetMapping(value = "/login")
    public ResponseEntity<UserEntity> loginUser(@RequestBody UserEntity userEntity) throws ServiceException {
        return ResponseEntity.ok().body(userService.loginUser(userEntity));
    }

}
