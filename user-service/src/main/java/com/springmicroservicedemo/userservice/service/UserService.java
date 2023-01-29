package com.springmicroservicedemo.userservice.service;

import com.springmicroservicedemo.userservice.dto.Department;
import com.springmicroservicedemo.userservice.dto.ResponseTemplateUser;
import com.springmicroservicedemo.userservice.entity.User;
import com.springmicroservicedemo.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside the saveUser in Service");
        return userRepository.save(user);
    }

    public ResponseTemplateUser getUserWithDepartment(Long userId) {
        log.info("Inside the getUserWithDepartment in Service");
        ResponseTemplateUser responseTemplateUser = new ResponseTemplateUser();

        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://localhost:8081/api/department/" + user.getDepartmentId(), Department.class);

        responseTemplateUser.setUser(user);
        responseTemplateUser.setDepartment(department);

        return responseTemplateUser;
    }
}
