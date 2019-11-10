/**
 * class that sets the layout to the screen and sets the listeners
 *
 * @author John Haas
 */
package com.hw3.a15square;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /**
     * method that activates when the app is created
     *
     * @param savedInstanceState current state of the game
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets the layout to the ipad
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sets the listeners to the game's surface view
        SquareBoard fifteenSquares = (SquareBoard)findViewById(R.id.fifteenSquareView);
        fifteenSquares.setOnTouchListener(fifteenSquares);
        fifteenSquares.setOnDragListener(fifteenSquares);
    }
}
