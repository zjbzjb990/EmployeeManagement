package com.zhang.springboot.dao;

import com.zhang.springboot.pojo.Department;
import com.zhang.springboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    //模拟数据库数据
    private static Map<Integer, Employee> employees = null;
    //员工有所属的部门
    @Autowired
    private  DepartmentDao departmentDao;
    static {
        //创建部门表
        employees = new HashMap<Integer,Employee>();

        employees.put(1001,new Employee(1001,"AA","11010101@qq.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","11010101@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","11010101@qq.com",1,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","11010101@qq.com",0,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"EE","11010101@qq.com",0,new Department(105,"后勤部")));
    }
    //初始id
    private static Integer initId = 1006;
    //增加
     public void add(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
     }

     //查全部
    public Collection<Employee> getAll(){
         return employees.values();
    }
    //id 查
    public Employee getEmployeeById(Integer id){
         return employees.get(id);
    }
    //id 删除
    public void delete(Integer id){
         employees.remove(id);
    }
}
