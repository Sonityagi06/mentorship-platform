package com.hrit.mentorship_platform.servlet;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.hrit.mentorship_platform.dao.MessageDao;
import com.hrit.mentorship_platform.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/GetChatPartnersForMentorServlet")
public class GetChatPartnersForMentorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer mentorUserId = (Integer) session.getAttribute("user_id");

        if (mentorUserId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        MessageDao messageDao = new MessageDao();
        List<User> mentees = messageDao.getMenteesWithAcceptedAppointments(mentorUserId); // You'll write this method

        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(mentees));
    }
}

