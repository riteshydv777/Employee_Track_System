package com.example.employee.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.employee.dto.UserRegistrationDto;
import com.example.employee.model.User;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);


}