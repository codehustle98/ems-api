package com.ems.web.service.impl;

import com.ems.commons.constants.MessageConstants;
import com.ems.commons.exceptions.ConflictException;
import com.ems.commons.exceptions.ServiceException;
import com.ems.core.entity.EmployeeEntity;
import com.ems.core.model.Employee;
import com.ems.core.repository.EmployeeRepository;
import com.ems.web.service.EmployeeService;
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
