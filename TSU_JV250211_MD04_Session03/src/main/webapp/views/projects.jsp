<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 6/8/25
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Products</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 20px;
    }
    h1 {
      text-align: center;
      color: #333;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
      background-color: #fff;
    }
    th, td {
      padding: 12px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }
    th {
      background-color: #007bff;
      color: white;
    }
    tr:hover {
      background-color: #f1f1f1;
    }
    img {
      width: 100px;
      height: auto;
    }
    button {
      background-color: #28a745;
      color: white;
      border: none;
      padding: 10px 15px;
      cursor: pointer;
      margin-right: 5px;
      border-radius: 5px;
      transition: background-color 0.3s;
    }
    button:hover {
      background-color: #218838;
    }
    a {
      color: white;
      text-decoration: none;
    }
  </style>
</head>
<body>
  <button><a href="/views/newProject.jsp">Thêm mới dự án</a></button>
  <table>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Descriptions</th>
      <th>Image</th>
      <th>Action</th>
    </tr>
    <c:forEach var="project" items="${listProjects}">
      <tr>
        <td>${project.id}</td>
        <td>${project.name}</td>
        <td>${project.description}</td>
        <td><img src="${project.image}" alt=" "/></td>
        <td>
          <button><a href="/ProjectServlet?id=${project.id}&action=Update">Chỉnh sửa</a></button>
          <button><a href="/ProjectServlet?id=${project.id}&action=Delete" onclick="return confirm('Bạn có chắc chắn muốn xoá không?')">Xoá</a></button>

        </td>
      </tr>

    </c:forEach>
  </table>

</body>
</html>
