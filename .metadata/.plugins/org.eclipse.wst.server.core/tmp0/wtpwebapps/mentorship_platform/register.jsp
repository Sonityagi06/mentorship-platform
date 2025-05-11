<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration On Mentorship Platform</title>

    <!-- Link to Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    
    <!-- Link to Font Awesome Icons for Input Icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    <style>
        /* General reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f0f4f8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            padding: 20px;
        }

        /* Container */
        .form-container {
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 450px;
            transition: all 0.3s ease;
        }

        .form-container:hover {
            box-shadow: 0 12px 30px rgba(0, 0, 0, 0.15);
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #4CAF50;
            font-weight: 600;
            font-size: 24px;
            text-transform: uppercase;
            letter-spacing: 2px;
        }

        /* Form Elements */
        label {
            font-size: 14px;
            color: #555;
            margin-bottom: 8px;
            display: block;
        }

        /* Input Fields */
        .input-group {
            position: relative;
            margin-bottom: 20px;
        }

        .input-group input, .input-group select {
            width: 100%;
            padding: 14px 40px 14px 40px; /* added padding to create space for icons */
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 14px;
            background-color: #f7f7f7;
            outline: none;
            transition: border-color 0.3s ease;
        }

        .input-group input:focus, .input-group select:focus {
            border-color: #4CAF50;
        }

        /* Input Icons */
        .input-group i {
            position: absolute;
            left: 12px;
            top: 50%;
            transform: translateY(-50%);
            color: #777;
        }

        /* Submit Button */
        input[type="submit"] {
            width: 100%;
            padding: 14px;
            background-color: #4CAF50;
            color: #fff;
            font-size: 16px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* Responsive */
        @media (max-width: 600px) {
            .form-container {
                padding: 20px;
            }

            .form-container h2 {
                font-size: 20px;
            }
        }

        /* Error message */
        .error {
            color: red;
            font-size: 12px;
        }
        
        /* Back Button Style */
.back-btn {
    display: inline-block;
    width: 100%;
    text-align: center;
    padding: 12px;
    margin-top: 10px;
    background-color: #4CAF50;
    color: white;
    font-size: 16px;
    border-radius: 8px;
    text-decoration: none;
    transition: background-color 0.3s ease;
}

.back-btn:hover {
    background-color: #45a049;
}
    </style>
</head>
<body>

    <div class="form-container">
        <h2>Register on Mentorship Platform</h2>
        <form action="register" method="post">
            
            <!-- Name Field with Icon -->
            <div class="input-group">
                <i class="fas fa-user"></i>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required placeholder="Enter your full name">
            </div>

            <!-- Email Field with Icon -->
            <div class="input-group">
                <i class="fas fa-envelope"></i>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required placeholder="Enter your email">
            </div>

            <!-- Password Field with Icon -->
            <div class="input-group">
                <i class="fas fa-lock"></i>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required placeholder="Enter your password">
            </div>

            <!-- Role Dropdown with Icon -->
            <div class="input-group">
                <i class="fas fa-users"></i>
                <label for="role">Role:</label>
                <select id="role" name="role" required>
                    <option value="mentor">Mentor</option>
                    <option value="mentee">Mentee</option>
                </select>
            </div>

            <!-- Submit Button -->
            <input type="submit" value="Register">
            
            <a href="index.jsp" class="back-btn">Back to Home</a>
            
            
        </form>
    </div>

</body>
</html>
