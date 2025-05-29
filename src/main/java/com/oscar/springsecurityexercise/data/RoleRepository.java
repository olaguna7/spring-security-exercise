package com.oscar.springsecurityexercise.data;

import com.oscar.springsecurityexercise.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
