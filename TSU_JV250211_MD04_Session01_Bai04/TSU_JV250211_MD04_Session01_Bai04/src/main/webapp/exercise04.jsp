<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 4/8/25
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        form {
            max-width: 400px;
            margin: auto;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        input[type="text"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
    </style>
</head>
<body>
  <h2>Currency Converter: USD to VND</h2>
  <form action="exercise04" method="post">
    <label for="rate">Rate:</label>
    <input type="text" id="rate" name="rate" placeholder="Enter your rate" required>
    <label for="usd">USD:</label>
    <input type="text" id="usd" name="usd" placeholder="Enter your USD" required>
    <button type="submit">Convert</button>
  </form>
</body>
</html>
