package com.hrit.mentorship_platform.servlet;

import java.io.IOException;

import com.hrit.mentorship_platform.dao.MenteeDao;

import com.hrit.mentorship_platform.model.Mentee;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/update-mentee-profile")
public class UpdateMenteeProfileServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int menteeId = Integer.parseInt(request.getParameter("menteeId"));
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        String course = request.getParameter("course");
        String bio = request.getParameter("bio");
        

        Mentee mentee = new Mentee(menteeId, name, bio, contact, course);

        MenteeDao dao = new MenteeDao();
        boolean updated = dao.updateMenteeProfile(mentee);

        if (updated) {
            response.sendRedirect("mentee-dashboard.jsp?msg=updated");
        } else {
            response.sendRedirect("edit-mentee-profile.jsp?msg=error");
        }
    }

}
