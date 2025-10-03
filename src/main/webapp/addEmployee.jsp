<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Employee</title>
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

    <h2>Employee Form</h2>
    <form action="employee" method="post">
        <input type="hidden" name="action" value="${param.action}">
        <label>ID:</label>
        <input type="text" name="id" value="${employee != null ? employee.id : ''}" ${param.action=='update'?'readonly':''} required><br><br>
        <label>Name:</label>
        <input type="text" name="name" value="${employee != null ? employee.name : ''}" required><br><br>
        <label>Email:</label>
        <input type="email" name="email" value="${employee != null ? employee.email : ''}" required><br><br>
        <label>Department:</label>
        <input type="text" name="department" value="${employee != null ? employee.department : ''}" required><br><br>
        <label>Salary:</label>
        <input type="number" step="0.01" name="salary" value="${employee != null ? employee.salary : ''}" required><br><br>
        <button type="submit">${param.action=='update'?'Update':'Add'}</button>
    </form>
</body>
</html>
