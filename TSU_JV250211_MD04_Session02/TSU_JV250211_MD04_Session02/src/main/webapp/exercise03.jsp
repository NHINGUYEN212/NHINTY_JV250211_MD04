<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 5/8/25
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercise 03</title>
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
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: auto;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"], select {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            background-color: #5cb85c;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            background-color: #4cae4c;
        }
    </style>
</head>
<body>
    <h1>Máy tính đơn giản</h1>
    <form action="exercise03" method="post">
        <label for="first-number">Số thứ nhất:</label>
        <input type="text" name="first-number" id="first-number" required>
        <label for="second-number">Số thứ hai:</label>
        <input type="text" name="second-number" id="second-number" required>
        <label for="operation">Phép tính:</label>
        <select name="operation" id="operation">
            <option value="+">Cộng</option>
            <option value="-">Trừ</option>
            <option value="*">Nhân</option>
            <option value="/">Chia</option>
        </select>
        <button type="submit">Tính toán</button>

    </form>
</body>
</html>
