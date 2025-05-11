<%@ page import="java.util.List" %>
<%@ page import="com.hrit.mentorship_platform.model.Mentor" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mentor List</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .mentor-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
        }
        .mentor-box {
            width: 300px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease;
        }
        .mentor-box:hover {
            transform: translateY(-5px);
        }
        .mentor-box h2 {
            margin: 0 0 10px;
            color: #2c3e50;
        }
        .mentor-box p {
            margin: 5px 0;
            color: #555;
        }
        .book-btn {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 15px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }
        .book-btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <h1>Find Your Mentor</h1>

    <div class="mentor-container">
    <%
        List<Mentor> mentors = (List<Mentor>) request.getAttribute("mentors");
        if (mentors != null && !mentors.isEmpty()) {
            for (Mentor mentor : mentors) {
    %>
        <div class="mentor-box">
            <h2><%= mentor.getName() %></h2>
            <p><strong>Expertise:</strong> <%= mentor.getExpertise() %></p>
            <p><strong>Experience:</strong> <%= mentor.getExperienceYears() %> years</p>
            <p><strong>Bio:</strong> <%= mentor.getBio() %></p>
            <p><strong>Contact:</strong> <%= mentor.getContact_no() %></p>
            <a class="book-btn" href="appointments.jsp?mentorId=<%= mentor.getId() %>">Book Appointment</a>
        </div>
    <%
            }
        } else {
    %>
        <p>No mentors found.</p>
    <%
        }
    %>
    </div>
</body>
</html>
