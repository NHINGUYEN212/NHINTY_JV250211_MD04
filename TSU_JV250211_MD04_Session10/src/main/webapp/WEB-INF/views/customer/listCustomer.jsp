<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 25/8/25
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Danh Sách Khách Hàng</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
      margin: 0;
      padding: 20px;
    }
    .container {
      max-width: 800px;
      margin: auto;
      background: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h2 {
      text-align: center;
      color: #333;
    }
    table {
      width: 100%;
      margin-top: 20px;
      border-collapse: collapse;
    }
    th, td {
      padding: 12px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }
    th {
      background-color: #f2f2f2;
    }
    .btn {
      display: inline-block;
      padding: 10px 15px;
      color: #fff;
      background-color: #007bff;
      text-decoration: none;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
    .btn:hover {
      background-color: #0056b3;
    }
    .btn-danger {
      background-color: #dc3545;
    }
    .btn-danger:hover {
      background-color: #c82333;
    }
    .message {
      color: green;
      text-align: center;
      margin-bottom: 20px;
    }
    .error {
      color: red;
      text-align: center;
      margin-bottom: 20px;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Danh Sách Khách Hàng</h2>

  <a class="btn" href="/customers/add">Thêm Mới Khách Hàng</a>
  <table>
    <thead>
    <tr>
      <th>ID</th>
      <th>Username</th>
      <th>Email</th>
      <th>Phone</th>
      <th>Status</th>
      <th>Role</th>
      <th>Hành Động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}">
      <tr>
        <td>${customer.id}</td>
        <td>${customer.username}</td>
        <td>${customer.email}</td>
        <td>${customer.phone}</td>
        <td>${customer.status ? "Hoạt động" : "Không hoạt động"}</td>
        <td>${customer.role.toString()}</td>

        <td>
          <a class="btn" href="/customers/edit/${customer.id}">Sửa</a>
          <a class="btn btn-danger" href="/customers/delete/${customer.id}" onclick="return confirm('Bạn có chắc chắn muốn xóa khách hàng này ?')">Xóa</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<c:if test="${not empty message}">
  <script>
    alert("${message}")
  </script>
</c:if>
</body>
</html>
