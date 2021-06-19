package com.demo.rockpaperscissors.payload;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
public class NewPlayerResponse {
    private boolean success;
    private String message;
}
