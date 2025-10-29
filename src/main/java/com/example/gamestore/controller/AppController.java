package com.example.gamestore.controller;

import com.example.gamestore.data.DemoData;
import com.example.gamestore.model.Game;
import com.example.gamestore.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private DemoData demoData;

    // Lista svih igara
    @GetMapping("/games")
    public String getGames(Model model) {
        model.addAttribute("games", demoData.getGames());
        return "ListaIgara"; // Thymeleaf template za listu igara
    }

    // Lista svih recenzija
    @GetMapping("/reviews")
    public String getReviews(Model model) {
        List<Review> sortedReviews = demoData.getReviews().stream()
                .sorted((r1, r2) -> r1.getGame().getTitle().compareToIgnoreCase(r2.getGame().getTitle()))
                .collect(Collectors.toList()); // Popravljeno
        model.addAttribute("reviews", sortedReviews);
        return "ListaReview"; // Thymeleaf template za listu recenzija
    }

    // Detalji o igri i njene recenzije
    @GetMapping("/game/action/{id}")
    public String gameDetails(@PathVariable Long id, Model model) {
        Game game = demoData.getGameById(id);
        model.addAttribute("game", game);

        List<Review> gameReviews = demoData.getReviews().stream()
                .filter(r -> r.getGame().getId().equals(id))
                .collect(Collectors.toList()); // Popravljeno
        model.addAttribute("reviews", gameReviews);

        return "action"; // Thymeleaf template za detalje igre
    }

    // Dodavanje recenzije za igru
    @PostMapping("/game/addReview/{id}")
    public String addReview(
            @PathVariable Long id,
            @RequestParam String reviewerName,
            @RequestParam String comment,
            @RequestParam int stars,
            Model model
    ) {
        Game game = demoData.getGameById(id);

        Long newId = demoData.getReviews().stream()
                .mapToLong(Review::getId)
                .max()
                .orElse(0L) + 1;

        Review newReview = new Review(newId, reviewerName, comment, stars, game);
        demoData.getReviews().add(newReview);
        game.getReviews().add(newReview);

        List<Review> gameReviews = demoData.getReviews().stream()
                .filter(r -> r.getGame().getId().equals(id))
                .collect(Collectors.toList()); // Popravljeno

        model.addAttribute("game", game);
        model.addAttribute("reviews", gameReviews);

        return "action";
    }
}
