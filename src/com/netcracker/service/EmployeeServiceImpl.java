package com.netcracker.service;

import java.util.List;

import com.netcracker.dao.EmployeeDAO;
import com.netcracker.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDAO empDao;
	
	
	public void setEmpDao(EmployeeDAO empDao) {
		this.empDao = empDao;
	}

	@Override
	public String saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empDao.saveEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empDao.getAllEmployee();
	}

	@Override
	public String deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		return empDao.deleteEmployee(eid);
	}

	@Override
	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByID(int eid) {
		// TODO Auto-generated method stub
		return empDao.getEmployeeByID(eid);
	}

}
