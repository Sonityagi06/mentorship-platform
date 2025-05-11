<%@ page import="com.hrit.mentorship_platform.model.User" %>
<%
    User user = (User) session.getAttribute("user");
    String mentorId = request.getParameter("mentorId");
    int menteeId = (Integer) session.getAttribute("user_id");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Book Appointment</title>
    <link rel="stylesheet" href="css/appointments.css">
</head>
<body>

<div class="form-box">
    <h2>Book Appointment</h2>
    <form action="book-appointment" method="post">
        <input type="hidden" name="mentorId" value="<%= mentorId %>">
        <input type="hidden" name="menteeId" value="<%= menteeId %>">
        
        <label>Date:</label>
        <input type="date" name="date" required>
        
        <label>Time:</label>
        <input type="time" name="time" required>
        
        <label>Topic:</label>
        <input type="text" name="topic" required placeholder="What do you want to discuss?">
        
        <button type="submit">Confirm Appointment</button>
    </form>
</div>

</body>
</html>
