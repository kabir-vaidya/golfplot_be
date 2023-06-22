package com.golfplot.api.level;

import com.golfplot.api.level.dto.CreateLevelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {

    @Autowired
    LevelRepository levelRepository;

    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }

    public Level getLevelByNumber(int number) {
        return levelRepository.findByNumber(number);
    }

    public Level createLevelByNumber(CreateLevelDto createLevelDto) {
        Level existingLevel = levelRepository.findByNumber(createLevelDto.getNumber());
        if(existingLevel != null){
            levelRepository.deleteById(existingLevel.id);
        }
        return levelRepository.save(new Level(0, createLevelDto.getNumber(), createLevelDto.getTarget_equation()));
    }
}
