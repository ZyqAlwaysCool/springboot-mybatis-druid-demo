package com.zyq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zyq.pojo.Department;
import com.zyq.service.DepartmentService;
import com.zyq.service.DepartmentServiceImpl;
import com.zyq.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dep")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;
    @GetMapping("/all")
    public String getAllDep() throws JsonProcessingException {
        List<Department> results = departmentService.queryAllDep();
        return JsonUtils.getJson(results);
    }
    @GetMapping("/{depId}")
    public String getDepById(@PathVariable("depId") Integer depId) throws JsonProcessingException{
        Department res = departmentService.queryDepById(depId);
        return JsonUtils.getJson(res);
    }
    @GetMapping("/add/{depId}/{depName}")
    public String addDep(@PathVariable("depId")Integer depId, @PathVariable("depName")String depName) throws JsonProcessingException{
        boolean res = departmentService.addDep(new Department(depId, depName));
        return JsonUtils.getJson(res);
    }
    @GetMapping("/delete")
    public String deleteDepById(@RequestParam("depId")Integer depId) throws JsonProcessingException{
        boolean res = departmentService.deleteDepById(depId);
        return JsonUtils.getJson(res);
    }
    @GetMapping("/update/{updId}/{updName}")
    public String updateDepById(@PathVariable("updId")Integer depId, @PathVariable("updName")String depName) throws JsonProcessingException{
        boolean res = departmentService.updateDepById(new Department(depId, depName));
        return JsonUtils.getJson(res);
    }
}
