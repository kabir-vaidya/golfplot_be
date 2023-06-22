package com.golfplot.api.level;

import com.golfplot.api.level.dto.CreateLevelDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/level")
public class LevelController {

    @Autowired
    LevelService levelService;

    @GetMapping()
    public ResponseEntity<List<Level>> getAllLevels() {
        return new ResponseEntity<>(levelService.getAllLevels(), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<Level> getLevelByNumber(@PathVariable int number) {
        return new ResponseEntity<>(levelService.getLevelByNumber(number), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Level> createLevelByNumber(@RequestBody CreateLevelDto createLevelDto) {
        return new ResponseEntity<>(levelService.createLevelByNumber(createLevelDto), HttpStatus.OK);
    }
}
