package com.samrogers.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView timerTextView;
    TextView scoreTextView;
    TextView sumTextView;
    TextView scoreFinalTextView;
    GridLayout gridLayout;
    CountDownTimer timer;
    Button answerButton1;
    Button answerButton2;
    Button answerButton3;
    Button answerButton4;
    Button playAgainButton;
    ArrayList<Integer> answers;
    int score;
    int scoreOutOf;
    int answer;
    //TODO - change to allow game length to be changed
    int gameLength = 10;

    Random randomGenerator = new Random();


    public void newSum(){
        scoreTextView.setText("Score: "+Integer.toString(score)+"/"+Integer.toString(scoreOutOf));

        int number1 = randomGenerator.nextInt(49)+1;
        int number2 = randomGenerator.nextInt(49)+1;
        answer = number1 + number2;

        int answerLowerBound = (int) (answer * 0.8f);
        int answerUpperBound = (int) (answer * 1.2f);

        int fakeAnswer1 = randomGenerator.nextInt(answerUpperBound+answerLowerBound+1);
        int fakeAnswer2 = randomGenerator.nextInt(answerUpperBound+answerLowerBound+1);
        int fakeAnswer3 = randomGenerator.nextInt(answerUpperBound+answerLowerBound+1);
        sumTextView.setText("Add together "+Integer.toString(number1)+" and "+Integer.toString(number2));

        answers = new ArrayList<Integer>();
        answers.add(answer);
        answers.add(fakeAnswer1);
        answers.add(fakeAnswer2);
        answers.add(fakeAnswer3);

        Collections.shuffle(answers);

        answerButton1.setText(answers.get(0).toString());
        answerButton2.setText(answers.get(1).toString());
        answerButton3.setText(answers.get(2).toString());
        answerButton4.setText(answers.get(3).toString());

    }

    public void checkForAnswer(View view) {
        Button clickedButton = (Button) view;

        if(Integer.valueOf(clickedButton.getText().toString()) == answer) {
            score += 1;
        }

        scoreOutOf += 1;
        newSum();


    }

    public void restartGame(View view) {
        goButtonClicked(view);
        scoreFinalTextView.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
    }

    public void goButtonClicked(View view) {

        view.setVisibility(View.INVISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        sumTextView.setVisibility(View.VISIBLE);
        gridLayout.setVisibility(View.VISIBLE);

        score = 0;
        scoreOutOf = 0;

        new CountDownTimer(gameLength*1000+100, 1000){
            public void onTick(long millisUntilFinished) {
                int timeLeft = (int) millisUntilFinished/1000;
                timerTextView.setText("Time remaining: "+Integer.toString(timeLeft));
            }

            public void onFinish() {
                timerTextView.setVisibility(View.INVISIBLE);
                scoreTextView.setVisibility(View.INVISIBLE);
                sumTextView.setVisibility(View.INVISIBLE);
                gridLayout.setVisibility(View.INVISIBLE);
                scoreFinalTextView.setText("Well done you scored:\r\n"+Integer.toString(score)+" out of "+Integer.toString(scoreOutOf));


                scoreFinalTextView.setVisibility(View.VISIBLE);
                playAgainButton.setVisibility(View.VISIBLE);

            }
        }.start();



        newSum();



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = (TextView)      findViewById(R.id.timerTextView);
        scoreTextView = (TextView)      findViewById(R.id.scoreTextView);
        sumTextView = (TextView)        findViewById(R.id.sumTextView);
        scoreFinalTextView = (TextView) findViewById(R.id.scoreFinalTextView);
        gridLayout = (GridLayout)       findViewById(R.id.gridLayout);
        playAgainButton = (Button)      findViewById(R.id.playAgainButton);
        answerButton1 = (Button)              findViewById(R.id.answerButton1);
        answerButton2 = (Button)              findViewById(R.id.answerButton2);
        answerButton3 = (Button)              findViewById(R.id.answerButton3);
        answerButton4 = (Button)              findViewById(R.id.answerButton4);
    }

    //more here
}
