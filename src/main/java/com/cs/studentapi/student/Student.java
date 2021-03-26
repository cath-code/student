package com.cs.studentapi.student;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender_type")
    private GenderType genderType;

    private String standard;

    @Column(name = "preferred_lesson_length")
    private Integer preferredLessonLength;

    @Enumerated(EnumType.STRING)
    @Column(name = "preferred_day")
    private DayOfWeek preferredDay;

    @Schema(example = "16:30:00")
    @Column(name = "preferred_time")
    private LocalTime preferredTime;

    private Integer rate;

    private String notes;
}

