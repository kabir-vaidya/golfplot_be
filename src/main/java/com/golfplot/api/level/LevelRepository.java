package com.golfplot.api.level;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Integer> {

    public Level findByNumber(int number);
}
