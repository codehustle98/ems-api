package com.codehustle.ems.service;

import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Employee;

import java.util.List;

public interface EmployeeService {

    public void addEmployee(Employee employee) throws ServiceException;

    public void deleteEmployee(Long empid) throws ServiceException;

    List<Employee> getAllEmployees();

    void updateEmployee(Employee employee) throws ServiceException;

}
