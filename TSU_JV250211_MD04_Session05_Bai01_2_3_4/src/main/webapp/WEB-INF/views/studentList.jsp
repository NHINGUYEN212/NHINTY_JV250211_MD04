<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 11/8/25
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sinh viên</title>
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
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: 20px auto;
        }

        input[type="text"] {
            width: calc(70% - 20px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-right: 10px;
        }

        select {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-right: 10px;
        }

        button {
            background-color: #5cb85c;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 15px;
            cursor: pointer;
        }

        button:hover {
            background-color: #4cae4c;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background: white;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ccc;
        }

        th {
            background-color: #f8f8f8;
        }

        a {
            text-decoration: none;
            color: #007bff;
            margin-right: 10px;
        }

        a:hover {
            text-decoration: underline;
        }

        .add-button {
            display: block;
            text-align: center;
            margin-top: 20px;
            background-color: #007bff;
            color: white;
            padding: 10px;
            border-radius: 5px;
            width: 150px;
            margin-left: auto;
            margin-right: auto;
        }

        .add-button:hover {
            background-color: #0056b3;
        }

        #formSearch {
            display: flex;
            justify-content: center;
            gap: 20px;
        }
    </style>
</head>
<body>
<h1>DANH SÁCH SINH VIÊN</h1>
<c:if test="${not empty message}">
    <div class="message">${message}</div>
</c:if>

<form method="GET" action="/students" id="formSearch">
    <input type="text" name="search" value="${search}" placeholder="Tìm kiếm theo tên hoặc email..."/>
    <select name="sort">
        <option value="ASC" ${sort == 'ASC' ? 'selected' : ''}>Sắp xếp tăng dần</option>
        <option value="DESC" ${sort == 'DESC' ? 'selected' : ''}>Sắp xếp giảm dần</option>
    </select>
    <button type="submit">Lọc</button>
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Ngày Sinh</th>
        <th>Điểm Trung Bình</th>
        <th>Hành Động</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.studentName}</td>
            <td>${student.email}</td>
            <td>${student.birthDate}</td>
            <td>${student.avgMark}</td>
            <td>
                <a href="/students/edit/${student.id}">Sửa</a>
                <a href="/students/delete/${student.id}"
                   onclick="return confirm('Bạn có chắc chắn muốn xóa sinh viên này?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div style="text-align: center;">
    <a href="/students/add" class="add-button">Thêm Sinh Viên Mới</a>
</div>
</body>
</html>
