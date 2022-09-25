package com.codehustle.ems.service.impl;

import com.codehustle.ems.constants.MessageConstants;
import com.codehustle.ems.entity.DepartmentEntity;
import com.codehustle.ems.exceptions.ConflictException;
import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Department;
import com.codehustle.ems.repository.DepartmentRepository;
import com.codehustle.ems.service.DepartmentService;
import com.codehustle.ems.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private MapperService mapperService;

    @Override
    public void addDepartment(Department department) throws ServiceException {
        try{
            DepartmentEntity departmentEntity = departmentRepository.findByDeptCode(department.getDeptCode());
            if(departmentEntity != null)
                throw new ConflictException(MessageConstants.DEPARTMENT_CODE_EXISTS);
            DepartmentEntity entity = mapperService.map(department,DepartmentEntity.class);
            departmentRepository.save(entity);
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }
}
