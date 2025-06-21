package com.sathwikhbhat.quizapp.service;

import com.sathwikhbhat.quizapp.repository.QuestionsRepository;
import com.sathwikhbhat.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionsRepository questionsRepository;

    public List<Question> getAllQuestions() {
        return questionsRepository.findAll();
    }

}