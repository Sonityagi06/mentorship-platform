<%@ page import="java.util.*, com.hrit.mentorship_platform.dao.AppointmentDao, com.hrit.mentorship_platform.model.Appointment, com.hrit.mentorship_platform.model.User, com.hrit.mentorship_platform.dao.MenteeDao" %>
<%
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    User user = (User) session.getAttribute("user");
    int userId = user.getId();

    MenteeDao menteeDao = new MenteeDao();
    int menteeId = menteeDao.getMenteeIdByUserId(userId);
    AppointmentDao dao = new AppointmentDao();
    List<Appointment> appointments = dao.getAppointmentsByMenteeId(menteeId);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Your Appointments</title>
    <link rel="stylesheet" href="css/mentee-appointments.css" />
</head>
<body>

   <div class="container">
    <h2>Your Appointments</h2>

    <%
        String success = request.getParameter("success");
        if ("true".equals(success)) {
    %>
        <p class="success-msg">Appointment booked successfully! Please wait for mentor approval.</p>
    <%
        }
    %>

    <% for (Appointment appt : appointments) { %>
        <div class="appointment-card">
            <h4>Mentor ID: <%= appt.getMentorId() %></h4>
            <p><strong>Date:</strong> <%= appt.getDate() %></p>
            <p><strong>Time:</strong> <%= appt.getTime() %></p>
            <p><strong>Topic:</strong> <%= appt.getTopic() %></p>
            <p class="status <%= appt.getStatus().toLowerCase() %>">
                Status: <%= appt.getStatus() %>
            </p>
        </div>
    <% } %>

    <a href="mentee-dashboard.jsp" class="back-link">Back to Dashboard</a>
</div>
</body>
</html>
