package com.sathwikhbhat.quizapp.repository;

import com.sathwikhbhat.quizapp.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}