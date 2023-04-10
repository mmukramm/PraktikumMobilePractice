package com.example.t3_02;

import androidx.appcompat.widget.AppCompatButton;

public class Question {
    private String questionSection, answer, opsi1, opsi2, opsi3, opsi4;
    private int score;

    public Question(int score, String questionSection, String opsi1, String opsi2, String opsi3, String opsi4, String answer) {
        this.score = score;
        this.questionSection = questionSection;
        this.opsi1 = opsi1;
        this.opsi2 = opsi2;
        this.opsi3 = opsi3;
        this.opsi4 = opsi4;
        this.answer = answer;
    }


    public String getQuestionSection() {
        return questionSection;
    }

    public int getScore() {
        return score;
    }

    public String getAnswer() {
        return answer;
    }

    public String getOpsi1() {
        return opsi1;
    }

    public String getOpsi2() {
        return opsi2;
    }

    public String getOpsi3() {
        return opsi3;
    }

    public String getOpsi4() {
        return opsi4;
    }
}
