package com.mathquiz.model;

public class MathQuestion {

    private int num1;
    private int num2;
    private String operator;
    private int answer;

    public MathQuestion(int num1, int num2, String operator, int answer) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        this.answer = answer;
    }

	public int getNum1() {
		return num1;
	}

	public int getNum2() {
		return num2;
	}

	public String getOperator() {
		return operator;
	}

	public int getAnswer() {
		return answer;
	}
}
