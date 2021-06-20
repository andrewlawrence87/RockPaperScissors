package com.demo.rockpaperscissors.service;

import com.demo.rockpaperscissors.dto.PlayerDTO;
import com.demo.rockpaperscissors.payload.NewPlayerRequest;
import com.demo.rockpaperscissors.payload.NewPlayerResponse;
import com.demo.rockpaperscissors.repositories.Player;
import com.demo.rockpaperscissors.repositories.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public NewPlayerResponse createNewPlayer(NewPlayerRequest newPlayerRequest) {
        if (playerRepository.findByPlayerName(newPlayerRequest.getPlayerName()) != null) {
            NewPlayerResponse.builder()
                    .message("Player already exists!")
                    .success(false)
                    .build();
        }
        //TODO encrypt password
        playerRepository.save(new Player(newPlayerRequest.getPlayerName(), newPlayerRequest.getPlayerPassword()));
        return NewPlayerResponse.builder()
                .message("New player " + newPlayerRequest.getPlayerName() + " created!")
                .success(false)
                .build();
    }

    public PlayerDTO getPlayer(String playerName) {
        Player player = playerRepository.findByPlayerName(playerName);
        //TODO throw PlayerNotFoundException
        return convertPlayerToPlayerDTO(player);
    }

    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(this::convertPlayerToPlayerDTO)
                .collect(Collectors.toList());
    }

    private PlayerDTO convertPlayerToPlayerDTO(Player player) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        PlayerDTO playerDTO = modelMapper
                .map(player, PlayerDTO.class);
        return playerDTO;
    }
}
