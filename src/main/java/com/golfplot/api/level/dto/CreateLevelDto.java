package com.golfplot.api.level.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateLevelDto {
    int number;
    String target_equation;
}
