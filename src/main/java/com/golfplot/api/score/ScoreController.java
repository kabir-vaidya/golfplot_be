package com.golfplot.api.score;

import com.golfplot.api.score.dto.UpdateStudentScoreDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @PostMapping("/{studentId}")
    public ResponseEntity<Score> updateStudentScore(@PathVariable int studentId, @Valid @RequestBody UpdateStudentScoreDto updateStudentScoreDto) {
        Score updatedScore = scoreService.updateStudentScore(studentId, updateStudentScoreDto);
        return new ResponseEntity(updatedScore, HttpStatus.CREATED);
    }
}
