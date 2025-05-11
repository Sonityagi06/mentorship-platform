package com.hrit.mentorship_platform.servlet;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.hrit.mentorship_platform.dao.MessageDao;
import com.hrit.mentorship_platform.model.Message;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/FetchMessagesServlet")
public class FetchMessagesServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException , IOException{
		
		int senderId = Integer.parseInt(request.getParameter("senderId"));
        int receiverId = Integer.parseInt(request.getParameter("receiverId"));

        MessageDao messageDao = new MessageDao();
        List<Message> messages = messageDao.getMessagesBetween(senderId, receiverId);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(messages));
	}

}
