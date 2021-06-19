package com.demo.rockpaperscissors.payload;

import com.demo.rockpaperscissors.model.HandChoice;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class GameResponse {
    private HandChoice playerChoice;
    private HandChoice applicationChoice;
    private String result;
}
