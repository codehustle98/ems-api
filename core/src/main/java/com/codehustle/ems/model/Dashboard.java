package com.codehustle.ems.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Dashboard implements Serializable {

    private List<String> employeeNames;
    private Long totalEmployees;
    private Long totalDepartments;
}
