package com.codehustle.ems.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "department")
@Data
public class DepartmentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "dept_name",nullable = false,updatable = true,insertable = true,length = 50)
    private String empName;
}
