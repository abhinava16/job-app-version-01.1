package com.abhinav.SpringJDBCDemo.repo;

import com.abhinav.SpringJDBCDemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Employee e) {

        String sql="insert into employee(id, name, dept) values(?,?,?);";
        int updated = jdbc.update(sql, e.getId(), e.getName(), e.getDept());
        System.out.println(updated + " rows effected..");


    }

    public List<Employee> findAll() {
        String sql="select * from employee;";
        RowMapper rowMapper = (rs, rowNum) -> {
                Employee e=new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setDept(rs.getString("dept"));
                return e;
        };
        return jdbc.query(sql, rowMapper);
    }
}
