package com.demo.java.SpringBoot_JPA_OneToOne.Control;

// com.demo.java.SpringBoot_JPA_OneToOne.Dao.ProductRepository;
import com.demo.java.SpringBoot_JPA_OneToOne.Dao.QuestionRepository;
import com.demo.java.SpringBoot_JPA_OneToOne.Model.Question;
import com.demo.java.SpringBoot_JPA_OneToOne.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerImpl {


    @Autowired
    private ProductService productService;

    @PostMapping("/addQA")
    public ResponseEntity<List<Question>> addQuestion(@RequestBody List<Question> question) {
        List<Question> saved = productService.saveAllQuestions(question);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/all")
    public List<Question> getAll() {
        return productService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable Integer id) {
        return productService.getQuestionById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        productService.deleteQuestion(id);
        return "Question deleted successfully";
    }
}
