<%-- 
    Document   : LoginPage
    Created on : 17-Jun-2022, 6:18:04 PM
    Author     : Alain Unico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In Page</title>
    </head>
    <body>
        <h1>Log In</h1>
        <form method="post" action="login">
            <label>Username: </label>
            <input type="text" name="username" id="username" value="${username}" required>
            <br>
            <label>Password: </label>
            <input type="password" name="password" id="password" value="" required>
            <br>
            <input type="submit" value="Log in">  
        </form>
            <p>${message}</p>
      
    </body>
</html>
