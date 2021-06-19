package com.demo.rockpaperscissors.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {
    Player findByPlayerName(String playerName);
}
