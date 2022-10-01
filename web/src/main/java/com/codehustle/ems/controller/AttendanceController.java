package com.codehustle.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/attendance")
public class AttendanceController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addAttendance(){

    }
}
