<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 25/8/25
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
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
      margin-bottom: 20px;
    }
    .add-button {
      width: 300px;
      display: block;
      margin: 0 auto 20px;
      padding: 10px 15px;
      font-size: 16px;
      color: #fff;
      background-color:blue;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      text-decoration: none;
      text-align: center;
    }
    .add-button:hover {
      background-color: #45a049;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      margin: 20px 0;
      background-color: #fff;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
    th, td {
      padding: 12px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }
    th {
      background-color: #4CAF50;
      color: white;
    }
    tr:hover {
      background-color: #f1f1f1;
    }
    a {
      color: #ff0000;
      text-decoration: none;
      font-weight: bold;
    }
    a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<h1>Danh sách sinh viên</h1>
<a href="/students/add" class="add-button">Thêm mới sinh viên</a>
<table>
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Email</th>
    <th>Điểm số</th>
    <th>Đang học</th>
    <th>Hành động</th>
  </tr>
  <c:forEach var="student" items="${students}" varStatus="status">
    <tr>
      <td>${status.index + 1}</td>
      <td>${student.studentName}</td>
      <td>${student.email}</td>
      <td>${student.ageMark}</td>
      <td>${student.isStudying ? 'Đang Học' : 'Đã Nghỉ'}</td>
      <td>
        <a style="color: blue" href="${pageContext.request.contextPath}/students/edit/${student.id}">Sửa</a> |
        <a href="${pageContext.request.contextPath}/students/delete/${student.id}" onclick="return confirm('Bạn chắc chắn muốn xóa học sinh này chứ ?')">Xóa</a>
      </td>
    </tr>
  </c:forEach>
</table>
<c:if test="${not empty message}">
  <script>
    alert("${message}");
  </script>
</c:if>
</body>
</html>
