package com.example.minesweeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class scores extends AppCompatActivity {
    String scores;
    TextView finalscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        finalscore = findViewById(R.id.finalscore);

//        Intent i = getIntent();
//        if(i.hasExtra("score")){
//            scores =  i.getStringExtra("score");
//
////            finalscore.setText(scores);
//        }
    }
}
