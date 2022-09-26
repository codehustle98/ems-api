package com.codehustle.ems.service.impl;

import com.codehustle.ems.constants.MessageConstants;
import com.codehustle.ems.entity.DepartmentEntity;
import com.codehustle.ems.exceptions.ConflictException;
import com.codehustle.ems.exceptions.NotFoundException;
import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.model.Department;
import com.codehustle.ems.repository.DepartmentRepository;
import com.codehustle.ems.service.DepartmentService;
import com.codehustle.ems.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Department> getAllDepartments() {
        return mapperService.map(departmentRepository.findAll(),Department.class);
    }

    @Override
    public void updateDepartment(Department department) throws ServiceException {
        try{
            DepartmentEntity departmentEntity = departmentRepository.findByDeptCode(department.getDeptCode());
            if(departmentEntity != null)
                throw new NotFoundException(MessageConstants.DEPT_NOT_FOUND);
            DepartmentEntity updatedEntity = mapperService.map(department,DepartmentEntity.class);
            departmentRepository.save(updatedEntity);
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void deleteDepartment(Long deptId) throws ServiceException {
        try{
            DepartmentEntity departmentEntity = departmentRepository.findByDeptId(deptId);
            if(departmentEntity == null)
                throw new NotFoundException(MessageConstants.DEPT_NOT_FOUND);
            departmentRepository.deleteById(deptId);
        }catch (Exception e){
            throw new ServiceException(e);
        }
    }
}
