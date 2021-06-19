package com.demo.rockpaperscissors.payload;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@Builder
public class NewPlayerRequest {
    @NonNull
    private String playerName;
    @NonNull
    private String playerPassword;
}
