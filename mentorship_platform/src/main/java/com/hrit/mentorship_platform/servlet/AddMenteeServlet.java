package com.hrit.mentorship_platform.servlet;

import java.io.IOException;



import com.hrit.mentorship_platform.dao.MenteeDao;
import com.hrit.mentorship_platform.model.Mentee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/add-mentee")
public class AddMenteeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            

            String name = request.getParameter("name");
            String course = request.getParameter("course");
            String bio = request.getParameter("bio");
            String contactNo = request.getParameter("contact_no");
            
         // Retrieve user_id from session
	        Integer userId = (Integer) request.getSession(false).getAttribute("user_id");
	        if (userId == null) {
	            request.setAttribute("errorMessage", "Session expired. Please log in again.");
	            request.getRequestDispatcher("add-mentor.jsp").forward(request, response);
	            return;
	        }

            Mentee mentee = new Mentee(0, name, course, bio, contactNo, userId);
            MenteeDao menteeDao = new MenteeDao();

            boolean isAdded = menteeDao.addMentee(mentee);

            if (isAdded) {
	            response.sendRedirect("mentee-dashboard.jsp");
	        } else {
	            request.setAttribute("errorMessage", "Failed to add mentor. Please try again.");
	            request.getRequestDispatcher("add-mentee.jsp").forward(request, response);
	        }

	    } catch (NumberFormatException e) {
	        request.setAttribute("errorMessage", "Invalid number format. Please check your input.");
	        request.getRequestDispatcher("add-mentee.jsp").forward(request, response);
	    } catch (Exception e) {
	        request.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
	        request.getRequestDispatcher("add-mentee.jsp").forward(request, response);
	    }
    }
}
