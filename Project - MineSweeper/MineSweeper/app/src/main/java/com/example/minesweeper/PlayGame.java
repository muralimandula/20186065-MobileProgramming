package com.example.minesweeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlayGame extends AppCompatActivity {

    private EditText name;
    private Button easy, medium, hard;
    String n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        name = findViewById(R.id.name);
        easy = findViewById(R.id.easy);
        medium = findViewById(R.id.medium);
        hard = findViewById(R.id.hard);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = name.getText().toString();

                if(checkName()){
                    Intent i = new Intent(PlayGame.this, MineSweeper.class);
                    i.putExtra("level", "easy");
                    startActivity(i);
                }

            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = name.getText().toString();
                if(checkName()){

                    Intent i = new Intent(PlayGame.this, MineSweeper.class);
                    i.putExtra("level", "medium");
                    startActivity(i);
                }

            }

        });


        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = name.getText().toString();
                if(checkName()){
                    Intent i = new Intent(PlayGame.this, MineSweeper.class);
                    i.putExtra("level", "hard");
                    startActivity(i);
                }

            }
        });


    }

    public boolean checkName(){
        System.out.println(" name is "+n);
        if(TextUtils.isEmpty(n)){
            Toast.makeText(this, "name should enter",Toast.LENGTH_SHORT).show();
            return false;

        } else {
            return true;
        }
    }



}
