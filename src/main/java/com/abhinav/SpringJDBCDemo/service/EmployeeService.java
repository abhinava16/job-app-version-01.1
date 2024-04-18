package com.abhinav.SpringJDBCDemo.service;

import com.abhinav.SpringJDBCDemo.model.Employee;
import com.abhinav.SpringJDBCDemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepo repo;

    public EmployeeRepo getRepo() {
        return repo;
    }

    @Autowired //Setter Injection
    public void setRepo(EmployeeRepo repo) {
        this.repo = repo;
    }

    public void addEmployee(Employee e){
        repo.save(e);

    }

    public List<Employee> getEmployees() {
        List<Employee> employees=repo.findAll();
        return employees;
    }
}
