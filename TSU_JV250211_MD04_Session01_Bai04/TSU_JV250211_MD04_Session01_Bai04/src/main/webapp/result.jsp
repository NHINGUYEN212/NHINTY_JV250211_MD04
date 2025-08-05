<%--
  Created by IntelliJ IDEA.
  User: nguyenthiyennhi
  Date: 4/8/25
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Conversion Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        .result-container {
            max-width: 400px;
            margin: 40px auto;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        p {
            font-size: 16px;
            margin: 10px 0;
            color: #555;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
        }

        a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="result-container">
    <h2>Conversion Result</h2>
    <p>Amount in USD: <%= request.getAttribute("usd")%>
    </p>
    <p>Exchange Rate: <%= request.getAttribute("rate")%>
    </p>
    <p>Amount in VND: <%= request.getAttribute("vnd")%>
    </p>
    <a href="exercise04">Convert Another Amount</a>
</div>

</body>
</html>
