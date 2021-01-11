package com.zyq.service;

import com.zyq.pojo.Employee;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    //查询所有员工信息
    List<Employee> queryAllEmp();

    //通过id查询员工信息
    Employee queryEmpById(Integer empId);

    //增加一个员工
    boolean addEmp(Map<String, Object> empInfoMap);

    //通过id删除员工信息
    boolean deleteEmpById(Integer empId);

    //通过id修改员工信息
    boolean updateEmpById(Map<String, Object> empInfoMap);
}
