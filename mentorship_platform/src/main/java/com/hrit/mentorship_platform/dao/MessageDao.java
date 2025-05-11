package com.hrit.mentorship_platform.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrit.mentorship_platform.dbconnection.DBConnection;
import com.hrit.mentorship_platform.model.Message;
import com.hrit.mentorship_platform.model.User;

public class MessageDao {
	
	public boolean sendMessage(int senderId, int receiverId, String messageContent) {
		String sql = "INSERT INTO messages (sender_id, receiver_id, message, timestamp) VALUES (?, ?, ?, NOW())";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, senderId);
	        stmt.setInt(2, receiverId);
	        stmt.setString(3, messageContent);
	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public List<Message> getMessagesBetween(int senderId, int receiverId) {
	    List<Message> messages = new ArrayList<>();
	    String sql = "SELECT * FROM messages " +
	                 "WHERE (sender_id = ? AND receiver_id = ?) " +
	                 "   OR (sender_id = ? AND receiver_id = ?) " +
	                 "ORDER BY timestamp ASC";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, senderId);
	        stmt.setInt(2, receiverId);
	        stmt.setInt(3, receiverId);
	        stmt.setInt(4, senderId);

	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            Message msg = new Message();
	            msg.setId(rs.getInt("id"));
	            msg.setSenderId(rs.getInt("sender_id"));
	            msg.setReceiverId(rs.getInt("receiver_id"));
	            msg.setMessage(rs.getString("message"));
	            msg.setTimestamp(rs.getTimestamp("timestamp"));
	            messages.add(msg);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return messages;
	}
	
	public List<User> getChatPartners(int menteeId) {
	    List<User> partners = new ArrayList<>();
	    String sql = "SELECT DISTINCT u.id, u.name " +
	             "FROM appointments a " +
	             "JOIN mentor m ON a.mentor_id = m.id " +
	             "JOIN user_login u ON m.user_id = u.id " +
	             "WHERE a.mentee_id = ?";




	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, menteeId);

	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            User user = new User();
	            user.setId(rs.getInt("id"));
	            user.setName(rs.getString("name"));
	            partners.add(user);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return partners;
	}

	public List<User> getMenteesWithAcceptedAppointments(int mentorUserId) {
	    List<User> mentees = new ArrayList<>();
	    String sql = "SELECT u.id, u.name, u.email FROM appointments a " +
	                 "JOIN mentee m ON a.mentee_id = m.id " +
	                 "JOIN user_login u ON m.user_id = u.id " +
	                 "WHERE a.mentor_id = ? AND a.status = 'accepted'";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, mentorUserId);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            User mentee = new User();
	            mentee.setId(rs.getInt("id")); // This is user_login.id
	            mentee.setName(rs.getString("name"));
	            mentee.setEmail(rs.getString("email"));
	            mentees.add(mentee);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return mentees;
	}


}
