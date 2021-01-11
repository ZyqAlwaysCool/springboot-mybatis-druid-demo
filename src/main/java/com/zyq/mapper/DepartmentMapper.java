package com.zyq.mapper;

import com.zyq.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository //Spring托管
public interface DepartmentMapper {
    //查询所有部门信息
    List<Department> queryAllDep();

    //通过id查询部门信息
    Department queryDepById(@Param("depId")Integer depId);

    //增加一个部门
    boolean addDep(Department dep);

    //通过id删除部门信息
    boolean deleteDepById(@Param("depId")Integer depId);

    //通过id修改部门信息
    boolean updateDepById(Department dep);
}
