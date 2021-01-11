package com.zyq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zyq.mapper.EmployeeMapper;
import com.zyq.pojo.Employee;
import com.zyq.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmployeeController{
    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/all")
    public String queryAllEmp() throws JsonProcessingException {
        List<Employee> employees = employeeMapper.queryAllEmp();
        return JsonUtils.getJson(employees);
    }

    @GetMapping("/{empId}")
    public String queryEmpById(@PathVariable Integer empId) throws JsonProcessingException{
        Employee employee = employeeMapper.queryEmpById(empId);
        return JsonUtils.getJson(employee);
    }

    @GetMapping("/add/{empId}/{empName}/{empDep}")
    public String addEmp(@PathVariable("empId")Integer empId, @PathVariable("empName")String empName, @PathVariable("empDep")String empDep) throws JsonProcessingException{
        Map<String, Object> empInfoMap = new HashMap<>();
        empInfoMap.put("empId", empId);
        empInfoMap.put("empName", empName);
        empInfoMap.put("empDepartment", empDep);
        empInfoMap.put("empBirth", new Date());
        return JsonUtils.getJson(employeeMapper.addEmp(empInfoMap));
    }

    @GetMapping("/delete/{empId}")
    public String deleteEmpById(@PathVariable("empId") Integer empId) throws JsonProcessingException{
        return JsonUtils.getJson(employeeMapper.deleteEmpById(empId));
    }

    @GetMapping("/update/{empId}/{empName}/{empDep}")
    public String updateEmpById(@PathVariable("empId")Integer empId, @PathVariable("empName")String empName, @PathVariable("empDep")String empDep) throws JsonProcessingException{
        Map<String, Object> empInfoMap = new HashMap<>();
        empInfoMap.put("empId", empId);
        empInfoMap.put("empName", empName);
        empInfoMap.put("empDepartment", empDep);
        empInfoMap.put("empBirth", new Date());
        return JsonUtils.getJson(employeeMapper.updateEmpById(empInfoMap));
    }
}
