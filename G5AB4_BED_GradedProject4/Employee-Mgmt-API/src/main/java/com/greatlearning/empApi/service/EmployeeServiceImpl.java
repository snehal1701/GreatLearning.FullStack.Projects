package com.greatlearning.empApi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.empApi.dao.EmployeeRepository;
import com.greatlearning.empApi.dao.RoleRepository;
import com.greatlearning.empApi.dao.UserRepository;
import com.greatlearning.empApi.entity.Employee;
import com.greatlearning.empApi.entity.Role;
import com.greatlearning.empApi.entity.User;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	BCryptPasswordEncoder cryptPasswordEncoder;
	private EmployeeRepository employeeRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;

	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);

	}

	@Override
	public java.util.List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();

		} else {
			throw new RuntimeException("Employee id - " + theId + " Not Found");
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	public Role saveRole(Role role) {

		Role theRole = roleRepository.findByName(role.getName());
		if (theRole == null) {
			return roleRepository.save(role);
		} else {
			return theRole;
		}

	}

	@Override
	public User saveUser(User user) {
		user.setPassword(cryptPasswordEncoder.encode(user.getPassword()));
		// Handle Existing Roles
		Set<Role> theRoles = new HashSet<>();
		for (Role theRole : user.getRoles()) {
			Role tempRole = roleRepository.findByName(theRole.getName());
			if (tempRole != null) {
				theRoles.add(tempRole);
			} else {
				theRoles.add(theRole);
			}
		}
		user.setRoles(theRoles);

		return userRepository.save(user);

	}

	@Override
	public java.util.List<Employee> searchByFirstName(String firstName) {
		return employeeRepository.findByFirstNameContainsAllIgnoreCase(firstName);
	}

	@Override
	public java.util.List<Employee> sortByFirstNameAsc() {
		return employeeRepository.findAllByOrderByFirstNameAsc();
	}

	@Override
	public List<Employee> sortByFirstNameDesc() {
		return employeeRepository.findAllByOrderByFirstNameDesc();
	}

}
