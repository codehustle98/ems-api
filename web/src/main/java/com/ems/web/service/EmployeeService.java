package com.ems.web.service;

import com.ems.commons.exceptions.ServiceException;
import com.ems.core.model.Employee;

public interface EmployeeService {

    public void addEmployee(Employee employee) throws ServiceException;
}
