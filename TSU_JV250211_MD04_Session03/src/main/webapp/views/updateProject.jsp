<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 6/8/25
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Project</title>
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
    form {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
      max-width: 500px;
      margin: auto;
    }
    label {
      display: block;
      margin-bottom: 8px;
      font-weight: bold;
    }
    input[type="text"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    button[type="submit"] {
      background-color: #007bff;
      color: white;
      border: none;
      padding: 10px 15px;
      cursor: pointer;
      border-radius: 5px;
      transition: background-color 0.3s;
      width: 100%;
    }
    button[type="submit"]:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
<h1>Cập nhật dự án</h1>
<form method="post" action="/ProjectServlet?action=Update">
  <label for="id">Id:</label>
  <input type="text" id="id" name="id" readonly value="${project.id}">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required value="${project.name}">
  <label for="description">Description:</label>
  <input type="text" id="description" name="description" required value="${project.description}">
  <label for="image">Image URL:</label>
  <input type="text" id="image" name="image" required value="${project.image}">
  <button type="submit">Cập nhật dự án</button>
</form>
</body>
</html>
