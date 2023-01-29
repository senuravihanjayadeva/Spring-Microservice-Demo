package com.springmicroservicedemo.userservice.dto;

import com.springmicroservicedemo.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateUser {
    private User user;
    private Department department;
}
