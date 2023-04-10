package com.example.t3_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
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
    private User user;

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

        user = getIntent().getParcelableExtra("User");

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
        questionNumber++;
        if (questionNumber > 5) {
            Intent i = new Intent(this, DisplayScoreActivity.class);
            i.putExtra("score", String.valueOf(score));
            i.putExtra("User", user);
            startActivity(i);
            finish();
        } else {
            questSection.setText(question.getQuestionSection());
            opsi1.setText(question.getOpsi1());
            opsi2.setText(question.getOpsi2());
            opsi3.setText(question.getOpsi3());
            opsi4.setText(question.getOpsi4());
            questNumber.setText(String.valueOf(questionNumber));
        }
    }

    public void answerChecker(AppCompatButton button) {
        String answer = button.getText().toString();
        enableStatus(false);
        if (answer.equals(selectedQuestion.getAnswer())) {
            button.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Cerulean_Blue));
            score += selectedQuestion.getScore();
        } else {
            button.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Red_Violet));
        }

        button.postDelayed(() -> {
            enableStatus(true);
            button.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.French_Grey));
            selectedQuestion = questions.pop();
            setQuestion(selectedQuestion);
        }, 1500);
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
        question4 = new Question(79, "Kapan Unhas didirikan?", "1956", "1970", "1980", "Semua salah", "1956");
        question5 = new Question(85, "Di sisfo angkatan 21, siapa yang memiliki NIM akhiran 020", "Zabil", "Aflah", "Erwin", "Khaibar", "Khaibar");
        question6 = new Question(78, "Di pertandingan Manchester United melawan Liverpool (06/03/2023), Liverpool menang dengan skor ...", "1-0", "2-0", "7-0", "1-0", "7-0");
        question7 = new Question(83, "Berikut syntax yang benar untuk membuat array bertipe data string di java adalah ...", "String[] array", "String array", "int[] array", "Stack Array", "String[] array");
        question8 = new Question(88, "Siapakah klub bola Indonesia kebanggaan orang Makassar?", "Persib Bandung", "PSM Makassar", "Tarkam Unhas", "Sisfo United", "PSM Makassar");
    }
}