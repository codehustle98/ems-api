package com.codehustle.ems.service.impl;

import com.codehustle.ems.entity.AttendanceEntity;
import com.codehustle.ems.model.Attendance;
import com.codehustle.ems.repository.AttendanceRepository;
import com.codehustle.ems.service.AttendanceService;
import com.codehustle.ems.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private MapperService mapperService;

    @Override
    public void addAttendance(Attendance attendance) {
        AttendanceEntity attendanceEntity = mapperService.map(attendance,AttendanceEntity.class);
        attendanceRepository.save(attendanceEntity);
    }
}
