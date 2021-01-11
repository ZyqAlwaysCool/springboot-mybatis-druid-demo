package com.zyq.mapper;

import com.zyq.pojo.Department;
import com.zyq.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository //Spring托管
public interface EmployeeMapper {
    //查询所有员工信息
    List<Employee> queryAllEmp();

    //通过id查询员工信息
    Employee queryEmpById(@Param("empId")Integer empId);

    //增加一个员工
    boolean addEmp(Map<String, Object> empInfoMap);

    //通过id删除员工信息
    boolean deleteEmpById(@Param("empId")Integer empId);

    //通过id修改员工信息
    boolean updateEmpById(Map<String, Object> empInfoMap);
}
