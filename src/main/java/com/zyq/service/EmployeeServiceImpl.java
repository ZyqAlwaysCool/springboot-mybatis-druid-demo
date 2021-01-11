package com.zyq.service;

import com.zyq.mapper.EmployeeMapper;
import com.zyq.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> queryAllEmp() {
        return employeeMapper.queryAllEmp();
    }

    @Override
    public Employee queryEmpById(Integer empId) {
        return employeeMapper.queryEmpById(empId);
    }

    @Override
    public boolean addEmp(Map<String, Object> empInfoMap) {
        return employeeMapper.addEmp(empInfoMap);
    }

    @Override
    public boolean deleteEmpById(Integer empId) {
        return employeeMapper.deleteEmpById(empId);
    }

    @Override
    public boolean updateEmpById(Map<String, Object> empInfoMap) {
        return employeeMapper.updateEmpById(empInfoMap);
    }
}
