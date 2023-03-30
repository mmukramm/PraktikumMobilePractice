package com.example.t3_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private CardView A, B, C, D;
    private TextView questNumber, questSection;
    private Question question1, question2,question3, question4, question5, question6, question7, question8, selectedQuestion;
    private AppCompatButton opsi1, opsi2, opsi3, opsi4;
    private Stack<Question> questions = new Stack<>();
    private int score = 0, questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questNumber = findViewById(R.id.questNumber);
        questSection = findViewById(R.id.questSection);
        opsi1 = findViewById(R.id.opsi1);
        opsi2 = findViewById(R.id.opsi2);
        opsi3 = findViewById(R.id.opsi3);
        opsi4 = findViewById(R.id.opsi4);

        makeQuestion();
        questions.addAll(Arrays.asList(question1, question2, question3, question4, question5, question6, question7, question8));
        Collections.shuffle(questions);
        selectedQuestion = questions.pop();
        setQuestion(selectedQuestion);

        opsi1.setOnClickListener(v-> { answerChecker(opsi1); });
        opsi2.setOnClickListener(v-> { answerChecker(opsi2); });
        opsi3.setOnClickListener(v-> { answerChecker(opsi3); });
        opsi4.setOnClickListener(v-> { answerChecker(opsi4); });
    }

    public void setQuestion(Question question) {
        questSection.setText(question.getQuestionSection());
        opsi1.setText(question.getOpsi1());
        opsi2.setText(question.getOpsi2());
        opsi3.setText(question.getOpsi3());
        opsi4.setText(question.getOpsi4());
        questionNumber++;
        questNumber.setText(String.valueOf(questionNumber));
    }

    public void answerChecker(AppCompatButton button) {
        String answer = button.getText().toString();
        enableStatus(false);
        if (answer.equals(selectedQuestion.getAnswer())) {
            button.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Cerulean_Blue));
            button.setTextColor(ContextCompat.getColorStateList(this, R.color.Raisin_Black));
            score += selectedQuestion.getScore();
        } else {
            score -= selectedQuestion.getScore();
            button.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Red_Violet));
            button.setTextColor(ContextCompat.getColorStateList(this, R.color.French_Grey));
        }
    }

    public void enableStatus (Boolean status) {
        opsi1.setEnabled(status);
        opsi2.setEnabled(status);
        opsi3.setEnabled(status);
        opsi4.setEnabled(status);
    }

    public void makeQuestion() {
        question1 = new Question(86, "Apa yang terjadi jika kita berkumur-kumur saat puasa?", "Selama menggunakan air biasa dan bukan kuah coto, tidak batal", "Batal", "Masuk Surga", "Makruh", "Selama menggunakan air biasa dan bukan kuah coto, tidak batal");
        question2 = new Question(92, "Sebelum di tamalanrea, Di mana letak kampus Unhas sebelumnya?", "Sudiang", "Samping rumahnya nenekku", "Baraya", "Pettarani", "Baraya");
        question3 = new Question(90, "Siapa nama presiden ketiga Indonesia?", "Jokowi", "Soeharto", "Gusdur", "Habibie", "Habibie");
        question4 = new Question(79, "1?", "opsi1", "opsi2", "opsi3", "opsi4", "opsi2");
        question5 = new Question(85, "2?", "opsi1", "opsi2", "opsi3", "opsi4", "opsi3");
        question6 = new Question(78, "3?", "opsi1", "opsi2", "opsi3", "opsi4", "opsi4");
        question7 = new Question(83, "4?", "opsi1", "opsi2", "opsi3", "opsi4", "opsi1");
        question8 = new Question(88, "5?", "opsi1", "opsi2", "opsi3", "opsi4", "opsi2");
    }


}