<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 25/8/25
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cập Nhật Học Sinh</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 20px;
    }
    h2 {
      color: #333;
      text-align: center;
      margin-bottom: 20px;
    }
    form {
      width: 500px; /* Chiều rộng form 500px */
      margin: 0 auto; /* Căn giữa form */
      background: #fff;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
    }
    div {
      margin-bottom: 20px;
    }
    label {
      display: block;
      font-weight: bold;
      margin-bottom: 8px;
      color: #555;
    }
    input[type="text"], input[type="email"], input[type="number"], input[type="radio"] {
      width: 100%;
      padding: 12px; /* Tăng padding cho input */
      border: 1px solid #ccc;
      border-radius: 5px;
      box-sizing: border-box; /* Đảm bảo padding không làm tăng chiều rộng */
      font-size: 14px; /* Kích thước chữ lớn hơn */
    }
    input[type="radio"] {
      width: auto; /* Đặt chiều rộng của radio button */
      margin-right: 5px;
    }
    input[type="submit"] {
      background-color: #28a745;
      color: white;
      border: none;
      padding: 12px 15px;
      border-radius: 5px;
      cursor: pointer;
      width: 100%; /* Đặt chiều rộng nút submit 100% */
      font-size: 16px; /* Kích thước chữ lớn hơn */
      transition: background-color 0.3s ease; /* Hiệu ứng chuyển đổi */
    }
    input[type="submit"]:hover {
      background-color: #218838;
    }
    .error {
      color: red;
      font-size: 0.9em;
      margin-top: 5px;
    }
  </style>
</head>
<body>
<h2>Cập Nhật Học Sinh</h2>
<form:form modelAttribute="student" method="post">
  <div>
    <form:label path="studentName">Tên Sinh Viên:</form:label>
    <form:input path="studentName"/>
    <form:errors path="studentName" cssClass="error"/>
  </div>
  <div>
    <form:label path="email">Email:</form:label>
    <form:input path="email"/>
    <form:errors path="email" cssClass="error"/>
  </div>
  <div>
    <form:label path="ageMark">Điểm Số:</form:label>
    <form:input path="ageMark" type="number" step="0.01"/>
    <form:errors path="ageMark" cssClass="error"/>
  </div>
  <div>
    <form:label path="isStudying">Tình Trạng:</form:label>
    <div>
      <form:radiobutton path="isStudying" value="true"/> Đang Học
      <form:radiobutton path="isStudying" value="false"/> Đã Nghỉ
    </div>
  </div>
  <div>
    <input type="submit" value="Cập Nhật"/>
  </div>
</form:form>
</body>
</html>
