package com.zyq;

import com.zyq.mapper.DepartmentMapper;
import com.zyq.mapper.EmployeeMapper;
import com.zyq.pojo.Department;
import com.zyq.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@SpringBootTest
class SpringbootMybatisDruidApplicationTests {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    void contextLoads() {
        List<Department> departments = departmentMapper.queryAllDep();
        for (Department department : departments) {
            System.out.println(department);
        }
        departmentMapper.deleteDepById(104);
    }
    @Test
    void testQueryAllEmp(){
        //查询所有员工信息
        List<Employee> employees = employeeMapper.queryAllEmp();
        for (Employee employee : employees) {
            System.out.println("查询所有员工信息=>"+employee);
        }
    }

    @Test
    void testAddEmp(){
        Map<String, Object> empInfoMap = new HashMap<>();
        Employee newEmp = new Employee(4, "王五", new Date(), new Department(100, "研发部"));
        empInfoMap.put("empId", newEmp.getEmpId());
        empInfoMap.put("empName", newEmp.getEmpName());
        empInfoMap.put("empBirth", newEmp.getEmpBirth());
        empInfoMap.put("empDepartment", newEmp.getEmpDepartment().getDepName());
        boolean addEmpRes = employeeMapper.addEmp(empInfoMap);
        System.out.println("增加一个员工信息=>"+addEmpRes);
    }

    @Test
    void testDeleteEmpById(){
        Integer deleteEmpId = 4;
        System.out.println("删除一个员工信息=>"+employeeMapper.deleteEmpById(deleteEmpId));
    }

    @Test
    void testqueryEmpById(){
        Integer queryEmpId = 1;
        System.out.println("通过id查询员工信息=>"+employeeMapper.queryEmpById(queryEmpId));
    }

    @Test
    void testUpdateEmpById(){
        Map<String, Object> empInfoMap = new HashMap<>();
        Employee newEmp = new Employee(3, "王五五", new Date(), new Department(100, "研发部"));
        empInfoMap.put("empId", newEmp.getEmpId());
        empInfoMap.put("empName", newEmp.getEmpName());
        empInfoMap.put("empBirth", newEmp.getEmpBirth());
        empInfoMap.put("empDepartment", newEmp.getEmpDepartment().getDepName());
        System.out.println("通过id更新员工信息=>"+employeeMapper.updateEmpById(empInfoMap));
    }
}
