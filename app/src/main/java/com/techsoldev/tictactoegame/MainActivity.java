package com.techsoldev.tictactoegame;

import static com.techsoldev.tictactoegame.Minmax.findBestMove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   // Minmax minmax = new Minmax();

    char board[][] = {{ 'x', 'o', 'x' },
            { 'o', 'o', 'x' },
            { '_', '_', '_' }};

    Minmax.Move bestMove = findBestMove(board);



}