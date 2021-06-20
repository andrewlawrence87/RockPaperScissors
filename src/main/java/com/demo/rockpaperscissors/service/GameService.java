package com.demo.rockpaperscissors.service;

import com.demo.rockpaperscissors.model.HandChoice;
import com.demo.rockpaperscissors.model.Result;
import com.demo.rockpaperscissors.payload.GameResponse;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

import static com.demo.rockpaperscissors.model.HandChoice.*;
import static com.demo.rockpaperscissors.model.Result.*;

@Service
public class GameService {

    public GameResponse playGame(HandChoice handChoice) {
        GameResponse gameResponse = GameResponse.builder()
                .playerChoice(handChoice)
                .applicationChoice(generateHandChoice())
                .build();
        Result result = scoreGame(gameResponse.getPlayerChoice(), gameResponse.getApplicationChoice());
        System.out.println("Result is " + result);
        gameResponse.setResult(result);
        return gameResponse;
    }

    private HandChoice generateHandChoice() {
        switch (ThreadLocalRandom.current().nextInt(0, 2 + 1)) {
            case 0:
                return PAPER;
            case 1:
                return ROCK;
            case 2:
                return SCISSORS;
            default:
                throw new RuntimeException("Failed to generate application's choice");
        }
    }

    private Result scoreGame(HandChoice playerChoice, HandChoice appChoice) {
        switch (playerChoice) {
            case PAPER:
                switch (appChoice) {
                    case PAPER:
                        return DRAW;
                    case ROCK:
                        return WIN;
                    case SCISSORS:
                        return LOSE;
                }
            case ROCK:
                switch (appChoice) {
                    case PAPER:
                        return LOSE;
                    case ROCK:
                        return DRAW;
                    case SCISSORS:
                        return WIN;
                }
            case SCISSORS:
                switch (appChoice) {
                    case PAPER:
                        return WIN;
                    case ROCK:
                        return LOSE;
                    case SCISSORS:
                        return DRAW;
                }
            default:
                throw new RuntimeException("Failed to score game");
        }
    }
}
