package com.codehustle.ems.service.impl;

import com.codehustle.ems.service.EmployeeService;
import com.codehustle.ems.constants.MessageConstants;
import com.codehustle.ems.exceptions.ConflictException;
import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.entity.EmployeeEntity;
import com.codehustle.ems.model.Employee;
import com.codehustle.ems.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(Employee employee) throws ServiceException {
        try{
            EmployeeEntity employeeEntity = modelMapper.map(employee,EmployeeEntity.class);
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
}
