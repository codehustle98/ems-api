package com.codehustle.ems.service.impl;

import com.codehustle.ems.constants.MessageConstants;
import com.codehustle.ems.entity.AttendanceEntity;
import com.codehustle.ems.entity.EmployeeEntity;
import com.codehustle.ems.exceptions.NotFoundException;
import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Employee;
import com.codehustle.ems.repository.AttendanceRepository;
import com.codehustle.ems.service.AttendanceService;
import com.codehustle.ems.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public void addAttendance(Long empId) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setEmpId(empId);
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        attendanceEntity.setAttendanceDate(LocalDate.now());
        attendanceEntity.setCheckinTime(LocalDateTime.now());
        attendanceEntity.setEmployee(entity);
        attendanceRepository.save(attendanceEntity);
    }

    @Override
    public void addCheckoutAttendance(Long attendanceId) throws ServiceException {
        try {
            AttendanceEntity attendanceEntity = attendanceRepository.findById(attendanceId)
                    .orElseThrow(NotFoundException::new);
            attendanceEntity.setCheckoutTime(LocalDateTime.now());
            attendanceRepository.save(attendanceEntity);
        }catch (Exception e){
            throw new ServiceException(e);
        }
    }

    @Override
    public void regularizeAttendance(LocalDateTime checkinTime, LocalDateTime checkOutTime, Long attandanceId, Long empId, LocalDate attendanceDate) throws ServiceException {
        try{
            if(attandanceId!=null)
            {
                AttendanceEntity attendanceEntity= attendanceRepository.findById(attandanceId).orElseThrow(NotFoundException::new);
                attendanceEntity.setCheckinTime(checkinTime);
                attendanceEntity.setCheckoutTime(checkOutTime);
                attendanceRepository.save(attendanceEntity);
            }
            else
            {
                EmployeeEntity employeeEntity= new EmployeeEntity();
                employeeEntity.setEmpId(empId);
                AttendanceEntity attendanceEntity= new AttendanceEntity();
                attendanceEntity.setCheckinTime(checkinTime);
                attendanceEntity.setCheckoutTime(checkOutTime);
                attendanceEntity.setAttendanceDate(attendanceDate);
                attendanceEntity.setEmployee(employeeEntity);
                attendanceRepository.save(attendanceEntity);
            }
        }
        catch (Exception e){
                throw new ServiceException(e);
        }
    }
}
