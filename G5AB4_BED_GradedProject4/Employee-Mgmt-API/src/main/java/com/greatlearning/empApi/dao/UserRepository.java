package com.greatlearning.empApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.empApi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT u from User u where u.username= ?1")
	public User getUserByUserName(String username);

}
