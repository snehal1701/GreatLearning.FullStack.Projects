package com.greatlearning.gradedAssignment1.departments;

public class HRDepartment extends SuperDepartment {

	public HRDepartment() {
	}

	@Override
	public String departmentName() {
		return "HR Department";
	}

	@Override
	public String getTodaysWork() {
		return "Fill today's timesheet and mark your attendance";
	}

	@Override
	public String getWorkDeadline() {
		return "Complete by EOD";
	}

	public String doActivity() {
		return "team Lunch";
	}

	@Override
	public String isTodayAHoliday() {
		return super.isTodayAHoliday();
	}
}
