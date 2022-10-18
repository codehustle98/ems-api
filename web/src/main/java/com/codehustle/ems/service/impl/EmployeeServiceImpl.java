package com.codehustle.ems.service.impl;

import com.codehustle.ems.constants.MessageConstants;
import com.codehustle.ems.entity.EmployeeEntity;
import com.codehustle.ems.exceptions.ConflictException;
import com.codehustle.ems.exceptions.NotFoundException;
import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Employee;
import com.codehustle.ems.model.User;
import com.codehustle.ems.repository.EmployeeRepository;
import com.codehustle.ems.service.EmployeeService;
import com.codehustle.ems.service.MapperService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;
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
    public void deleteEmployee(Long empid) throws ServiceException {
        try {
            EmployeeEntity existingUser = employeeRepository.findByEmpId(empid);
           if(existingUser==null)
               throw new NotFoundException(MessageConstants.USER_NOT_FOUND);
           employeeRepository.deleteById(empid);
        } catch (NotFoundException e) {
            e.printStackTrace();
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

    @Override
    public Employee signUpUser(Employee employee) throws ServiceException {
        try{
            EmployeeEntity existingUser = employeeRepository.findByEmpEmailIdOrEmpPhoneNo(employee.getEmpEmailId(),employee.getEmpPhoneNo());
            if(existingUser != null)
                throw new ConflictException(MessageConstants.USER_EXISTS);
            employee.setLoginPassword(new Base64().encodeToString(employee.getLoginPassword().getBytes()));
            EmployeeEntity employeeEntity = mapperService.map(employee,EmployeeEntity.class);
            return mapperService.map(employeeRepository.save(employeeEntity),Employee.class);
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Employee loginUser(User employee) throws ServiceException {
        try{
            EmployeeEntity user = employeeRepository.findByEmpEmailId(employee.getEmpEmailId());
            if(user == null)
                throw new NotFoundException(MessageConstants.INVALID_CREDENTIALS);
            byte[] decodedPassword = new Base64().decode(user.getLoginPassword());
            if(employee.getLoginPassword().equals(new String(decodedPassword))){
                return mapperService.map(user,Employee.class);
            }else{
                throw new AuthException(MessageConstants.INVALID_PASSWORD);
            }
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }
}
