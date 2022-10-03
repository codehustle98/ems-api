package com.codehustle.ems.repository;

import com.codehustle.ems.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

    EmployeeEntity findByEmpEmailIdOrEmpPhoneNo(String emailId,String phoneNo);

    EmployeeEntity findByEmpId(Long empId);

    @Query("select emp.empEmailId from EmployeeEntity emp where emp.empDob =:date ")
    List<String> getEmployeeEmailIdsByBirthDate(LocalDate date);
}
