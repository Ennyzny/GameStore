package com.example.gamestore.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Long id;
    private String title;
    private String genre;
    private String platform; // PC, PS5, Xbox
    private double rating;    // prosječna ocjena
    private double price;
    private String imageUrl;

    // 1:N → Jedna igra može imati više recenzija
    private List<Review> reviews = new ArrayList<>();

    public Game() {
    }

    public Game(Long id, String title, String genre, String platform, double rating, double price, String imageUrl) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.rating = rating;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Getteri i setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
