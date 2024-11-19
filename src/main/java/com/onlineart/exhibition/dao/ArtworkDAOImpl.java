package com.onlineart.exhibition.dao;

import com.onlineart.exhibition.model.Artwork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtworkDAOImpl implements ArtworkDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/art_exhibition";
    private static final String USER = "root";
    private static final String PASSWORD = "Alto@2027";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    @Override
    public void save(Artwork artwork) {
        String query = "INSERT INTO artworks (name, description) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, artwork.getName());
            stmt.setString(2, artwork.getDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long artworkId) {
        String query = "DELETE FROM artworks WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, artworkId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Artwork findById(Long artworkId) {
        Artwork artwork = null;
        String query = "SELECT * FROM artworks WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, artworkId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                artwork = new Artwork();
                artwork.setId(rs.getLong("id"));
                artwork.setName(rs.getString("name"));
                artwork.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artwork;
    }

    @Override
    public List<Artwork> findAll() {
        List<Artwork> artworks = new ArrayList<>();
        String query = "SELECT * FROM artworks";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Artwork artwork = new Artwork();
                artwork.setId(rs.getLong("id"));
                artwork.setName(rs.getString("name"));
                artwork.setDescription(rs.getString("description"));
                artworks.add(artwork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artworks;
    }
}

