package com.zyq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component //Spring托管
public class Department{
    private Integer depId; //部门id
    private String depName; //部门名称
}
