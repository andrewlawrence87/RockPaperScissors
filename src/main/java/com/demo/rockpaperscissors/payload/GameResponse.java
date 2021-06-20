package com.demo.rockpaperscissors.payload;

import com.demo.rockpaperscissors.model.HandChoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameResponse {
    private HandChoice playerChoice;
    private HandChoice applicationChoice;
    private String result;
}
