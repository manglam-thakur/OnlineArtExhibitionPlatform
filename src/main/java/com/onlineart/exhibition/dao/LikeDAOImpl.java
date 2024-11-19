package com.onlineart.exhibition.dao;

import com.onlineart.exhibition.model.Like;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LikeDAOImpl implements LikeDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/art_exhibition";
    private static final String USER = "root";
    private static final String PASSWORD = "Alto@2027";

    // Get a database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    @Override
    public void save(Like like) {
        String query = "INSERT INTO likes (user_id, artwork_id) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, like.getUserId());
            stmt.setLong(2, like.getArtworkId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long likeId) {
        String query = "DELETE FROM likes WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, likeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Like> findLikesByUser(Long userId) {
        List<Like> likes = new ArrayList<>();
        String query = "SELECT * FROM likes WHERE user_id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Like like = new Like();
                like.setId(rs.getLong("id"));
                like.setUserId(rs.getLong("user_id"));
                like.setArtworkId(rs.getLong("artwork_id"));
                likes.add(like);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likes;
    }

    @Override
    public List<Like> findLikesByArtwork(Long artworkId) {
        List<Like> likes = new ArrayList<>();
        String query = "SELECT * FROM likes WHERE artwork_id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, artworkId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Like like = new Like();
                like.setId(rs.getLong("id"));
                like.setUserId(rs.getLong("user_id"));
                like.setArtworkId(rs.getLong("artwork_id"));
                likes.add(like);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likes;
    }

    @Override
    public boolean isLiked(Long userId, Long artworkId) {
        String query = "SELECT * FROM likes WHERE user_id = ? AND artwork_id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, userId);
            stmt.setLong(2, artworkId);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Returns true if a like exists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
