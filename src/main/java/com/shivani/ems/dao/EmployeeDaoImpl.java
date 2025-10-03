package com.shivani.ems.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shivani.ems.entity.Employee;
import com.shivani.ems.util.DButil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private Connection conn = DButil.getConnection();

    @Override
    public boolean addEmployee(Employee emp) {
        try {
            String sql = "INSERT INTO employee(id, name, email, department, salary) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getEmail());
            ps.setString(4, emp.getDepartment());
            ps.setDouble(5, emp.getSalary());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee emp) {
    	String sql="UPDATE EMPLOYEE SET name=?, email=?, department=?, salary=? where id=?";
       try {
    	   PreparedStatement st=conn.prepareStatement(sql);
    	   st.setString(1, emp.getName());
    	   st.setString(2, emp.getEmail());
    	   st.setString(3, emp.getDepartment());
    	   st.setDouble(4, emp.getSalary());
    	   st.setInt(5,emp.getId());
    	   
    	   int res= st.executeUpdate();
    	   return res>0;
    	   
       }catch(Exception e) {
    	   e.printStackTrace();
       }
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        String sql="Delete from employee where id=?";
        
        try {
        	PreparedStatement st=conn.prepareStatement(sql);
        	st.setInt(1, id);
        	
           return st.executeUpdate()>0;
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee getEmployeeById(int id) {
       String sql="select * from Employee where id=?";
       
       try {
    	   PreparedStatement st=conn.prepareStatement(sql);
    	   st.setInt(1, id);
    	   
    	   ResultSet rs=st.executeQuery();
    	   
    	   if(rs.next()) {
    	   Employee e=new Employee();
    	   e.setName(rs.getString("name"));
    	   e.setId(rs.getInt("id"));
    	   e.setDepartment(rs.getString("department"));
    	   e.setEmail(rs.getString("email"));
    	   e.setSalary(rs.getDouble("salary"));
    	   return e;
    	   }
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
       
      return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
         List<Employee> employees=new ArrayList<Employee>();
         
         String sql="select * from Employee";
         
         try {
			
        	Statement st = conn.createStatement();
        	 ResultSet rs=st.executeQuery(sql);
        	 
        	 while(rs.next()) {
        		 Employee e=new Employee();
        		 e.setId(rs.getInt("id"));
        		 e.setName(rs.getString("name"));
        		 e.setEmail(rs.getString("email"));
        		 e.setDepartment(rs.getString("department"));
        		 e.setSalary(rs.getDouble("salary"));
        		 
        		 employees.add(e);
        	}
        	  
		} catch (Exception e) {
			e.printStackTrace();
		}
         return employees;
    }
}
	
	
	
	


