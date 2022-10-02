package com.codehustle.ems.controller;

import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Department;
import com.codehustle.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addDepartment(@RequestBody Department department) throws ServiceException {
        departmentService.addDepartment(department);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateDepartment(@RequestBody Department department) throws ServiceException {
        departmentService.updateDepartment(department);
    }

    @DeleteMapping("/{deptId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDepartment(@PathVariable("deptId")Long deptId) throws ServiceException {
        departmentService.deleteDepartment(deptId);
    }
}
