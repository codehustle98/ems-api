package com.codehustle.ems.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "department")
@Data
public class DepartmentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq")
    @GenericGenerator(name = "seq",strategy = "increment")
    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "dept_code",nullable = false,unique = true,length = 10)
    private String deptCode;

    @Column(name = "dept_name",nullable = false,updatable = true,insertable = true,length = 50)
    private String deptName;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "department")
    private List<EmployeeEntity> employees;
}
