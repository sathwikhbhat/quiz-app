package com.sathwikhbhat.quizapp.service;

import com.sathwikhbhat.quizapp.entity.Question;
import com.sathwikhbhat.quizapp.entity.QuestionWrapper;
import com.sathwikhbhat.quizapp.entity.Quiz;
import com.sathwikhbhat.quizapp.entity.Response;
import com.sathwikhbhat.quizapp.repository.QuestionsRepository;
import com.sathwikhbhat.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionsRepository questionsRepository;

    public void createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionsRepository.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
    }

    public List<QuestionWrapper> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for (Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(
                    q.getId(),
                    q.getQuestionTitle(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4()
            );
            questionsForUser.add(qw);
        }
        return questionsForUser;
    }

    public int calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int score = 0;
        int i=0;

        for (Response r : responses) {
            if (r.getAnswer().equals(questions.get(i).getRightAnswer()))
                score++;
            i++;
        }

        return score;
    }
}