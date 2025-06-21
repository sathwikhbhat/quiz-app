package com.sathwikhbhat.quizapp.repository;

import com.sathwikhbhat.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<Question, Integer> {
}