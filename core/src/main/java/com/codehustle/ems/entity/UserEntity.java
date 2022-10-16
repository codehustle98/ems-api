package com.codehustle.ems.entity;

import com.codehustle.ems.model.Employee;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Data
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq")
    @GenericGenerator(name = "seq",strategy = "increment")
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_email",nullable = false,updatable = true,unique = true)
    private String userEmailId;

    @Column(name = "user_phone_no",nullable = false,updatable = true,unique = true)
    private String userPhoneNo;

    @Column(name = "user_password",nullable = false,length = 255)
    private String userPassword;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "emp_id")
    private EmployeeEntity employee;
}
