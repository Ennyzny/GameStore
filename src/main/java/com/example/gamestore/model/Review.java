package com.example.gamestore.model;

public class Review {
    private Long id;
    private String reviewerName;
    private String comment;
    private int stars; // ocjena 1–5

    private Game game; // veza ka igri

    public Review() {
    }

    public Review(Long id, String reviewerName, String comment, int stars, Game game) {
        this.id = id;
        this.reviewerName = reviewerName;
        this.comment = comment;
        this.stars = stars;
        this.game = game;
    }

    // Getteri i setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
