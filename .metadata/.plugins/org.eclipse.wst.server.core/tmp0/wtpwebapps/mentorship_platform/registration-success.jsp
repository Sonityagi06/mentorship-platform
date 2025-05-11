<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Successful</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .success-container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 400px;
        }

        h2 {
            color: #4CAF50;
            font-size: 24px;
        }

        p {
            color: #555;
            font-size: 16px;
        }

        .btn-login {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }

        .btn-login:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="success-container">
        <h2>Registration Successful!</h2>
        <p>You've been successfully registered. Click below to log in to your account.</p>
        <a href="login.jsp" class="btn-login">Go to Login</a>
    </div>
</body>
</html>
