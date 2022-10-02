package com.codehustle.ems.service;

import com.codehustle.ems.exceptions.ServiceException;

public interface AttendanceService {

    void addAttendance(Long empId);

    void addCheckoutAttendance(Long attendanceId) throws ServiceException;
}
