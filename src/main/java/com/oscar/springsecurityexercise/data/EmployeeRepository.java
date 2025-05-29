package com.oscar.springsecurityexercise.data;

import com.oscar.springsecurityexercise.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
