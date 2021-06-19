package com.demo.rockpaperscissors.service;

import com.demo.rockpaperscissors.payload.NewPlayerRequest;
import com.demo.rockpaperscissors.payload.NewPlayerResponse;
import com.demo.rockpaperscissors.repositories.Player;
import com.demo.rockpaperscissors.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public NewPlayerResponse createNewPlayer(NewPlayerRequest newPlayerRequest) {
        //TODO implement createNewPlayer method
        return new NewPlayerResponse();
    }

    public Player getPlayer(String playerName) {
        return playerRepository.findByPlayerName(playerName);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
