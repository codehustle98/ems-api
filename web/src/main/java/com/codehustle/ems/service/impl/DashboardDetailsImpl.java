package com.codehustle.ems.service.impl;

import com.codehustle.ems.model.Dashboard;
import com.codehustle.ems.repository.DepartmentRepository;
import com.codehustle.ems.repository.EmployeeRepository;
import com.codehustle.ems.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DashboardDetailsImpl implements DashboardService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Dashboard getDashboardDetails() {
        Dashboard dashboard = new Dashboard();
        dashboard.setEmployeeNames(employeeRepository.findBirthdayEmployees(LocalDate.now()));
        dashboard.setTotalEmployees(employeeRepository.count());
        dashboard.setTotalDepartments(departmentRepository.count());
        return dashboard;
    }
}
