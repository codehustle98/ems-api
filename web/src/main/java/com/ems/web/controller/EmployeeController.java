package com.ems.web.controller;

import com.ems.commons.exceptions.ServiceException;
import com.ems.core.model.Employee;
import com.ems.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee) throws ServiceException {
        employeeService.addEmployee(employee);
    }
}
