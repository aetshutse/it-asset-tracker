package com.itmanager.dao;

import com.itmanager.model.Asset;
import com.itmanager.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssetDAO {

    public void addAsset(Asset asset) {
        String sql = "INSERT INTO assets (asset_tag, device_type, model_name, status) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, asset.getAssetTag());
            pstmt.setString(2, asset.getDeviceType());
            pstmt.setString(3, asset.getModelName());
            pstmt.setString(4, asset.getStatus());
            pstmt.executeUpdate();
            System.out.println("Asset added successfully!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Asset> getAllAssets() {
        List<Asset> assets = new ArrayList<>();
        String sql = "SELECT * FROM assets";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Asset asset = new Asset(
                    rs.getString("asset_tag"),
                    rs.getString("device_type"),
                    rs.getString("model_name"),
                    rs.getString("status")
                );
                assets.add(asset);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assets;
    }

    // delete method
    public boolean deleteAsset(String assetTag) {
        String sql = "DELETE FROM assets WHERE asset_tag = ?"; 
        
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, assetTag);
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // update assert status
    public boolean updateAssetStatus(String assetTag, String newStatus) {
        String sql = "UPDATE assets SET status = ? WHERE asset_tag = ?";
        try (java.sql.Connection conn = com.itmanager.util.DatabaseConnection.getConnection(); 
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, newStatus);
            pstmt.setString(2, assetTag);
            return pstmt.executeUpdate() > 0;
            
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}