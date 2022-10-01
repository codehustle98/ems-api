package com.codehustle.ems.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Department {

    private Long deptId;
    private String deptCode;
    private String deptName;
}
