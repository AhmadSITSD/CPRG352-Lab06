<%-- 
    Document   : register
    Created on : Oct 24, 2021, 11:22:06 PM
    Author     : 816601
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>register</title>
    </head>
    <body>
        <h1>Shopping List</h1><br>
        <form action="shoppingList" method="POST">
            <label>Username: </label>
            <input type="text" name="username">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register Name">
        </form>
    </body>
</html>
