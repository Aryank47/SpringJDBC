package com.netcracker.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netcracker.dto.Employee;
import com.netcracker.service.EmployeeService;
import com.netcracker.service.EmployeeServiceImpl;

public class EmployeeClient {
	private static ApplicationContext appContext;
	
	public static void main(String[] args) throws IOException {
		
		appContext = new ClassPathXmlApplicationContext("Beans.xml");
		EmployeeService employeeService=(EmployeeServiceImpl)appContext.getBean("empService");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter 1 for get employee by ID\nEnter 2 for GET ALL\nEnter 3 for Delete by ID\nEnter 4 for INSERT"
				+ "\nEnter 5 UPDATE\nEnter 6 for EXIT");
		
		while(true) {
			System.out.println("Enter your choice(1/2/3/4/5/6)");
			int choice=Integer.parseInt(br.readLine());
			
			switch (choice) {
			case 1: {
				System.out.println("Enter Employee id:");
				int eid=Integer.parseInt(br.readLine());
				Employee employee=employeeService.getEmployeeByID(eid);
				System.out.println(employee);
				
			}break;
			
			case 2:{
				List<Employee> allEmp=employeeService.getAllEmployee();
				for(Employee e: allEmp) {
					System.out.println(e);
				}
			}break;
			
			case 3:{
				System.out.println("Enter the id:");
				int eid=Integer.parseInt(br.readLine());
				String res=employeeService.deleteEmployee(eid);
				System.out.println(res);
				
			}break;
			
			case 4:{
				System.out.println("Enter employee id:");
				int eid=Integer.parseInt(br.readLine());
				System.out.println("Enter employee Name");
				String name=br.readLine();
				System.out.println("Enter employee salary");
				float sal=Float.parseFloat(br.readLine());
				Employee emp=new Employee(eid, name, sal);
				
				String res=employeeService.saveEmployee(emp);
				System.out.println(res);
				
			}break;
			
			case 5:{
				
				
			}break;
			
			case 6:{
				
				appContext=null;
				System.out.println("Bye Bye");
				System.exit(0);
				
				
			}
			default:
				System.out.println("Invalid Choice.");
			}
			
			
		}
		
	}

}
