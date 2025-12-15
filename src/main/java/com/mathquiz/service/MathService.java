package com.mathquiz.service;

import java.util.Random;
import org.springframework.stereotype.Service;
import com.mathquiz.model.MathQuestion;

@Service
public class MathService {

    private final Random random = new Random();

    public MathQuestion generateQuestion() {

        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        int op = random.nextInt(3);

        int answer;
        String operator;

        switch (op) {
            case 0:
                operator = "+";
                answer = num1 + num2;
                break;
            case 1:
                operator = "-";
                answer = num1 - num2;
                break;
            default:
                operator = "*";
                answer = num1 * num2;
        }

        return new MathQuestion(num1, num2, operator, answer);
    }

    public boolean checkAnswer(int userAnswer, int correctAnswer) {
        return userAnswer == correctAnswer;
    }
}
