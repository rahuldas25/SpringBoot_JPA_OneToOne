package com.demo.java.SpringBoot_JPA_OneToOne.Dao;

import com.demo.java.SpringBoot_JPA_OneToOne.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
