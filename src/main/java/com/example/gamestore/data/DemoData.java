package com.example.gamestore.data;

import com.example.gamestore.model.Game;
import com.example.gamestore.model.Review;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DemoData {
    private List<Game> games = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();

    public DemoData() {
        // Kreiranje igara
        Game g1 = new Game(1L, "Cyberpunk 2077", "RPG", "PC", 8.2, 59.99, "/images/cyberpunk.jpg");
        Game g2 = new Game(2L, "Elden Ring", "Action RPG", "PC", 9.5, 69.99, "/images/eldenring.jpg");
        Game g3 = new Game(3L, "Red Dead Redemption 2", "Adventure", "PS5", 9.7, 49.99, "/images/reddead.jpg");
        Game g4 = new Game(4L, "The Witcher 3", "Fantasy RPG", "PC", 9.6, 39.99, "/images/witcher.jpg");
        Game g5 = new Game(5L, "Minecraft", "Sandbox", "Xbox", 9.0, 19.99, "/images/mc.png");

        games.add(g1);
        games.add(g2);
        games.add(g3);
        games.add(g4);
        games.add(g5);

        // Kreiranje recenzija
        Review r1 = new Review(1L, "Amar", "Odlična igra, ali puno bugova.", 4, g1);
        Review r2 = new Review(2L, "Sara", "Fenomenalna grafika!", 5, g1);

        Review r3 = new Review(3L, "Haris", "Najbolja RPG igra ikad.", 5, g2);
        Review r4 = new Review(4L, "Mina", "Igra je preteška na početku.", 4, g2);

        Review r5 = new Review(5L, "Emir", "Priča je nevjerovatna.", 5, g3);
        Review r6 = new Review(6L, "Amar", "Predugo traje tutorial.", 4, g3);

        Review r7 = new Review(7L, "Sara", "Fantastičan svijet i zadaci.", 5, g4);
        Review r8 = new Review(8L, "Haris", "Malo stara grafika, ali super gameplay.", 4, g4);

        Review r9 = new Review(9L, "Mina", "Igra je zabavna za cijelu porodicu.", 5, g5);
        Review r10 = new Review(10L, "Emir", "Sandbox mode je super kreativan.", 5, g5);

        reviews.add(r1);
        reviews.add(r2);
        reviews.add(r3);
        reviews.add(r4);
        reviews.add(r5);
        reviews.add(r6);
        reviews.add(r7);
        reviews.add(r8);
        reviews.add(r9);
        reviews.add(r10);

        // Povezivanje recenzija sa igrama
        g1.getReviews().add(r1);
        g1.getReviews().add(r2);

        g2.getReviews().add(r3);
        g2.getReviews().add(r4);

        g3.getReviews().add(r5);
        g3.getReviews().add(r6);

        g4.getReviews().add(r7);
        g4.getReviews().add(r8);

        g5.getReviews().add(r9);
        g5.getReviews().add(r10);
    }

    public List<Game> getGames() {
        return games;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public Game getGameById(Long id) {
        return games.stream()
                .filter(game -> game.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
