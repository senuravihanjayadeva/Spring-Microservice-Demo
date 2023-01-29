package com.springmicroservicedemo.departmentservice.service;

import com.springmicroservicedemo.departmentservice.entity.Department;
import com.springmicroservicedemo.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside save department service");
        return departmentRepository.save(department);
    }

    public Department findByDepartmentId(Long departmentId) {
        log.info("Inside findDepartmentById service");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
