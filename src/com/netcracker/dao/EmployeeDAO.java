package com.netcracker.dao;

import java.util.List;

import com.netcracker.dto.Employee;

public interface EmployeeDAO {
	public Employee getEmployeeByID(int eid);
	
	public String saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public String deleteEmployee(int eid);
	
	public String updateEmployee(Employee employee);

}
