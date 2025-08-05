<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 5/8/25
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>exercise 04</title>
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

        button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
            margin-bottom: 20px;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }

        button:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            background-color: #fff;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        img {
            max-width: 100px;
            max-height: 100px;
        }

        a {
            color: red;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <button>Thêm mới sản phẩm</button>
    <h1>Danh sách sản phẩm</h1>
    <table>
        <tr>
            <th>STT</th>
            <th>NAME</th>
            <th>DESCRIPTION</th>
            <th>PRICE</th>
            <th>IMAGE</th>
            <th>ACTIONS</th>
        </tr>
        <c:forEach var="product" items="${products}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td><img src="${product.image}" alt=" "></td>
                <td><a href="#">Xoá</a></td>

            </tr>

        </c:forEach>
    </table>
</body>
</html>
