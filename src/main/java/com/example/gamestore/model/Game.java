package com.example.gamestore.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private String platform;
    private Double rating;
    private Double price;
    private String imageUrl;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    public Game() {}

    // Konstruktor za sve polja osim company
    public Game(Long id, String title, String genre, String platform, Double rating, Double price, String imageUrl) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.rating = rating;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // GETTERI I SETTERI
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }

    // --- Reviews ---
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
        review.setGame(this);
    }
}
