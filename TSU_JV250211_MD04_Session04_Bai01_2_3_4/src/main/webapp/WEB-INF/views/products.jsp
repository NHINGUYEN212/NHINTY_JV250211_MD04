<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 11/8/25
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DANH SÁCH SẢN PHẨM</title>
  <style>
    table {
      width: 60%;
      border-collapse: collapse;
    }
    th, td {
      border: 1px solid black;
      padding: 8px;
      text-align: left;
    }
    th {
      background-color: #f2f2f2;
    }
    form {
      margin-bottom: 20px;
    }
  </style>
</head>
<body>
  <h1>Danh Sách Sản Phẩm</h1>
  <form action="/products" method="get">
    <label for="searchProductName">Tìm kiếm sản phẩm:</label>
    <input type="text" id="" name="searchProductName" placeholder="Nhập tên sản phẩm" value="${not empty searchProductName ? searchProductName : ""}">
    <button type="submit">Tìm kiếm</button>
  </form>
  <table>
    <thead>
      <tr>
          <th>ID</th>
          <th>Tên sản phẩm</th>
          <th>Giá</th>
          <th>Số lượng</th>
          <th>Mô tả</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="product" items="${products}">
        <tr>
          <td>${product.id}</td>
          <td>${product.productName}</td>
          <td>${product.price}</td>
          <td>${product.stock}</td>
          <td>${product.description}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
