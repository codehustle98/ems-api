package com.codehustle.ems.controller;

import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Attendance;
import com.codehustle.ems.service.AttendanceService;
import jdk.vm.ci.meta.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @PutMapping(value = "/regularize")
    public void regularizeAttendance(@RequestParam(name="checkInTime",required = true)LocalDateTime checkinTime,
                                     @RequestParam(name="checkOutTime",required = true) LocalDateTime checkOutTime,
                                     @RequestParam(name="attendanceId",required = false) Long attandanceId,
                                     @RequestParam(name="employeeId",required = false)Long empId,
                                     @RequestParam(name = "attendanceDate",required = false)LocalDate attendanceDate) throws ServiceException {
            attendanceService.regularizeAttendance(checkinTime,checkOutTime,attandanceId,empId,attendanceDate);
    }
}
