package com.itmanager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; // new import
import java.sql.SQLException;

public class DatabaseConnection {
    
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/it_asset_db";
    private static final String USER = "admin"; 
    private static final String PASSWORD = "Science#08"; // REPLACE WITH ACTUAL password not placeholder

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // delete method
    public static boolean deleteAsset(String assetTag) {
        String sql = "DELETE FROM assets WHERE asset_tag = ?"; 
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, assetTag);
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // A quick test method to verify the connection works before we build the UI
    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            System.out.println("Success! Connected to the IT Asset Database.");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console.");
            e.printStackTrace();
        }
    }
}