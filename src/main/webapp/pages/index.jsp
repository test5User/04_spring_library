<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static by.itclass.constants.AppConst.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Libraries</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <table border="1">
        <tr class="red">
            <th>Id</th>
            <th>Name</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="library" items="${libraries}">
            <tr>
                <td>${library.id}</td>
                <td>${library.name}</td>
                <td>${library.address}</td>
                <td>
                    <a href="/view/${library.id}">View</a>
                    <a href="/del?id=${library.id}">Delete</a>
                    <a href="/upd?id=${library.id}">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <a href="/pages/addLib.jsp">Add new Lib</a>
    </p>
    <script src="/js/script.js"></script>
</body>
</html>
