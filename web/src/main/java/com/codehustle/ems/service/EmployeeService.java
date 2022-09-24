package com.codehustle.ems.service;

import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Employee;

public interface EmployeeService {

    public void addEmployee(Employee employee) throws ServiceException;
}
