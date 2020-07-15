package com.netcracker.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.netcracker.allquery.Query;
import com.netcracker.dto.Employee;
import com.netcracker.mapping.EmployeeRowMapper;

public class EmployeeDAOImpl implements EmployeeDAO {
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Employee getEmployeeByID(int eid) {
		// TODO Auto-generated method stub
		Object param[]=new Object[] {eid};
		
		Employee employee=jdbcTemplate.queryForObject(Query.GETBYID, param, new EmployeeRowMapper());
		
		return employee;
	}

	@Override
	public String saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Object param[]=new Object[] {employee.getId(),employee.getName(),employee.getSalary()};
		int count=jdbcTemplate.update(Query.SAVEEMP, param);
		if(count>0) {
			return "Record with emp id "+employee.getId()+" is saved in database";
		}
		else {
			return "record is not saved";
		}
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(Query.GETALL, new EmployeeRowMapper());
	}

	@Override
	public String deleteEmployee(int eid) {
		Object param[]=new Object[] {eid};
		int count=jdbcTemplate.update(Query.DELETEEMP,param);
		if(count>0) {
			return "Employee with id "+eid+" is deleted";
		}
		return "Record not deleted";
	}

	@Override
	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
