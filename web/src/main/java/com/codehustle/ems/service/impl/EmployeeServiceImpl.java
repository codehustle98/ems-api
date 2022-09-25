package com.codehustle.ems.service.impl;

import com.codehustle.ems.constants.MessageConstants;
import com.codehustle.ems.entity.EmployeeEntity;
import com.codehustle.ems.exceptions.ConflictException;
import com.codehustle.ems.exceptions.NotFoundException;
import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Employee;
import com.codehustle.ems.repository.EmployeeRepository;
import com.codehustle.ems.service.EmployeeService;
import com.codehustle.ems.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private MapperService mapperService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(Employee employee) throws ServiceException {
        try{
            EmployeeEntity employeeEntity = mapperService.map(employee,EmployeeEntity.class);
            if(employeeEntity != null){
                EmployeeEntity existingUser = employeeRepository.findByEmpEmailIdOrEmpPhoneNo(employeeEntity.getEmpEmailId(),employeeEntity.getEmpPhoneNo());
                if(existingUser != null)
                    throw new ConflictException(MessageConstants.USER_EXISTS);
                employeeRepository.save(employeeEntity);
            }
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return mapperService.map(employeeRepository.findAll(),Employee.class);
    }

    @Override
    public void updateEmployee(Employee employee) throws ServiceException {
        try{
            EmployeeEntity existingEmployee = employeeRepository.findByEmpId(employee.getEmpId());
            if(existingEmployee == null)
                throw new NotFoundException(MessageConstants.USER_NOT_FOUND);
            EmployeeEntity updatedEmployeeDetails = mapperService.map(employee,EmployeeEntity.class);
            employeeRepository.save(updatedEmployeeDetails);
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }
}
