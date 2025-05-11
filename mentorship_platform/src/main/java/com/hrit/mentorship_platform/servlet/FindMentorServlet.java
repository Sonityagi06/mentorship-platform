package com.hrit.mentorship_platform.servlet;

import java.io.IOException;
import java.util.List;

import com.hrit.mentorship_platform.dao.MentorDao;
import com.hrit.mentorship_platform.model.Mentor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/find-mentor")
public class FindMentorServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MentorDao mentorDao;

    @Override
    public void init() throws ServletException {
        mentorDao = new MentorDao(); // No need to pass Connection if already managed inside DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	try {
            List<Mentor> mentors = mentorDao.getAllMentors();
            request.setAttribute("mentors", mentors);
            request.getRequestDispatcher("mentee-find-mentor.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to fetch mentor list.");
        }
    }
	

}
