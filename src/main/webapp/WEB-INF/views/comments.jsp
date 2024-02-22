<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Comments</title>
</head>
<body>
    <h1>Comments</h1>
    <form action="${mvc.basePath}/app/comments" method="post">
        <input name="comment" placeholder="Comment" required><input type="submit" value="Send">
        <input type="hidden" name="${mvc.csrf.name}" value="${mvc.csrf.token}">
    </form>
    <ul>
        <c:forEach var="comment" items="${comments}">
            <li>${comment}</li>
        </c:forEach>
    </ul>
</body>
</html>
