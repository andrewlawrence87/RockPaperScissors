package com.demo.rockpaperscissors.controller;

import com.demo.rockpaperscissors.model.HandChoice;
import com.demo.rockpaperscissors.payload.GameResponse;
import com.demo.rockpaperscissors.repositories.Player;
import com.demo.rockpaperscissors.service.GameService;
import com.demo.rockpaperscissors.service.PlayerService;
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

    @Autowired
    private PlayerService playerService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public GameResponse playGame(@RequestParam("handChoice") HandChoice handChoice){
        //TODO add authentication for identifying user
        Player player = playerService.getPlayer("andrew");
        GameResponse gameResponse = gameService.playGame(handChoice);
        System.out.println(gameResponse);
        player.addResult(gameResponse.getResult());
        playerService.updatePlayer(player);
        return gameResponse;
    }
}
