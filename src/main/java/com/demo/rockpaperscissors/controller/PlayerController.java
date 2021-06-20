package com.demo.rockpaperscissors.controller;

import com.demo.rockpaperscissors.dto.PlayerDTO;
import com.demo.rockpaperscissors.payload.NewPlayerRequest;
import com.demo.rockpaperscissors.payload.NewPlayerResponse;
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

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public NewPlayerResponse createNewPlayer(@RequestBody NewPlayerRequest newPlayerRequest) {
        //TODO check if additional validation required
        return playerService.createNewPlayer(newPlayerRequest);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDTO getPlayerStats(@RequestParam String playerName) {
        return playerService.getPlayer(playerName);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDTO> getAllPlayersStats() {
        return playerService.getAllPlayers();
    }
}
