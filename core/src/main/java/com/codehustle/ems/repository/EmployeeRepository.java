package com.codehustle.ems.repository;

import com.codehustle.ems.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

    EmployeeEntity findByEmpEmailIdOrEmpPhoneNo(String emailId,String phoneNo);

    EmployeeEntity findByEmpId(Long empId);
}
