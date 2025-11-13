package com.example.gamestore.controller;

import com.example.gamestore.model.Game;
import com.example.gamestore.services.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameRestController {

    private final GameService gameService;

    public GameRestController(GameService gameService) {
        this.gameService = gameService;
    }

    // GET /api/games
    @GetMapping
    public List<Game> getAll() {
        return gameService.getAll();
    }

    // GET /api/games/{id}
    @GetMapping("/{id}")
    public Game getOne(@PathVariable Long id) {
        return gameService.findById(id);
    }

    // POST /api/games
    @PostMapping
    public Game add(@RequestBody Game game) {
        return gameService.save(game);
    }

    // PUT /api/games/{id}
    @PutMapping("/{id}")
    public Game update(@PathVariable Long id, @RequestBody Game game) {
        game.setId(id);
        return gameService.save(game);
    }

    // DELETE /api/games/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gameService.delete(id);
    }
}
