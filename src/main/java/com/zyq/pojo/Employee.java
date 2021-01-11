package com.zyq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component //Spring托管
public class Employee {
    private Integer empId; //员工id
    private String empName; //员工姓名
    private Date empBirth; //员工出生日期
    private Department empDepartment; //员工所属部门
}
