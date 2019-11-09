package com.hw3.a15square;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SquareBoard fifteenSquares = (SquareBoard)findViewById(R.id.fifteenSquareView);
        fifteenSquares.setOnTouchListener(fifteenSquares);
    }
}
