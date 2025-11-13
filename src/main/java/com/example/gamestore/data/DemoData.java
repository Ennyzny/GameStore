package com.example.gamestore.data;

import com.example.gamestore.model.Company;
import com.example.gamestore.model.Game;
import com.example.gamestore.model.Review;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class DemoData {
    private final Map<Long, Company> companies = new LinkedHashMap();
    private final Map<Long, Game> games = new LinkedHashMap();
    private final Map<Long, Review> reviews = new LinkedHashMap();
    private long companySeq = 1L;
    private long gameSeq = 1L;
    private long reviewSeq = 1L;

    public DemoData() {
        Company c1 = this.saveCompany(new Company((Long)null, "CD Projekt"));
        Company c2 = this.saveCompany(new Company((Long)null, "FromSoftware"));
        Company c3 = this.saveCompany(new Company((Long)null, "Rockstar Games"));
        Company c4 = this.saveCompany(new Company((Long)null, "Mojang"));
        Game g1 = this.saveGame(new Game((Long)null, "Cyberpunk 2077", "RPG", "PC", 8.2, 59.99, "/images/cyberpunk.jpg"));
        Game g2 = this.saveGame(new Game((Long)null, "Elden Ring", "Action RPG", "PC", (double)9.5F, 69.99, "/images/eldenring.jpg"));
        Game g3 = this.saveGame(new Game((Long)null, "Red Dead Redemption 2", "Adventure", "PS5", 9.7, 49.99, "/images/reddead.jpg"));
        Game g4 = this.saveGame(new Game((Long)null, "The Witcher 3", "Fantasy RPG", "PC", 9.6, 39.99, "/images/witcher.jpg"));
        Game g5 = this.saveGame(new Game((Long)null, "Minecraft", "Sandbox", "Xbox", (double)9.0F, 19.99, "/images/mc.png"));
        g1.setCompany(c1);
        c1.getGames().add(g1);
        g2.setCompany(c2);
        c2.getGames().add(g2);
        g3.setCompany(c3);
        c3.getGames().add(g3);
        g4.setCompany(c1);
        c1.getGames().add(g4);
        g5.setCompany(c4);
        c4.getGames().add(g5);
        this.saveReview(new Review("Amar", "Odlična igra, ali puno bugova.", 4.0, g1));
        this.saveReview(new Review("Sara", "Fenomenalna grafika!", 5.0, g1));
        this.saveReview(new Review("Haris", "Najbolja RPG igra ikad.", 5.0, g2));
        this.saveReview(new Review("Mina", "Igra je preteška na početku.", 4.0, g2));
        this.saveReview(new Review("Emir", "Priča je nevjerovatna.", 5.0, g3));
        this.saveReview(new Review("Amar", "Predugo traje tutorial.", 4.0, g3));
        this.saveReview(new Review("Sara", "Fantastičan svijet i zadaci.", 5.0, g4));
        this.saveReview(new Review("Haris", "Malo stara grafika, ali super gameplay.", 4.0, g4));
        this.saveReview(new Review("Mina", "Igra je zabavna za cijelu porodicu.", 5.0, g5));
        this.saveReview(new Review("Emir", "Sandbox mode je super kreativan.", 5.0, g5));

    }

    public List<Company> findAllCompanies() {
        return new ArrayList(this.companies.values());
    }

    public Company findCompany(Long id) {
        return (Company)this.companies.get(id);
    }

    public Company saveCompany(Company company) {
        if (company.getId() == null) {
            company.setId(Long.valueOf((long)(this.companySeq++)));
        }

        this.companies.put(company.getId(), company);
        return company;
    }

    public List<Game> findAllGames() {
        return new ArrayList(this.games.values());
    }

    public Game findGame(Long id) {
        return (Game)this.games.get(id);
    }

    public Game saveGame(Game game) {
        if (game.getId() == null) {
            game.setId(Long.valueOf((long)(this.gameSeq++)));
        }

        this.games.put(game.getId(), game);
        return game;
    }

    public List<Review> findAllReviews() {
        return new ArrayList(this.reviews.values());
    }

    public Review findReview(Long id) {
        return (Review)this.reviews.get(id);
    }

    public Review saveReview(Review review) {
        if (review.getId() == null) {
            review.setId(Long.valueOf((long)(this.reviewSeq++)));
        }

        this.reviews.put(review.getId(), review);
        if (review.getGame() != null) {
            review.getGame().  getReviews().add(review);
        }

        return review;
    }

    public List<Game> findGamesByCompany(Long companyId) {
        Company company = this.findCompany(companyId);
        return company == null ? List.of() : company.getGames();
    }

    public List<Review> findReviewsByGame(Long gameId) {
        Game game = this.findGame(gameId);
        return game == null ? List.of() : game.getReviews();
    }
}
