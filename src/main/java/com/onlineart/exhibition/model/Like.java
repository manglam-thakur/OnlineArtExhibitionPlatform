package com.onlineart.exhibition.model;

public class Like {
    private Long id;
    private Long userId;     // Foreign key to User
    private Long artworkId;  // Foreign key to Artwork
	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Like(Long id, Long userId, Long artworkId) {
		super();
		this.id = id;
		this.userId = userId;
		this.artworkId = artworkId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getArtworkId() {
		return artworkId;
	}
	public void setArtworkId(Long artworkId) {
		this.artworkId = artworkId;
	}
	@Override
	public String toString() {
		return "Like [id=" + id + ", userId=" + userId + ", artworkId=" + artworkId + "]";
	}

    
}
