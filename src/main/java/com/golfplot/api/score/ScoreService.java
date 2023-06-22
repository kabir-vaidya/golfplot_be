package com.golfplot.api.score;
import com.golfplot.api.score.dto.UpdateStudentScoreDto;
import com.golfplot.api.student.Student;
import com.golfplot.api.student.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    StudentRepository studentRepository;


    @PersistenceContext
    EntityManager em;

    public Score updateStudentScore(int studentId, UpdateStudentScoreDto updateStudentScoreDto) {
        Student student = studentRepository.findById(studentId).orElse(null);
        return scoreRepository.save(new Score(student, updateStudentScoreDto.getLevelNumber(),updateStudentScoreDto.getScore()));
    }
}
