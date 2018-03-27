<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Online Library</title>
        <link href = "catalog.css" rel = "stylesheet">
    </head>
    <body>
        <%@ include file="topMenu.jsp"%>
        <form name="form" action="addBook" method="POST">
            Category:
            <br>
            <select name="categoryId">
                <c:forEach var="category" items="${sessionScope.categories}">
                    <option value="${category.key}">${category.value}</option>
                </c:forEach>
            </select>
            <br>
            Name: <br><input name="name" type="text"><br>
            Author: <br><input name="author" type="text"><br>
            Year: <br><input name="year" type="number"><br>
            Number of pages: <br><input name="numOfPages" type="number"><br>
            Price: <br><input name="price" type="number" step="any"><br>
            Description: <br><input name="description" type="text"><br>
            Is available?:
            <br><select name="availability">
                <option value="true">Yes</option>
                <option value="false">No</option>
            </select><br>
            Image: <br><input name="image" type="text"><br>
            <input name="submit" type="submit" value="add">
        </form>
    </body>
</html>
