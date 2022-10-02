package com.codehustle.ems.controller;

import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Attendance;
import com.codehustle.ems.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping(value = "{empId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAttendance(@PathVariable(name = "empId")Long empId){
        attendanceService.addAttendance(empId);
    }

    @PutMapping(value = "{attendanceId}")
    @ResponseStatus(HttpStatus.OK)
    public void addCheckOutAttendance(@PathVariable(name = "attendanceId")Long attendanceId) throws ServiceException {
        attendanceService.addCheckoutAttendance(attendanceId);
    }
}
