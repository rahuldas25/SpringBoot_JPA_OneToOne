package com.demo.java.SpringBoot_JPA_OneToOne.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Question_Table")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer Question_id;

    private String question_Name;

    @OneToOne
    @JoinColumn(name = "a_id")
    private Answer answer;

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Integer getQuestion_id() {
        return Question_id;
    }

    public void setQuestion_id(Integer question_id) {
        Question_id = question_id;
    }

    public String getQuestion_Name() {
        return question_Name;
    }

    public void setQuestion_Name(String question_Name) {
        this.question_Name = question_Name;
    }
}