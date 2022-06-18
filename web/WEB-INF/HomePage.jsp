<%-- 
    Document   : HomePage
    Created on : 17-Jun-2022, 6:23:57 PM
    Author     : Alain Unico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
            <h2> Hello ${username}!</h2>
        <br>
            <form method="get" action="login">
            <input type="submit" value="Logout">
            <input type="hidden" name="logout" value="reset">
            </form>
    </body>
</html>
