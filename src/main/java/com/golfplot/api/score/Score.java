package com.golfplot.api.score;

import com.golfplot.api.level.Level;
import com.golfplot.api.student.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ScoreIdClass.class)
public class Score {
    @NotNull
    @Id
    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "student_id")
    Student student;

    @NotNull
    @Min(1)
    @Id
    int level_number;

    @NotNull
    @PositiveOrZero
    int score;
}
