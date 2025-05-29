package com.oscar.springsecurityexercise.service;

import com.oscar.springsecurityexercise.data.EmployeeRepository;
import com.oscar.springsecurityexercise.model.Employee;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements UserDetailsService {

    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);

        Set<SimpleGrantedAuthority> authorities = employee.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
        return new User(employee.getUsername(), employee.getPassword(), authorities);
    }
}
