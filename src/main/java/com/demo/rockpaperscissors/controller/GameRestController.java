package com.demo.rockpaperscissors.controller;

import com.demo.rockpaperscissors.model.HandChoice;
import com.demo.rockpaperscissors.payload.GameResponse;
import com.demo.rockpaperscissors.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/game")
@RequiredArgsConstructor
public class GameRestController {

    @Autowired
    private GameService gameService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public GameResponse playGame(@RequestBody HandChoice handChoice){
        //TODO add authentication for identifying user
        return gameService.playGame(handChoice);
    }
}
