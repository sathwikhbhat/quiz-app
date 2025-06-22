package com.sathwikhbhat.quizapp.controller;

import com.sathwikhbhat.quizapp.entity.QuestionWrapper;
import com.sathwikhbhat.quizapp.entity.Response;
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
        try {
            quizService.createQuiz(category, numQ, title);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error creating quiz: {}", e.getMessage());
            return new ResponseEntity<>("Error creating quiz: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getQuiz(@PathVariable Integer id) {
        try {
            List<QuestionWrapper> questions = quizService.getQuizQuestions(id);
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error fetching quiz: {}", e.getMessage());
            return new ResponseEntity<>("Error fetching quiz: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<?> submitQuiz(@PathVariable Integer id,
                                        @RequestBody List<Response> responses) {
        try {
            int score = quizService.calculateResult(id, responses);
            return new ResponseEntity<>(score, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error submitting quiz: {}", e.getMessage());
            return new ResponseEntity<>("Error submitting quiz: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}