package com.example.gamestore.repositories;

import com.example.gamestore.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<Game, Long> {
}
