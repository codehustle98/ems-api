package com.codehustle.ems.repository;

import com.codehustle.ems.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {

    DepartmentEntity findByDeptCode(String deptCode);

    DepartmentEntity findByDeptId(Long deptId);
}
