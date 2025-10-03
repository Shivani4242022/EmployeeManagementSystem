package com.shivani.ems.service;

import com.shivani.ems.dao.EmployeeDao;
import com.shivani.ems.dao.EmployeeDaoImpl;
import com.shivani.ems.entity.Employee;
import java.util.List;

public class EmployeeService {

    private EmployeeDao dao = new EmployeeDaoImpl();

    
    public boolean addEmployee(Employee emp) {
    	if (emp == null) return false;
        if (emp.getName() == null || emp.getName().isEmpty()) return false;
        if (emp.getEmail() == null || emp.getEmail().isEmpty()) return false;
        if (emp.getSalary() < 0) return false;

        // Check for duplicate ID
        if (dao.getEmployeeById(emp.getId()) != null) {
            System.out.println("Employee ID already exists!");
            return false;
        }
       
        return dao.addEmployee(emp);
    }

   
    public boolean updateEmployee(Employee emp) {
    	if (emp == null || emp.getId() <= 0) return false;
        if (dao.getEmployeeById(emp.getId()) == null) {
            System.out.println("Employee not found!");
            return false;
        }
        return dao.updateEmployee(emp);
    }

  
    public boolean deleteEmployee(int id) {
    	
    	if (id <= 0) return false;
        if (dao.getEmployeeById(id) == null) {
            System.out.println("Employee not found!");
            return false;
        }
        return dao.deleteEmployee(id);
    }

   
    public Employee getEmployeeById(int id) {
    	
    	 if (id <= 0) return null;
        return dao.getEmployeeById(id);
    }

  
    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }
}