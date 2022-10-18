package com.codehustle.ems.service;

import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Employee;
import com.codehustle.ems.model.User;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee) throws ServiceException;

    void deleteEmployee(Long empid) throws ServiceException;

    List<Employee> getAllEmployees();

    void updateEmployee(Employee employee) throws ServiceException;

    Employee signUpUser(Employee employee) throws ServiceException;

    Employee loginUser(User employee) throws ServiceException;

}
