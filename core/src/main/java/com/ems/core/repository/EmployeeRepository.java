package com.ems.core.repository;

import com.ems.core.entity.EmployeeEntity;
import com.ems.core.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

    EmployeeEntity findByEmpEmailIdOrEmpPhoneNo(String emailId,String phoneNo);
}
