package com.sathwikhbhat.quizapp.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    @NotBlank
    private Integer id;
    @NotBlank
    private String answer;
}