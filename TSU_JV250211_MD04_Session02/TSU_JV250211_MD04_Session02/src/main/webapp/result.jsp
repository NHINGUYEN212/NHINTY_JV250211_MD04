<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 5/8/25
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
    <style>
      h1 {
        text-align: center;
      }
      a {
        text-decoration: none;
        padding: 12px 22px;
        background: blue;
        color: white;
        display: inline-block;
        margin-top: 20px;
        border-radius: 6px;
      }
      .result_container {
        background: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        margin: 20px auto;
        text-align: center;
      }
    </style>
</head>
<body>
<h1>Kết quả tính toán</h1>
<div class="result_container">
  <p>Kết quả: <c:out value="${result}" /></p>
  <a href="exercise03">Quay lại</a>
</div>
</body>
</html>