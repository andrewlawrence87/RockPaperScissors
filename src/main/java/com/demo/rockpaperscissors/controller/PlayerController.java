package com.demo.rockpaperscissors.controller;

import com.demo.rockpaperscissors.payload.NewPlayerRequest;
import com.demo.rockpaperscissors.repositories.Player;
import com.demo.rockpaperscissors.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
@RequiredArgsConstructor
public class PlayerController {

    private static final String PLAYER_CREATION_SUCCESS_MESSAGE = "New player created!";
    @Autowired
    PlayerService playerService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String createNewPlayer(@RequestBody NewPlayerRequest newPlayerRequest) {
        //TODO check if additional validation required
        playerService.createNewPlayer(newPlayerRequest);
        return PLAYER_CREATION_SUCCESS_MESSAGE;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Player getPlayerStats(@RequestBody String playerName) {
        //TODO remove password from response
        return playerService.getPlayer(playerName);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Player> getAllPlayersStats() {
        //TODO remove password from response
        return playerService.getAllPlayers();
    }
}
