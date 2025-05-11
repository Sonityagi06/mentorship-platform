package com.hrit.mentorship_platform.servlet;

import com.hrit.mentorship_platform.dao.MessageDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/SendMessageServlet")
public class SendMessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	int senderId = Integer.parseInt(request.getParameter("senderId"));
        int receiverId = Integer.parseInt(request.getParameter("receiverId"));
        String messageText = request.getParameter("message");


        // Step 3: Use DAO to save message
        MessageDao messageDao = new MessageDao();
        boolean success = messageDao.sendMessage(senderId, receiverId, messageText);

        // Step 4: Redirect or error message
        if (success) {
            response.setStatus(HttpServletResponse.SC_OK);  // Let JS refresh messages
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Message sending failed. Please try again.");
        }
    }
}
