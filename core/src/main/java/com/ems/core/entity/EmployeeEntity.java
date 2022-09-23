package com.ems.core.entity;

import com.ems.commons.constants.ApplicationConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "emp_name",nullable = false,insertable = true,updatable = true,length = 25)
    private String empName;

    @Column(name = "emp_email_id",nullable = false,insertable = true,updatable = true,unique = true)
    private String empEmailId;

    @Column(name = "emp_phone_no",nullable = false,insertable = true,updatable = true,unique = true)
    private String empPhoneNo;

    @Column(name = "emp_dob",nullable = false,updatable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = ApplicationConstants.DATE_FORMAT)
    private LocalDate empDob;

    @Column(name = "emp_join_date",nullable = false,updatable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = ApplicationConstants.DATE_FORMAT)
    private LocalDate empJoinDate;
}
