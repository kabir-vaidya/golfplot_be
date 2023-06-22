package com.golfplot.api.score;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreIdClass implements Serializable {
    private int student;
    private int level_number;
}
