package com.abhinav.SpringJDBCDemo;

import com.abhinav.SpringJDBCDemo.model.Employee;
import com.abhinav.SpringJDBCDemo.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);

		Employee e1 = context.getBean(Employee.class);
		e1.setId(105);
		e1.setName("Abhinav");
		e1.setDept("Java");

		EmployeeService service = context.getBean(EmployeeService.class);
		service.addEmployee(e1);

		List<Employee> employees = service.getEmployees();
		System.out.println(employees);

//		Employee e2 = context.getBean(Employee.class);
//		e1.setId(106);
//		e1.setName("Krishna");
//		e1.setDept("Python");
//
//		Employee e3 = context.getBean(Employee.class);
//		e1.setId(107);
//		e1.setName("Sai");
//		e1.setDept("Java");
//
//		Employee e4 = context.getBean(Employee.class);
//		e1.setId(108);
//		e1.setName("Reddy");
//		e1.setDept("Java");
	}

}
