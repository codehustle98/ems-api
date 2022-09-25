package com.codehustle.ems.controller;

import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Employee;
import com.codehustle.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@RequestBody Employee employee) throws ServiceException {
        employeeService.updateEmployee(employee);
    }
}
