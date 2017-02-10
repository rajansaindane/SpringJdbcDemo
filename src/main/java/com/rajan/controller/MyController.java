package com.rajan.controller;

import com.rajan.dao.MyImpl;
import com.rajan.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by rajan on 10/2/17.
 */
@RestController
public class MyController {
    @Autowired
    MyImpl myimpl;

    @RequestMapping(value = "/getemployeeList")
    public ResponseEntity<?> getList()
    {

        ResponseEntity<List<MyImpl>> entity=null;

        List<Employee> list=myimpl.getList();
        entity= new ResponseEntity(list, HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = "/getemployee/{id}")
    public ResponseEntity<?> getEmployeeData(@PathVariable Integer id)
    {
        ResponseEntity<List<MyImpl>> entity=null;
        Employee emp=myimpl.getEmployee(id);
        entity=new ResponseEntity(emp,HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = "/deleteEmployee/{id}")
    public String deleteEmployeeData(@PathVariable Integer id)
    {
        myimpl.deleteEmployee(id);
        return "Employee Data Daleted";
    }

    @RequestMapping(value = "/updateEmployee/{id}")
    public String updateEmployeeData(@PathVariable Integer id)
    {
        myimpl.updateEmployee(id);
        return "Employee Data Updated";
    };
}
