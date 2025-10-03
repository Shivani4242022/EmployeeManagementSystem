<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>EMS Admin Login</title>
    <style>
        body { font-family: Arial; background-color: #f2f2f2; }
        form { width: 300px; margin: auto; margin-top: 100px; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        input[type=text], input[type=password] { width: 100%; padding: 6px; margin-top: 4px; border-radius: 4px; border: 1px solid #ccc; }
        input[type=submit] { margin-top: 12px; padding: 6px 12px; border-radius: 4px; border: none; background-color: #4CAF50; color: white; cursor: pointer; }
        input[type=submit]:hover { background-color: #45a049; }
        .center { text-align: center; }
        h2 { text-align: center; }
    </style>
</head>
<body>
    <h2>Employee Management System - Admin Login</h2>

    <c:if test="${not empty requestScope.errorMessage}">
        <p style="color:red">${requestScope.errorMessage}</p>
    </c:if>
    
    <form action="login" method="post">
        <label>Username:</label>
        <input type="text" name="username" required><br><br>
        <label>Password:</label>
        <input type="password" name="password" required><br><br>
        <button type="submit">Login</button>
    </form>
</body>
</html>
