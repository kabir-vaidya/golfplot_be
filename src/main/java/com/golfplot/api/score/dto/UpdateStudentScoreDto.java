package com.golfplot.api.score.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateStudentScoreDto {
    @NotNull
    int level_number;

    @NotNull
    int score;

    public int getLevelNumber() {
        return level_number;
    }
}
