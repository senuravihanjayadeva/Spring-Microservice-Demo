package com.springmicroservicedemo.departmentservice.controller;

import com.springmicroservicedemo.departmentservice.entity.Department;
import com.springmicroservicedemo.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside save department controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{departmentId}")
    public Department findByDepartmentId(@PathVariable Long departmentId){
        log.info("Inside findDepartmentById controller");
        return departmentService.findByDepartmentId(departmentId);
    }
}
