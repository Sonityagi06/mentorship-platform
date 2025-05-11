package com.hrit.mentorship_platform.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrit.mentorship_platform.dbconnection.DBConnection;
import com.hrit.mentorship_platform.model.Mentor;

public class MentorDao {
	

   
	public boolean addMentor(Mentor mentor) {
        String query = "INSERT INTO mentor (name, expertise, bio, contact_no, experience_years, user_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, mentor.getName());
            statement.setString(2, mentor.getExpertise());
            statement.setString(3, mentor.getBio());
            statement.setString(4, mentor.getContact_no());
            statement.setInt(5, mentor.getExperienceYears());
            statement.setInt(6, mentor.getUserId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error adding mentor: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // ✅ Get all mentors
    public List<Mentor> getAllMentors() {
        List<Mentor> mentors = new ArrayList<>();
        String sql = "SELECT * FROM mentor";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Mentor mentor = new Mentor();
                mentor.setId(rs.getInt("id"));
                mentor.setName(rs.getString("name"));
                mentor.setExpertise(rs.getString("expertise"));
                mentor.setBio(rs.getString("bio"));
                mentor.setContact_no(rs.getString("contact_no"));
                mentor.setExperienceYears(rs.getInt("experience_years"));
                mentor.setUserId(rs.getInt("user_id"));

                mentors.add(mentor);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving mentors: " + e.getMessage());
            e.printStackTrace();
        }

        return mentors;
    }
    
    public int getMentorIdByUserId(int userId) {
        int mentorId = -1;
        String sql = "SELECT id FROM mentor WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mentorId = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mentorId;
    }
    
    public Mentor getMentorByUserId(int userId) {
        Mentor mentor = null;
            String query = "SELECT * FROM mentor WHERE user_id = ?";
            try (Connection conn = DBConnection.getConnection();
                    PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mentor = new Mentor();
                mentor.setId(rs.getInt("id"));
                mentor.setName(rs.getString("name"));
                mentor.setExpertise(rs.getString("expertise"));
                mentor.setBio(rs.getString("bio"));
                mentor.setContact_no(rs.getString("contact_no"));
                mentor.setExperienceYears(rs.getInt("experience_years"));
                
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mentor;
    }



    public boolean updateMentorProfile(Mentor m) {
        boolean success = false;
        try (Connection con = DBConnection.getConnection()) {
            String query = "UPDATE mentor SET name=?, contact_no=?, expertise=?, bio=?, experience_years=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, m.getName());
            ps.setString(2, m.getContact_no());
            ps.setString(3, m.getExpertise());
            ps.setString(4, m.getBio());
            ps.setInt(5, m.getExperienceYears());
            ps.setInt(6, m.getId());
            success = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    // ✅ Check if profile exists for a given user
    public boolean profileExists(int userId) {
        String sql = "SELECT id FROM mentor WHERE user_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();  // true if any record exists
            }

        } catch (SQLException e) {
            System.err.println("Error checking profile existence: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }


}
