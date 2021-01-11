package com.zyq.service;

import com.zyq.mapper.DepartmentMapper;
import com.zyq.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> queryAllDep() {
        return departmentMapper.queryAllDep();
    }

    @Override
    public Department queryDepById(Integer depId) {
        return departmentMapper.queryDepById(depId);
    }

    @Override
    public boolean addDep(Department dep) {
        return departmentMapper.addDep(dep);
    }

    @Override
    public boolean deleteDepById(Integer depId) {
        return departmentMapper.deleteDepById(depId);
    }

    @Override
    public boolean updateDepById(Department dep) {
        return departmentMapper.updateDepById(dep);
    }
}
