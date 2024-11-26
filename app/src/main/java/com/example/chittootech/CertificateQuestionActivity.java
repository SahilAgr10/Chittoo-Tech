package com.example.chittootech;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CertificateQuestionActivity extends AppCompatActivity {
    private TextView questionTextView, timerTextView;
    private EditText answerEditText;
    private Button submitAnswerButton;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate_question);

        questionTextView = findViewById(R.id.questionTextView);
        timerTextView = findViewById(R.id.timerTextView);
        answerEditText = findViewById(R.id.answerEditText);
        submitAnswerButton = findViewById(R.id.submitAnswerButton);

        questionTextView.setText("Tell me about yourself?");
        startTimer();

        submitAnswerButton.setOnClickListener(v -> {
            String answer = answerEditText.getText().toString();
            if (!answer.isEmpty()) {
                Toast.makeText(this, "Answer Submitted: " + answer, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText("Time Left: " + millisUntilFinished / 1000 + " seconds");
            }

            @Override
            public void onFinish() {
                timerTextView.setText("Time's Up!");
                answerEditText.setEnabled(false);
                submitAnswerButton.setEnabled(true);
            }
        }.start();
    }
}
