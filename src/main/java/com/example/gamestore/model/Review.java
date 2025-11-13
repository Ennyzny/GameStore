package com.example.gamestore.model;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String comment;
    private Double rating;

    @ManyToOne
    private Game game;

    public Review() {}

    public Review(String author, String comment, Double rating, Game game) {
        this.author = author;
        this.comment = comment;
        this.rating = rating;
        this.game = game;
    }

    // GETTERI I SETTERI
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public Game getGame() { return game; }
    public void setGame(Game game) { this.game = game; }
}
