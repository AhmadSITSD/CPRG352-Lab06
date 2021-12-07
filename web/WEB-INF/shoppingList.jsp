<%-- 
    Document   : shoppingList
    Created on : Oct 24, 2021, 11:23:31 PM
    Author     : 816601
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>shoppinglist</title>
    </head>
    <body>
        <h1>Shopping List</h1><br>
        <p>Hello, ${username}</p>
        <a href="shoppingList?action=logout">Logout</a><br>
        <h2>List</h2><br>
        <form action="" method="POST">
            <label>Add item: </label>
            <input type="text" name="itemname">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        <form action="" method="POST">
            <c:forEach var="listitems" items="${listitems}">
                <input type="radio" name="itemname" value="${listitems}">${listitems}</p>
            </c:forEach>
                <input type="submit" value="Delete">
                <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
