<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static by.itclass.constants.AppConst.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Library</title>
</head>
<body>
    <h1>Library: ${library.name}</h1>
    <h2>Address: ${library.address}</h2>
    <table border="1">
        <tr>
            <th>Genre</th>
            <th>Author</th>
            <th>Title</th>
            <th>Pages</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="book" items="${library.books}">
            <tr>
                <td>${book.genre}</td>
                <td>${book.author}</td>
                <td>${book.title}</td>
                <td>${book.pages}</td>
                <td>
                    <a href="/delBook/${book.id}/${library.id}">Delete Book</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <a href="/addBook/${library.id}">Add New Book</a>
    </p>
</body>
</html>
