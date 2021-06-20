package com.demo.rockpaperscissors.repositories;

import com.demo.rockpaperscissors.model.Result;
import lombok.*;
import org.springframework.data.annotation.Id;
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
    @Id
    private String id;
    @Indexed
    @NonNull
    private String playerName;
    @NonNull
    private String playerPassword;
    private Integer gamesPlayed;
    private Integer gamesWon;
    private Integer gamesLost;
    private Integer gamesDrawn;
    private Float winRatio;

    public Player(String playerName, String playerPassword){
        this.playerName = playerName;
        this.playerPassword = playerPassword;
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.gamesLost = 0;
        this.gamesDrawn = 0;
        this.winRatio = 0.0f;
    }

    private void calculateWinRatio() {
        winRatio = Float.valueOf(gamesWon) / Float.valueOf(gamesLost);
    }

    public void addResult(Result result){
        switch(result){
            case WIN:
                gamesWon++;
                calculateWinRatio();
                break;
            case LOSE:
                gamesLost++;
                calculateWinRatio();
                break;
            case DRAW:
                gamesDrawn++;
                break;
        }
    }
}
