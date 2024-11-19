package com.onlineart.exhibition.dao;

import com.onlineart.exhibition.model.Artwork;
import java.util.List;

public interface ArtworkDAO {
    void save(Artwork artwork);
    void delete(Long artworkId);
    Artwork findById(Long artworkId);
    List<Artwork> findAll();
}

