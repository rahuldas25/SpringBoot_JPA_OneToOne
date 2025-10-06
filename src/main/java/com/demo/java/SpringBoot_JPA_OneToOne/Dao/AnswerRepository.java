package com.demo.java.SpringBoot_JPA_OneToOne.Dao;

import com.demo.java.SpringBoot_JPA_OneToOne.Model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
}
