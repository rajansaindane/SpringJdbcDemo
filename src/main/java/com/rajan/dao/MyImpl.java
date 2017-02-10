package com.rajan.dao;

import com.rajan.domain.Employee;
import com.rajan.repository.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rajan on 10/2/17.
 */
@Repository
public class MyImpl implements MyRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

        @Override
    public List<Employee> getList() {

        String sql="select * from rajantab";

        List<Employee> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Employee>(Employee.class));
        return list;
    }

    @Override

    public Employee getEmployee(Integer id) {
        String sql = "select * from rajantab where id=?";
        Employee emp = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Employee>(Employee.class));
        return emp;
    }

    public String deleteEmployee(Integer id)
    {

        String sql="delete from rajantab where id=?";
        jdbcTemplate.update(sql,new Object[]{id});
        return "success";
    }

    public String updateEmployee(Integer id)
    {

        String sql="update rajantab set name='VikramBhau More' where id=?";
        jdbcTemplate.update(sql,new Object[]{id});
        return "success";
    }
}
