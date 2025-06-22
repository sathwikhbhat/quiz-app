package com.sathwikhbhat.quizapp.controller;

import com.sathwikhbhat.quizapp.entity.QuestionWrapper;
import com.sathwikhbhat.quizapp.service.QuizService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@Slf4j
@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<?> createQuiz(@RequestParam String category,
                                        @RequestParam int numQ,
                                        @RequestParam String title) {
        quizService.createQuiz(category, numQ, title);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getQuiz(@PathVariable Integer id) {
        List<QuestionWrapper> quizQuestions = quizService.getQuizQuestions(id);
        return new ResponseEntity<>(quizQuestions, HttpStatus.OK);
    }
}