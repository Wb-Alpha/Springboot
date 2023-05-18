package com.springbootwebexample.dao;

import com.springbootwebexample.pojo.Department;
import com.springbootwebexample.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employeeMap = null;

    @Autowired
    private static DepartmentDao departmentDao;

    static{
        employeeMap = new HashMap<Integer, Employee>();
        employeeMap.put(101,new Employee(1001,"ZhangSan","1415839633@gmail.com",1,new Department(101, "R&D"),new Date()));
        employeeMap.put(102,new Employee(1002,"LiSi","1415839633@gmail.com",0,new Department(101, "R&D"),new Date()));
        employeeMap.put(103,new Employee(1003,"WangWu","1415839633@gmail.com",1,new Department(101, "R&D"),new Date()));
        employeeMap.put(104,new Employee(1004,"ZhaoLiu","1415839633@gmail.com",0,new Department(101, "R&D"),new Date()));
    };

    private Integer initId = 1005;
    public void addEmployee(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employeeMap.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll(){
        return employeeMap.values();
    }

    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }

    public void deleteEmployee(Integer id){
        employeeMap.remove(id);
    }
}
