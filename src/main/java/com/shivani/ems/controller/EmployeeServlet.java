package com.shivani.ems.controller;

import com.shivani.ems.entity.Employee;
import com.shivani.ems.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService service = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if admin is logged in
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("adminLoggedIn") == null) {
            response.sendRedirect("index.jsp?error=Please+login+first");
            return;
        }

        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            default:
                listEmployees(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if admin is logged in
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("adminLoggedIn") == null) {
            response.sendRedirect("index.jsp?error=Please+login+first");
            return;
        }

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            addEmployee(request, response);
        } else if ("update".equals(action)) {
            updateEmployee(request, response);
        } else {
            response.sendRedirect("employee?action=list");
        }
    }

    // List all employees
    private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = service.getAllEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("listEmployees.jsp").forward(request, response);
    }

    // Show edit form
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee emp = service.getEmployeeById(id);
        request.setAttribute("employee", emp);
        request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
    }

    // Add new employee
    private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Employee emp = new Employee();
        emp.setId(Integer.parseInt(request.getParameter("id")));
        emp.setName(request.getParameter("name"));
        emp.setEmail(request.getParameter("email"));
        emp.setDepartment(request.getParameter("department"));
        emp.setSalary(Double.parseDouble(request.getParameter("salary")));

        service.addEmployee(emp);
        response.sendRedirect("employee?action=list");
    }

    // Update existing employee
    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Employee emp = new Employee();
        emp.setId(Integer.parseInt(request.getParameter("id")));
        emp.setName(request.getParameter("name"));
        emp.setEmail(request.getParameter("email"));
        emp.setDepartment(request.getParameter("department"));
        emp.setSalary(Double.parseDouble(request.getParameter("salary")));

        service.updateEmployee(emp);
        response.sendRedirect("employee?action=list");
    }

    // Delete employee
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteEmployee(id);
        response.sendRedirect("employee?action=list");
    }
}
