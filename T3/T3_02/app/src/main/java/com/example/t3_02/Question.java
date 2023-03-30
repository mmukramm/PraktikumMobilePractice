package com.example.t3_02;

public class Question {
    private String questionSection, answer;
    public String opsi1, opsi2, opsi3, opsi4;
    private int questionNumber, score;

    public Question(int score, String questionSection, String opsi1, String opsi2, String opsi3, String opsi4, String answer) {
        this.score = score;
        this.questionSection = questionSection;
        this.opsi1 = opsi1;
        this.opsi2 = opsi2;
        this.opsi3 = opsi3;
        this.opsi4 = opsi4;
        this.answer = answer;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public int getScore() {
        return score;
    }

    public String getAnswer() {
        return answer;
    }

}
