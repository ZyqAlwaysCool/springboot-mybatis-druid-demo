## Springboot整合mybatis和druid数据源

### 构建测试数据库
```sql
create database `mybatis-test`;
use `mybatis-test`;

create table employee(
    `empId` int(10) not null comment '员工id',
    `empName` varchar(20) not null comment '员工姓名',
    `empBirth` date not null comment '员工出生日期',
    `empDepartment` varchar(10) not null comment '员工所属部门',
    primary key (`empId`)
)engine=innodb charset=utf8;

create table department(
    `depId` int(10) not null comment '部门id',
    `depName` varchar(20) not null comment '部门名称'
)engine=innodb charset=utf8;

insert into employee(empId, empName, empBirth, empDepartment)
values(1, '张三', '2020-01-01', '研发部'), (2, '李四', '2020-02-02', '后勤部');

insert into department(depId, depName) values(100, '研发部'), (101, '后勤部'), (102, '宣传部');

```
### 实体类
```java
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
```
```java
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component //Spring托管
public class Department{
    private Integer depId; //部门id
    private String depName; //部门名称
}
```
### Mapper
```java
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
```
```java
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
```
### 配置mybatis
>**[springboot整合mybatis实现数据库访问](https://juejin.cn/post/6844904003050930184)**
* 导入依赖
```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.1.4</version>
</dependency>
```
* mybatis模版文件(*Mapper.xml)
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.zyq.mapper.EmployeeMapper">

</mapper>
```
* 相关配置(application.properties)
```properties
#mybatis整合springboot配置
mybatis.type-aliases-package=com.zyq.pojo
mybatis.mapper-locations=classpath:mybatis/mapper/*.xml
mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl

#配置数据源
spring.datasource.url=jdbc:mysql://172.20.46.192:3306/mybatis-test?useUnicode=true&characterEncoding=utf8&useSSL=true
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
### 配置druid
1. 通过配置类实现[SpringBoot整合Druid数据源](https://juejin.cn/post/6844903736356110350)
   * 依赖文件
   ```xml
    <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.8</version>
    </dependency>
   ```
2. [druid-spring-boot-starter](https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter)
    * 参考配置: [Druid（新版starter）在SpringBoot下的使用](https://blog.csdn.net/weixin_38187317/article/details/81562571)
    * 依赖文件
    ```xml
    <dependency>
       <groupId>com.alibaba</groupId>
       <artifactId>druid-spring-boot-starter</artifactId>
       <version>1.2.4</version>
    </dependency>
    ```
   * 相关配置(application.properties)
   ```properties
   spring.datasource.druid.initial-size=5
   spring.datasource.druid.min-idle=5
   spring.datasource.druid.maxActive=20
   spring.datasource.druid.maxWait=60000
   spring.datasource.druid.timeBetweenEvictionRunsMillis=60000
   spring.datasource.druid.minEvictableIdleTimeMillis=300000
   spring.datasource.druid.testWhileIdle=true
   spring.datasource.druid.testOnBorrow=false
   spring.datasource.druid.testOnReturn=false
   spring.datasource.druid.poolPreparedStatements=true
   spring.datasource.druid.maxPoolPreparedStatementPerConnectionSize=20
   spring.datasource.druid.filters=stat,wall,slf4j
   spring.datasource.druid.connectionProperties=druid.stat.mergeSql\=true;druid.stat.slowSqlMillis\=5000
   spring.datasource.druid.web-stat-filter.enabled=true
   spring.datasource.druid.web-stat-filter.url-pattern=/*
   spring.datasource.druid.web-stat-filter.exclusions=*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*
   # 监控页面配置
   spring.datasource.druid.stat-view-servlet.url-pattern=/druid/*
   # 允许访问IP
   spring.datasource.druid.stat-view-servlet.allow=127.0.0.1
   spring.datasource.druid.stat-view-servlet.reset-enable=false
   # 监控页面登录用户信息
   spring.datasource.druid.stat-view-servlet.login-username=admin
   spring.datasource.druid.stat-view-servlet.login-password=admin
   # !!!注意点: 1.1.10版本之后默认为false, 需要手动开启, 否则会报404错误
   spring.datasource.druid.stat-view-servlet.enabled=true
   ```
