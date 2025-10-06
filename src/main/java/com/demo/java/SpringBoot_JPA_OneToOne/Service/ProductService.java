package com.demo.java.SpringBoot_JPA_OneToOne.Service;

import com.demo.java.SpringBoot_JPA_OneToOne.Dao.AnswerRepository;
//import com.demo.java.SpringBoot_JPA_OneToOne.Dao.ProductRepository;
import com.demo.java.SpringBoot_JPA_OneToOne.Dao.QuestionRepository;
import com.demo.java.SpringBoot_JPA_OneToOne.Model.Answer;
import com.demo.java.SpringBoot_JPA_OneToOne.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    //Add question with answer
    public Question addQuestionWithAnswer(Question question, Answer answer) {
        answerRepository.save(answer);
        question.setAnswer(answer);
        return questionRepository.save(question);
    }
    public List<Question> saveAllQuestions(List<Question> questions) {
        for (Question q : questions) {
            Answer answer = q.getAnswer();
            if (answer != null) {
                answerRepository.save(answer);
                q.setAnswer(answer);
            }
        }
        return questionRepository.saveAll(questions);
    }

    // Get all Questions
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    //  Get Question by ID
    public Optional<Question> getQuestionById(Integer id) {
        return questionRepository.findById(id);
    }

    // Delete Question by ID
    public void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
    }

    // Update Answer for a Question
    public Question updateAnswer(Integer questionId, Answer newAnswer) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        Answer savedAnswer = answerRepository.save(newAnswer);
        question.setAnswer(savedAnswer);
        return questionRepository.save(question);
    }
}
