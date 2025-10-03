package com.shivani.ems.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DButil {
	
	 private static final String URL = "jdbc:mysql://localhost:3306/ems_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	    private static final String USER = "root";       
	    private static final String PASSWORD = "Shivi@0424"; 

	    private static Connection conn;

	    // Get database connection
	    public static Connection getConnection() {
	        if (conn != null) {
	            return conn; // return existing connection if already created
	        }

	        try {
	            // Optional in modern JDBC, but safe to include
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Create connection
	            conn = DriverManager.getConnection(URL, USER, PASSWORD);
	            System.out.println("Database connected successfully!");
	        } catch (ClassNotFoundException e) {
	            System.out.println("MySQL JDBC Driver not found!");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Connection Failed! Check output console");
	            e.printStackTrace();
	        }

	        return conn;
	    }

	    // Close connection
	    public static void closeConnection() {
	        if (conn != null) {
	            try {
	                conn.close();
	                conn = null;
	                System.out.println("Database connection closed.");
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}