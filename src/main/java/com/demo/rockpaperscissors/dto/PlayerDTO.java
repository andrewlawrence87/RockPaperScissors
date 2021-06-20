package com.demo.rockpaperscissors.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
public class PlayerDTO {
    private String playerName;
    private Integer gamesPlayed;
    private Integer gamesWon;
    private Integer gamesLost;
    private Integer gamesDrawn;
    private Float winRatio;
}
