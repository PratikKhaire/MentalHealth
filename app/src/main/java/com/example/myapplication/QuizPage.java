package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizPage extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup answerRadioGroup;
    private RadioButton answerRadioButton1;
    private RadioButton answerRadioButton2;
    private RadioButton answerRadioButton3;
    private RadioButton answerRadioButton4;
    private Button nextButton;
    private Button submitButton;
    private TextView resultTextView;
    private Button ContactButton;

    private int currentQuestion = 1;
    private int score = 0;
    Intent intent;

    private String[] questions = {
            "What is the capital of France?",
            "What is the largest continent in the world?",
            "What is the smallest country in the world by land area?",
            "What is the highest mountain in the world?",
            "What is the largest planet in our solar system?"
    };

    private String[][] answers = {
            {"New York", "London", "Paris", "Tokyo"},
            {"Asia", "Africa", "North America", "Europe"},
            {"Monaco", "Nauru", "Vatican City", "San Marino"},
            {"Mount Kilimanjaro", "Mount Everest", "Denali", "Matterhorn"},
            {"Jupiter", "Saturn", "Uranus", "Neptune"}
    };

    private int[] correctAnswers = {2, 1, 3, 2, 0};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);

        questionTextView = findViewById(R.id.question_text_view);
        answerRadioGroup = findViewById(R.id.answer_radio_group);
        answerRadioButton1 = findViewById(R.id.answer_radio_button_1);
        answerRadioButton2 = findViewById(R.id.answer_radio_button_2);
        answerRadioButton3 = findViewById(R.id.answer_radio_button_3);
        answerRadioButton4 = findViewById(R.id.answer_radio_button_4);
        nextButton = findViewById(R.id.next_button);
        submitButton = findViewById(R.id.submit_button);
        resultTextView = findViewById(R.id.result_text_view);
        ContactButton=(Button) findViewById(R.id.ContactButton) ;

        // Start with the first question
        showQuestion(currentQuestion);

        // Set up the Next button to show the next question
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the user's answer
                int answer = getSelectedAnswer();
                if (answer == -1) {
                    return; // Don't move to the next question if no answer was selected
                }
                checkAnswer(answer);

                // Show the next question or end the quiz
                currentQuestion++;
                if (currentQuestion <= questions.length) {
                    showQuestion(currentQuestion);
                } else {
                    endQuiz();
                }
            }
        });

        // Set up the Submit button to end the quiz
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endQuiz();
            }
        });
    }

    private void showQuestion(int questionIndex) {
        // Show the question text
        String question = questions[questionIndex - 1];
        questionTextView.setText("Question " + questionIndex + " of " + questions.length + ": " + question);

        // Show the answer choices
        String[] answerChoices = answers[questionIndex - 1];
        answerRadioButton1.setText(answerChoices[0]);
        answerRadioButton2.setText(answerChoices[1]);
        answerRadioButton3.setText(answerChoices[2]);
        answerRadioButton4.setText(answerChoices[3]);
        // Clear the user's previous answer
        answerRadioGroup.clearCheck();
    }

    private int getSelectedAnswer() {
        // Get the index of the selected answer or -1 if no answer was selected
        int selectedId = answerRadioGroup.getCheckedRadioButtonId();
        switch (selectedId) {
            case R.id.answer_radio_button_1:
                return 0;
            case R.id.answer_radio_button_2:
                return 1;
            case R.id.answer_radio_button_3:
                return 2;
            case R.id.answer_radio_button_4:
                return 3;
            default:
                return -1;
        }
    }

    private void checkAnswer(int answer) {
        // Check if the user's answer is correct and update the score
        if (answer == correctAnswers[currentQuestion - 1]) {
            score++;
        }
    }

    private void endQuiz() {
        // Show the final score
        String result = "You got " + score + " out of " + questions.length + " questions correct!";
        resultTextView.setText(result);

        // Hide the question and answer choices
        questionTextView.setVisibility(View.GONE);
        answerRadioGroup.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);

        // Show the Submit button as disabled
        submitButton.setVisibility(View.VISIBLE);
        submitButton.setEnabled(false);

        ContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(QuizPage.this, Contact.class);
                startActivity(intent);
            }
        });
    }
}
