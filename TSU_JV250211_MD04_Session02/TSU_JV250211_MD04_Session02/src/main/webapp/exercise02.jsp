<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 5/8/25
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercise02</title>
</head>
<body>
<h2>Tuổi của bạn là: ${age}</h2>
<c:if test="${not empty age and age < 12}">
    <h2>Bạn là trẻ em</h2>
</c:if>

<c:if test="${not empty age and age >= 12 and age <18}">
    <h2>Bạn là thiếu niên</h2>
</c:if>

<c:if test="${not empty age and age > 18}">
    <h2>Bạn là người trưởng thành</h2>
</c:if>
</body>
</html>
