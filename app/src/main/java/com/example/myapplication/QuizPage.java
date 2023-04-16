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
//            "Have you experienced any significant changes in your mood or behavior lately?",
//            "Have you noticed any changes in your sleep patterns, such as difficulty falling asleep or staying asleep?",
//            "Have you experienced a loss of interest in activities that you used to enjoy?",
//            "Have you had thoughts of self-harm or suicide?",
//            "Have you been feeling more irritable or agitated than usual?"
            "I found myself getting upset by quite trivial things",
            "I was aware of dryness of my mouth",
            "I couldn't seem to experience any positive feeling at all",
            "I experienced breathing difficulty (eg, excessively rapid breathing,\n" +
                    "breathlessness in the absence of physical exertion)",
            "I just couldn't seem to get going",
            "I tended to over-react to situations",
            "I had a feeling of shakiness (eg, legs going to give way)",
            "I found it difficult to relax",
            "I found myself in situations that made me so anxious I was most\n" +
                    "relieved when they ended\n",
            "I felt that I had nothing to look forward to",
            "I found myself getting upset rather easily",
            "I felt that I was using a lot of nervous energy",
            "I felt sad and depressed",
            "I found myself getting impatient when I was delayed in any way\n" +
                    "(eg, elevators, traffic lights, being kept waiting)\n",
            "I had a feeling of faintness",
            "I felt that I had lost interest in just about everything ",
            "I felt I wasn't worth much as a person ",
            "I felt that I was rather touchy",
            "I perspired noticeably (eg, hands sweaty) in the absence of high\n" +
                    "temperatures or physical exertion",
            "I felt scared without any good reason",
            "I felt that life wasn't worthwhile",
            "I found it hard to wind down ",
            "I had difficulty in swallowing ",
            "I couldn't seem to get any enjoyment out of the things I did",
            "I was aware of the action of my heart in the absence of physical\n" +
                    "exertion (eg, sense of heart rate increase, heart missing a beat)\n",
            "I felt down-hearted and blue",
            "I found that I was very irritable",
            "I felt I was close to panic",
            "I found it hard to calm down after something upset me",
            "I feared that I would be \"thrown\" by some trivial but\n" +
                    "unfamiliar task",
            "I was unable to become enthusiastic about anything",
            "I found it difficult to tolerate interruptions to what I was doing",
            " I was in a state of nervous tension",
            "I felt I was pretty worthless",
            "I was intolerant of anything that kept me from getting on with\n" +
                    "what I was doing",
            "I felt terrified",
            "I could see nothing in the future to be hopeful about",
            "I felt that life was meaningless",
            "I found myself getting agitated",
            "I was worried about situations in which I might panic and make\n" +
                    "a fool of myself",
            "I experienced trembling (eg, in the hands)",
            "I found it difficult to work up the initiative to do things"
    };

    private String[][] answers = {
//            {"0", "1", "2", "3"},
//            {"Yes", "No", "Sometime", "Always"},
//            {"Yes", "No", "Sometime", "Always"},
//            {"Yes", "No", "Sometime", "Always"},
//            {"Yes", "No", "Sometime", "Always"},
//            {"Asia", "Africa", "North America", "Europe"},
//            {"Monaco", "Nauru", "Vatican City", "San Marino"},
//            {"Mount Kilimanjaro", "Mount Everest", "Denali", "Matterhorn"},
//            {"Jupiter", "Saturn", "Uranus", "Neptune"}
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},
            {"0", "1", "2", "3"},

    };

//    private int[] correctAnswers = {2, 1, 3, 2, 0};
    private int[] correctAnswers = {1,1,1,1,1,1,1,1,1,1,11,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

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
