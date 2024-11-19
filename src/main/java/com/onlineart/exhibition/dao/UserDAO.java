package com.onlineart.exhibition.dao;

import com.onlineart.exhibition.model.User;
import java.util.List;

public interface UserDAO {
    void save(User user);
    void delete(Long userId);
    User findById(Long userId);
    List<User> findAll();
    User findByUsername(String username);
}
