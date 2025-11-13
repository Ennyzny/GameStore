package com.example.gamestore.services;

import com.example.gamestore.model.Game;
import com.example.gamestore.repositories.GameRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepo gameRepository;

    public GameService(GameRepo gameRepository) {
        this.gameRepository = gameRepository;
    }

    // Vrati sve igre
    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    // Vrati igru po ID
    public Game findById(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        return game.orElse(null);
    }

    // Sačuvaj ili update igru
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    // Obriši igru po ID
    public void delete(Long id) {
        gameRepository.deleteById(id);
    }
}
