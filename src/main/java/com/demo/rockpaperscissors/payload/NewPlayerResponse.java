package com.demo.rockpaperscissors.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewPlayerResponse {
    private boolean success;
    private String message;
}
