package com.codehustle.ems.service;

import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Department;

import java.security.Provider;

public interface DepartmentService {

    void addDepartment(Department department) throws ServiceException;
}
