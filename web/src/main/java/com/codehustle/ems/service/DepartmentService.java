package com.codehustle.ems.service;

import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Department;

import java.security.Provider;
import java.util.List;

public interface DepartmentService {

    void addDepartment(Department department) throws ServiceException;

    List<Department> getAllDepartments();

    void updateDepartment(Department department) throws ServiceException;

    void deleteDepartment(Long deptId) throws ServiceException;
}
