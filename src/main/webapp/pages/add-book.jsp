<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Book Page</title>
</head>
<body>
    <sf:form action="/saveBook" method="post" modelAttribute="book">
        <sf:input path="library_id" type="hidden"/>
        <sf:input path="genre" placeholder="Genre"/><br>
        <sf:input path="author" placeholder="Author"/><br>
        <sf:input path="title" placeholder="Title"/><br>
        <sf:input path="pages" placeholder="Pages"/><br>
        <input type="submit" value="Save Book">
    </sf:form>
</body>
</html>
