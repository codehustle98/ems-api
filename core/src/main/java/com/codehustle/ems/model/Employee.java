package com.codehustle.ems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    private Long empId;
    private String empName;
    private String empEmailId;
    private String empPhoneNo;
    private LocalDate empDob;
    private LocalDate empJoinDate;
    private String empType;
    private Department department;
}
