package com.demo.rockpaperscissors.service;

import com.demo.rockpaperscissors.model.HandChoice;
import com.demo.rockpaperscissors.payload.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    PlayerService playerService;

    public GameResponse playGame(HandChoice handChoice) {
        //TODO implement playGame method
        return new GameResponse();
    }

}
