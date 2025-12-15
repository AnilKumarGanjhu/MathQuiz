package com.mathquiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mathquiz.model.MathQuestion;
import com.mathquiz.service.MathService;

@Controller
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/quiz")
    public String quiz(Model model) {

        MathQuestion question = mathService.generateQuestion();

        model.addAttribute("num1", question.getNum1());
        model.addAttribute("num2", question.getNum2());
        model.addAttribute("operator", question.getOperator());

        return "index";
    }
    
    @PostMapping("/check")
    public String checkAnswer(
            @RequestParam int answer,
            @RequestParam int num1,
            @RequestParam int num2,
            @RequestParam String operator,
            Model model) {

        int correctAnswer = 0;

        switch (operator) {
            case "+":
                correctAnswer = num1 + num2;
                break;
            case "-":
                correctAnswer = num1 - num2;
                break;
            case "*":
                correctAnswer = num1 * num2;
                break;
        }

        model.addAttribute("equation",
                num1 + " " + operator + " " + num2 + " = " + answer);

        if (answer == correctAnswer) {
            model.addAttribute("result", "🎉 Correct!");
            model.addAttribute("isCorrect", true);
        } else {
            model.addAttribute("result",
                    "❌ Wrong! Correct answer is " + correctAnswer);
            model.addAttribute("isCorrect", false);
        }

        return "result";
    }

}
