package com.demo.java.SpringBoot_JPA_OneToOne.Model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "Answer_Table")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Integer Answer_id;
    private String answer_name;

    @OneToOne(mappedBy = "answer")
    private Question question;

    public Integer getAnswer_id() {
        return Answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        Answer_id = answer_id;
    }

    public String getAnswer_name() {
        return answer_name;
    }

    public void setAnswer_name(String answer_name) {
        this.answer_name = answer_name;
    }

    public Answer() {
        super();
    }

    public Answer(Integer Answer_id,String answer_name){
        super();
        this.Answer_id=Answer_id;
        this.answer_name=answer_name;
    }
}

