package com.hrit.mentorship_platform.servlet;

import java.io.IOException;

import com.hrit.mentorship_platform.dao.MentorDao;
import com.hrit.mentorship_platform.model.Mentor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/add-mentor")
public class AddMentorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
		        String name = request.getParameter("name");
		        String expertise = request.getParameter("expertise");
		        String bio = request.getParameter("bio");
		        String contactNo = request.getParameter("contactNo");
		        int experienceYears = Integer.parseInt(request.getParameter("experienceYears"));

		        // Retrieve user_id from session
		        Integer userId = (Integer) request.getSession(false).getAttribute("user_id");
		        if (userId == null) {
		            request.setAttribute("errorMessage", "Session expired. Please log in again.");
		            request.getRequestDispatcher("add-mentor.jsp").forward(request, response);
		            return;
		        }

		        Mentor mentor = new Mentor();
		        mentor.setName(name);
		        mentor.setExpertise(expertise);
		        mentor.setBio(bio);
		        mentor.setContact_no(contactNo);
		        mentor.setExperienceYears(experienceYears);
		        mentor.setUserId(userId); // now using Integer from session

		        MentorDao mentorDao = new MentorDao();
		        boolean isAdded = mentorDao.addMentor(mentor);

		        if (isAdded) {
		            response.sendRedirect("mentor-dashboard.jsp");
		        } else {
		            request.setAttribute("errorMessage", "Failed to add mentor. Please try again.");
		            request.getRequestDispatcher("add-mentor.jsp").forward(request, response);
		        }

		    } catch (NumberFormatException e) {
		        request.setAttribute("errorMessage", "Invalid number format. Please check your input.");
		        request.getRequestDispatcher("add-mentor.jsp").forward(request, response);
		    } catch (Exception e) {
		        request.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
		        request.getRequestDispatcher("add-mentor.jsp").forward(request, response);
		    }
    }

}
