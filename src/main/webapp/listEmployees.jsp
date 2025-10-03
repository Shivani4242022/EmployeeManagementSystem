<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management System</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin: auto; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        a { text-decoration: none; color: blue; }
        a:hover { text-decoration: underline; }
        .center { text-align: center; }
        .btn { padding: 4px 8px; border: 1px solid #333; border-radius: 3px; margin: 2px; }
    </style>
</head>
<body>
    <h2 class="center">Employee List</h2>
     <div style="text-align:right;">
        Logged in as: ${sessionScope.adminUsername} |
        <a href="login?action=logout">Logout</a>
    </div>

    <h2>Employees</h2>
    
    <table border="1" width="80%">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="emp" items="${employees}">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.email}</td>
                <td>${emp.department}</td>
                <td>${emp.salary}</td>
                <td>
                    <a href="employee?action=edit&id=${emp.id}">Edit</a> |
                    <a href="employee?action=delete&id=${emp.id}" onclick="return confirm('Are you sure?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="addEmployee.jsp?action=add">Add New Employee</a>
</body>
</html>
