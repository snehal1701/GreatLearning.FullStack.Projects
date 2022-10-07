package com.greatlearning.gradedAssignment1.departments;

public class TechDepartment extends SuperDepartment {

	public TechDepartment() {
	}

	@Override
	public String departmentName() {
		return "Tech Department ";
	}

	@Override
	public String getTodaysWork() {
		return "Complete coding of Module 1";
	}

	@Override
	public String getWorkDeadline() {
		return "Complete by EOD";
	}

	public String getTechStackInformation() {
		return "Core Java";
	}

	@Override
	public String isTodayAHoliday() {
		return super.isTodayAHoliday();
	}
}