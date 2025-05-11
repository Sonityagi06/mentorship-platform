package com.hrit.mentorship_platform.test;

import java.sql.Connection;

import com.hrit.mentorship_platform.dbconnection.DBConnection;

public class TestDatabase {
	public static void main(String[] args) {
		Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("✅ Database Connected Successfully!");
        } else {
            System.out.println("❌ Database Connection Failed!");
        }
	}

}
