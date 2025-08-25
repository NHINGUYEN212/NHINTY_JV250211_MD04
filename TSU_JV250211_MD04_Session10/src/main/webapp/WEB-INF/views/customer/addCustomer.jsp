<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 25/8/25
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Thêm Mới Khách Hàng</title>
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
      padding: 30px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h2 {
      text-align: center;
      color: #333;
      margin-bottom: 20px;
    }
    .form-group {
      margin-bottom: 20px;
    }
    label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
      color: #555;
    }
    input[type="text"], input[type="email"], input[type="password"], input[type="tel"], input[type="radio"] {
      width: 100%;
      padding: 12px;
      border: 1px solid #ccc;
      border-radius: 5px;
      box-sizing: border-box; /* Đảm bảo padding không làm tăng chiều rộng */
      font-size: 14px;
    }
    input[type="radio"] {
      width: auto; /* Đặt chiều rộng của radio button */
      margin-right: 5px;
      display: inline-block; /* Hiển thị inline */
    }
    .btn {
      display: inline-block;
      padding: 10px 15px;
      color: #fff;
      background-color: #007bff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-size: 16px;
      transition: background-color 0.3s ease;
    }
    .btn:hover {
      background-color: #0056b3;
    }
    .error {
      color: red;
      font-size: 0.9em;
      margin-top: 5px;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Thêm Mới Khách Hàng</h2>
  <form:form modelAttribute="customer" method="post">
    <div class="form-group">
      <label for="username">Username:</label>
      <form:input path="username" cssClass="form-control" />
      <form:errors path="username" cssClass="error" />
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <form:input path="password" type="password" cssClass="form-control" />
      <form:errors path="password" cssClass="error" />
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <form:input path="email" cssClass="form-control" />
      <form:errors path="email" cssClass="error" />
    </div>
    <div class="form-group">
      <label for="phone">Phone:</label>
      <form:input path="phone" cssClass="form-control" />
      <form:errors path="phone" cssClass="error" />
    </div>

    <div class="form-group">
      <label>Quyền:</label>
      <div>
        <form:radiobutton path="role" value="ADMIN" cssClass="form-control"/> Admin
        <form:radiobutton path="role" value="USER" checked="checked" cssClass="form-control"/> User
      </div>
    </div>

    <div class="form-group">
      <label>Trạng thái:</label>
      <div>
        <form:radiobutton path="status" value="true" checked="checked" cssClass="form-control"/> Hoạt động
        <form:radiobutton path="status" value="false" cssClass="form-control"/> Không hoạt động
      </div>
    </div>

    <div class="form-group">
      <button type="submit" class="btn">Thêm Mới</button>
    </div>
  </form:form>
</div>
</body>
</html>

