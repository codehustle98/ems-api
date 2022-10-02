package com.codehustle.ems.service;

import com.codehustle.ems.exceptions.ServiceException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface AttendanceService {

    void addAttendance(Long empId);

    void addCheckoutAttendance(Long attendanceId) throws ServiceException;
    void regularizeAttendance(LocalDateTime checkinTime, LocalDateTime checkOutTime, Long attandanceId, Long empId, LocalDate attendanceDate) throws ServiceException;
}
