package com.rajan.repository;

import com.rajan.domain.Employee;

import java.util.List;

/**
 * Created by rajan on 10/2/17.
 */
public interface MyRepo{
    List<Employee> getList();
    Employee getEmployee(Integer id);
    String deleteEmployee(Integer id);
    String updateEmployee(Integer id);
}
