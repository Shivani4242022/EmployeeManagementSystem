package com.shivani.ems.dao;

import com.shivani.ems.entity.Employee;
import java.util.List;

public interface EmployeeDao {
    boolean addEmployee(Employee emp);
    boolean updateEmployee(Employee emp);
    boolean deleteEmployee(int id);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
}