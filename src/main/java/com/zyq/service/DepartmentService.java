package com.zyq.service;

import com.zyq.pojo.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentService {
    //查询所有部门信息
    List<Department> queryAllDep();

    //通过id查询部门信息
    Department queryDepById(Integer depId);

    //增加一个部门
    boolean addDep(Department dep);

    //通过id删除部门信息
    boolean deleteDepById(Integer depId);

    //通过id修改部门信息
    boolean updateDepById(Department dep);
}
