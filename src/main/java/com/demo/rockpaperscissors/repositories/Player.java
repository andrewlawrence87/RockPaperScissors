package com.demo.rockpaperscissors.repositories;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@Document(collection = "players")
public class Player {
    @Indexed
    @NonNull
    private String playerName;
    @NonNull
    private String playerPassword;
    private Integer gamesPlayed;
    private Integer gamesWon;
    private Integer gamesLost;
    private Float winRatio;

    public void calculateWinRatio() {
        winRatio = Float.valueOf(gamesWon) / Float.valueOf(gamesLost);
    }
}
