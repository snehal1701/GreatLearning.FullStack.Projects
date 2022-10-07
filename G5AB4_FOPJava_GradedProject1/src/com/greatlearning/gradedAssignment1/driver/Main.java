package com.greatlearning.gradedAssignment1.driver;

import com.greatlearning.gradedAssignment1.departments.AdminDepartment;
import com.greatlearning.gradedAssignment1.departments.HRDepartment;
import com.greatlearning.gradedAssignment1.departments.TechDepartment;

public class Main {

	public static void main(String[] args) {
		// Object Creation
		AdminDepartment adm = new AdminDepartment();
		HRDepartment hr = new HRDepartment();
		TechDepartment tech = new TechDepartment();

		// Information for Admin Department
		System.out.println("Welcome to " + adm.departmentName());
		System.out.println(adm.getTodaysWork());
		System.out.println(adm.getWorkDeadline());
		System.out.println(adm.isTodayAHoliday());

		System.out.println();

		// Information for HR Department
		System.out.println("Welcome to " + hr.departmentName());
		System.out.println(hr.doActivity());
		System.out.println(hr.getTodaysWork());
		System.out.println(hr.getWorkDeadline());
		System.out.println(hr.isTodayAHoliday());

		System.out.println();

		// Information for Tech Department
		System.out.println("Welcome to " + tech.departmentName());
		System.out.println(tech.getTodaysWork());
		System.out.println(tech.getWorkDeadline());
		System.out.println(tech.getTechStackInformation());
		System.out.println(tech.isTodayAHoliday());
	}

}
