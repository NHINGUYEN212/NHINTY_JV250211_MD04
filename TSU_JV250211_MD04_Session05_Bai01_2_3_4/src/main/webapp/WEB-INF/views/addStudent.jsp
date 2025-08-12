<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 11/8/25
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        form {
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: auto;
        }

        label {
            display: block;
            margin: 10px 0 5px;
            color: #555;
        }

        input[type="text"],
        input[type="email"],
        input[type="date"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 15px;
        }

        button {
            background-color: #5cb85c;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 15px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #4cae4c;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>Thêm Sinh Viên</h1>

<form:form modelAttribute="student" action="/students/add" method="POST">
    <div>
        <form:label path="studentName">Tên:</form:label>
        <form:input path="studentName" type="text" required="true"/>
    </div>
    <div>
        <form:label path="email">Email:</form:label>
        <form:input path="email" type="email" required="true"/>
    </div>
    <div>
        <form:label path="birthDate">Ngày Sinh:</form:label>
        <form:input path="birthDate" type="date" required="true"/>
    </div>
    <div>
        <form:label path="avgMark">Điểm Trung Bình:</form:label>
        <form:input path="avgMark" type="number" step="0.01" required="true"/>
    </div>

    <button type="submit">Thêm</button>
</form:form>

<a href="/students">Quay lại danh sách</a>
</body>
</html>
