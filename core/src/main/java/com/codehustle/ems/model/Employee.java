package com.codehustle.ems.model;

import com.codehustle.ems.annotations.ValidEmail;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ValidEmail
    private String empEmailId;
    private String empPhoneNo;
    private LocalDate empDob;
    private LocalDate empJoinDate;
    private String empType;
    @JsonIgnore
    private String loginPassword;
    private Department department;
}
