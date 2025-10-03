<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Employee</title>
    <style>
        form { width: 400px; margin: auto; margin-top: 50px; }
        label { display: block; margin-top: 10px; }
        input[type=text], input[type=number], input[type=email] { width: 100%; padding: 6px; margin-top: 4px; }
        input[type=submit] { margin-top: 12px; padding: 6px 12px; }
        .center { text-align: center; }
    </style>
</head>
<body>
   <div style="text-align:right;">
        Logged in as: ${sessionScope.adminUsername} |
        <a href="login?action=logout">Logout</a>
    </div>

    <h2>Edit Employee</h2>
    <form action="employee" method="post">
        <input type="hidden" name="action" value="update">
        <label>ID:</label>
        <input type="text" name="id" value="${employee.id}" readonly><br><br>

        <label>Name:</label>
        <input type="text" name="name" value="${employee.name}" required><br><br>

        <label>Email:</label>
        <input type="email" name="email" value="${employee.email}" required><br><br>

        <label>Department:</label>
        <input type="text" name="department" value="${employee.department}" required><br><br>

        <label>Salary:</label>
        <input type="number" step="0.01" name="salary" value="${employee.salary}" required><br><br>

        <button type="submit">Update</button>
    </form>
</body>
</html>
