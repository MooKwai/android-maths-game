package com.samrogers.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timerTextView;
    TextView scoreTextView;
    TextView sumTextView;
    TextView scoreFinalTextView;
    GridLayout gridLayout;
    CountDownTimer timer;
    Button playAgainButton;

    public void goButtonClicked(View view) {
        view.setVisibility(View.INVISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        sumTextView.setVisibility(View.VISIBLE);
        gridLayout.setVisibility(View.VISIBLE);


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

    }

    //more here
}
