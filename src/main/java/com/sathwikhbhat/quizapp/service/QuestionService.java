package com.sathwikhbhat.quizapp.service;

import com.sathwikhbhat.quizapp.entity.Question;
import com.sathwikhbhat.quizapp.repository.QuestionsRepository;
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

    public List<Question> getQuestionsByCategory(String category) {
        return questionsRepository.findByCategory(category);
    }

    public void addQuestion(Question question) {
        questionsRepository.save(question);
    }

    public void deleteQuestion(Integer id) {
        questionsRepository.deleteById(id);
    }
}