package com.sathwikhbhat.quizapp.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionWrapper {
    @NotBlank
    private Integer id;
    @NotBlank
    private String questionTitle;
    @NotBlank
    private String option1;
    @NotBlank
    private String option2;
    @NotBlank
    private String option3;
    @NotBlank
    private String option4;
}