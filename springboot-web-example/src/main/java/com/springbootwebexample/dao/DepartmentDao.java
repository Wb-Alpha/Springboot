package com.springbootwebexample.dao;

import com.springbootwebexample.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departmentMap = null;

    // 模拟数据库中的数据库
    static{
        departmentMap = new HashMap<>();
        departmentMap.put(101,new Department(101, "R&D"));
        departmentMap.put(102,new Department(102, "Medic"));
        departmentMap.put(103,new Department(103, "Combat"));
        departmentMap.put(104,new Department(104, "Support"));
    }

    public Collection<Department> getDepartments(){
        return departmentMap.values();
    }

    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }


}
