<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static by.itclass.constants.AppConst.*" %>
<html>
<head>
    <title>Add Lib</title>
</head>
<body>
    <form action="/addLib" method="post">
        <input name="name" placeholder="Library name"><br>
        <input name="address" placeholder="Library address"><br>
        <input type="submit" value="Add Library">
    </form>
</body>
</html>
