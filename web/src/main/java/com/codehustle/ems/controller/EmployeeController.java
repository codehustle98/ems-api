package com.codehustle.ems.controller;

import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Employee;
import com.codehustle.ems.model.User;
import com.codehustle.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/employee")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody @Valid Employee employee) throws ServiceException {
        employeeService.addEmployee(employee);
    }


    @DeleteMapping("/delete/{empid}")
    public void deleteEmployee(@PathVariable Long empid) throws ServiceException {
        employeeService.deleteEmployee(empid);
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

    @PostMapping(value = "/signup")
    public ResponseEntity<Employee> signUpUser(@RequestBody Employee employee) throws ServiceException {
        return ResponseEntity.ok().body(employeeService.signUpUser(employee));
    }

    @GetMapping(value = "/login")
    public ResponseEntity<Employee> loginUser(@RequestBody User user) throws ServiceException {
        return ResponseEntity.ok().body(employeeService.loginUser(user));
    }
}
