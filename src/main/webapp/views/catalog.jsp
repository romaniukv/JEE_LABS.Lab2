<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Online Library</title>
        <link href = "../css/catalog.css" rel = "stylesheet">
    </head>
    <body>
        <%@ include file="topMenu.jsp"%>
        <ul>
        <c:forEach var="category" items="${sessionScope.categories}">

            <li> <a href="${pageContext.request.contextPath}/catalog?id=${category.id}"> ${category.categoryName} </a> </li>

        </c:forEach>
        </ul>
        <hr/>
        <c:forEach var="book" items="${requestScope.books}">

            <img src="${book.image}" alt="${book.name}">

            <table border="0">
                <tr>
                    <td>Name: </td>
                    <td>${book.name}</td>
                </tr>
                <tr>
                    <td>Author: </td>
                    <td>${book.author}</td>
                </tr>
                <tr>
                    <td>Year: </td>
                    <td>${book.year}</td>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td>${book.price} $</td>
                </tr>
                <tr>
                    <td>Description: </td>
                    <td>${book.description}</td>
                </tr>
                <tr>
                    <td>Available: </td>
                    <td>${book.available ? "Yes" : "No"}</td>
                </tr>
            </table>
            <hr/>
        </c:forEach>

    </body>
</html>
