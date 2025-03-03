package com.stack.blogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stack.blogapi.model.role.Role;
import com.stack.blogapi.model.role.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName name);
}
