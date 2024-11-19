package com.onlineart.exhibition.dao;

import com.onlineart.exhibition.model.Like;
import java.util.List;

public interface LikeDAO {
    void save(Like like);
    void delete(Long likeId);
    List<Like> findLikesByUser(Long userId);
    List<Like> findLikesByArtwork(Long artworkId);
    boolean isLiked(Long userId, Long artworkId);  // Check if user has liked a specific artwork
}
