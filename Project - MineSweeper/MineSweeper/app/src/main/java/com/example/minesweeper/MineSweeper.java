package com.example.minesweeper;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MineSweeper extends AppCompatActivity {
    int numberofBombs;
    String level;
    public TextView in, sc;
    Button exitgame;
    GridView simpleGrid;
    TextView gettingScores;

    LayoutInflater inflater;
    int[][] values = new int[9][9];
    int[][] bomb = new int[9][9];

    int[] value = new int[81];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_sweeper);
        in = findViewById(R.id.level);
        sc = findViewById(R.id.score);
        exitgame = findViewById(R.id.exitg);
        gettingScores = findViewById(R.id.score);



        Intent intent = getIntent();
        if(intent.hasExtra("level")){
            level = intent.getStringExtra("level");
            System.out.println("level is "+level);
            if(level.equals("easy")){
                numberofBombs = 10;
            } else if(level.equals("medium")){
                numberofBombs = 20;
            }else {
                numberofBombs=30;
            }
            String temp1 = "Level ";
            String temp2 ="score is";
            in.setText(temp1+level+"");
            sc.setText(temp2+" 0"+"");
            Random r = new Random();
            for(int i= 0;i< numberofBombs;i++){
                System.out.println("number of bombs"+numberofBombs);
                int x = r.nextInt(9);
                int y = r.nextInt(9);
                if(bomb[x][y]==-1){
                    x = r.nextInt(9);
                    y = r.nextInt(9);
                }
                bomb[x][y] =-1;
                values[x][y] = -1;

            }



            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(bomb[i][j]!=-1){
                        values[i][j] = valueOf(i, j);
                    }
                }
            }

            //print
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(values[i][j]+"  ");
                }
                System.out.println("========");
            }

            //converting into 1 - D array

            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++) {
                    int pos = i*9+j;
                    value[pos] = values[i][j];
                }
            }





        }

        simpleGrid = (GridView) findViewById(R.id.simpleGridView);
        GridViewAdapter adapter = new GridViewAdapter(this,sc, value);
        simpleGrid.setAdapter(adapter);

        exitgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MineSweeper.this, scores.class);
                String s = (String) gettingScores.getText();
                i.putExtra("score",s);
                startActivity(i);
            }
        });


    }
    public int valueOf(int row, int col){
        int value = 0;
        if(check(row-1,col-1)) value++;
        if(check(row-1,col)) value++;
        if(check(row-1,col+1)) value++;
        if(check(row,col-1)) value++;
        if(check(row,col+1)) value++;
        if(check(row+1,col-1)) value++;
        if(check(row+1,col)) value++;
        if(check(row+1,col+1)) value++;

        return value;

    }

    public boolean check(int row, int col){
        if(row>=0 && col>=0 && row<9 && col<9) {
            if(bomb[row][col]==-1){
                return true;
            }
        }
        return false;
    }



}
