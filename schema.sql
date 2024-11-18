CREATE DATABASE art_exhibition;
USE art_exhibition;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    email VARCHAR(100),
    password VARCHAR(100),
    role ENUM('ARTIST', 'VISITOR', 'ADMIN') DEFAULT 'VISITOR'
);

CREATE TABLE artworks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    description TEXT,
    image_url VARCHAR(255),
    artist_id BIGINT,
    FOREIGN KEY (artist_id) REFERENCES users(id)
);

CREATE TABLE likes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    artwork_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (artwork_id) REFERENCES artworks(id)
);
