package com.greatlearning.empApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.empApi.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
