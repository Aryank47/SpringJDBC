package com.netcracker.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.netcracker.dto.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet res, int rowCount) throws SQLException {
		
		return new Employee(res.getInt(1), res.getString(2), res.getFloat(3));
	}

}
