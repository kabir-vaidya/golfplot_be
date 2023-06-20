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
    LevelRepository levelRepository;

    @GetMapping()
    public ResponseEntity<List<Level>> getAllLevels() {
        return new ResponseEntity<>(levelRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<Level> getLevelByNumber(@PathVariable int number) {
        return new ResponseEntity<>(levelRepository.findByNumber(number), HttpStatus.OK);
    }

    @PostMapping("/{number}")
    public ResponseEntity<Level> createLevelByNumber(@RequestBody CreateLevelDto createLevelDto) {
        Level existingLevel = levelRepository.findByNumber(createLevelDto.getNumber());
        if(existingLevel != null){
            levelRepository.deleteById(existingLevel.id);
        }
        return new ResponseEntity<>(levelRepository.save(new Level(0, createLevelDto.getNumber(), createLevelDto.getTarget_equation())), HttpStatus.OK);
    }
}
