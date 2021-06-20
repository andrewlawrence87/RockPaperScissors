package com.demo.rockpaperscissors.repositories;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    public Player(String playerName, String playerPassword){
        this.playerName = playerName;
        this.playerPassword = playerPassword;
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.gamesLost = 0;
        this.winRatio = 0.0f;
    }
}
