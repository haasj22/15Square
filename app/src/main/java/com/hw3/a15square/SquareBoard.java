/**
 * class that handles all actions regarding the surface view that the game is played on
 */
package com.hw3.a15square;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;

public class SquareBoard extends SurfaceView implements View.OnTouchListener, View.OnDragListener{

    //necessary bitmaps
    Bitmap resetGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.reset_button);
    Bitmap blankGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.blank_piece);
    Bitmap oneGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece1);
    Bitmap twoGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece2);
    Bitmap threeGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece3);
    Bitmap fourGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece4);
    Bitmap fiveGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece5);
    Bitmap sixGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece6);
    Bitmap sevenGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece7);
    Bitmap eightGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece8);
    Bitmap nineGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece9);
    Bitmap tenGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece10);
    Bitmap elevenGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece11);
    Bitmap twelveGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece12);
    Bitmap thirteenGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece13);
    Bitmap fourteenGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece14);
    Bitmap fifteenGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.piece15);
    Bitmap completeOneGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece1);
    Bitmap completeTwoGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece2);
    Bitmap completeThreeGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece3);
    Bitmap completeFourGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece4);
    Bitmap completeFiveGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece5);
    Bitmap completeSixGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece6);
    Bitmap completeSevenGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece7);
    Bitmap completeEightGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece8);
    Bitmap completeNineGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece9);
    Bitmap completeTenGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece10);
    Bitmap completeElevenGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece11);
    Bitmap completeTwelveGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece12);
    Bitmap completeThirteenGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece13);
    Bitmap completeFourteenGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece14);
    Bitmap completeFifteenGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.complete_piece15);
    Bitmap scaledResetGraphic;
    Bitmap scaledBlankGraphic;
    Bitmap scaledOneGraphic;
    Bitmap scaledTwoGraphic;
    Bitmap scaledThreeGraphic;
    Bitmap scaledFourGraphic;
    Bitmap scaledFiveGraphic;
    Bitmap scaledSixGraphic;
    Bitmap scaledSevenGraphic;
    Bitmap scaledEightGraphic;
    Bitmap scaledNineGraphic;
    Bitmap scaledTenGraphic;
    Bitmap scaledElevenGraphic;
    Bitmap scaledTwelveGraphic;
    Bitmap scaledThirteenGraphic;
    Bitmap scaledFourteenGraphic;
    Bitmap scaledFifteenGraphic;
    Bitmap scaledCompleteOneGraphic;
    Bitmap scaledCompleteTwoGraphic;
    Bitmap scaledCompleteThreeGraphic;
    Bitmap scaledCompleteFourGraphic;
    Bitmap scaledCompleteFiveGraphic;
    Bitmap scaledCompleteSixGraphic;
    Bitmap scaledCompleteSevenGraphic;
    Bitmap scaledCompleteEightGraphic;
    Bitmap scaledCompleteNineGraphic;
    Bitmap scaledCompleteTenGraphic;
    Bitmap scaledCompleteElevenGraphic;
    Bitmap scaledCompleteTwelveGraphic;
    Bitmap scaledCompleteThirteenGraphic;
    Bitmap scaledCompleteFourteenGraphic;
    Bitmap scaledCompleteFifteenGraphic;

    //instance variables
    private int[][] board = new int[4][4];
    private int boardHeight;
    private int boardWidth;
    private boolean isGameOver;
    private int storedRow;
    private int storedCol;

    /**
     * constructor for objects of the squareBoard class
     *
     * @param context resources for the surfaceView
     * @param attr attributes given by the XML to the surface view
     */
    public SquareBoard(Context context, AttributeSet attr) {
        //calls the super constructor and allows the surface view to draw
        super(context, attr);
        setWillNotDraw(false);

        //default values
        isGameOver=false;
        storedRow=-1;
        storedCol=-1;
    }

    /**
     * tells the game what to do when the tablets surface view size changes
     *
     * @param w the new width of the surface view
     * @param h the new height of the surface view
     * @param oldw the old width of the surface view
     * @param oldh the old height of the surface view
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //randomizes the values of the board
        randomizeBoard();
        //rescales the bitmaps
        boardHeight=h;
        boardWidth=w;
        scaleBitmaps();
    }

    /**
     * randomizes the values int the board variables
     */
    public void randomizeBoard() {
        //sets all the values in the board array to their defaults
        resetBoard();

        //goes through each number to be added to the board
        for(int num=1; num<=16; num++) {
            //randomizes a row and column number
            int row= (int)(Math.random() * 4);
            int col= (int)(Math.random() * 4);

            //if desired spot already contains a pieces generates a new random spot
            if(containsPiece(row, col)) {
                num--;
                continue;
            }
            //otherwise adds the number to that spot
            else {
                board[row][col] = num;
            }
        }

        //if the board cannot be solved rerandomizes the board
        if(!(this.containsLegalBoard())) {
            randomizeBoard();
        }
    }

    /**
     * method that sets every value in the board to its default value
     */
    public void resetBoard() {
        //goes through the board and sets each spot to its default value
        for(int row=0; row<4; row++) {
            for(int col=0; col<4; col++) {
                board[row][col] = -1;
            }
        }
    }

    /**
     * checks if a spot contains a piece
     *
     * @param row the desired row to be checked
     * @param col the desired col to be checked
     * @return true if there is a piece in the desired location
     *         false if there is not
     */
    public boolean containsPiece(int row, int col) {
        return board[row][col] != -1;
    }

    /**
     * External Citation
     * Date: 9 November 2019
     * Problem: I did not know how to tell whether a board was legal or not
     *
     * Resource: http://mathworld.wolfram.com/15Puzzle.html
     * Solution: In one of the paragraphs, it includes an algorithm for
     * determining legality which I implemented in my code
     */
    /**
     * method that checks if the current board layout could lead to a winning game
     *
     * @return true if board is solvable
     *         false if board is not solvable
     */
    public boolean containsLegalBoard() {
        //variables necessary for the calculation
        int rowOf16=-1;
        int numInversionCounts=0;
        //goes through each position in the board
        for(int boardIndex=0; boardIndex<16; boardIndex++) {
            //if that position contains the empty position store the row
            if(board[boardIndex / 4][boardIndex % 4] == 16) {
                rowOf16=boardIndex/4 + 1;
            }
            /*adds the number of spots after the current boardIndex that contain values less than
            that at the boardIndex to the numInversionCounts*/
            for(int nextNumbers=boardIndex + 1; nextNumbers<16; nextNumbers++) {
                if(board[boardIndex / 4][boardIndex % 4] > board[nextNumbers / 4][nextNumbers % 4]) {
                    numInversionCounts++;
                }
            }
        }
        //adds the rowOf16 to the numInversionCounts
        numInversionCounts+=rowOf16;

        /*if numInversionCounts is even that means that 16 is an even permutation of moves away from
        the winning setup meaning the board is solvable. If numInversionsCount is odd, the board
        is unsolvable*/
        if(numInversionCounts % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * scales all the bitmaps according to the current surfaceView width and size
     */
    public void scaleBitmaps() {
        //scales bitmaps
        scaledResetGraphic =
                Bitmap.createScaledBitmap(resetGraphic, boardHeight/4, boardHeight, false);
        scaledBlankGraphic =
                Bitmap.createScaledBitmap(blankGraphic, boardHeight/4, boardHeight/4, false);
        scaledOneGraphic =
                Bitmap.createScaledBitmap(oneGraphic, boardHeight/4, boardHeight/4, false);
        scaledTwoGraphic =
                Bitmap.createScaledBitmap(twoGraphic, boardHeight/4, boardHeight/4, false);
        scaledThreeGraphic =
                Bitmap.createScaledBitmap(threeGraphic, boardHeight/4, boardHeight/4, false);
        scaledFourGraphic =
                Bitmap.createScaledBitmap(fourGraphic, boardHeight/4, boardHeight/4, false);
        scaledFiveGraphic =
                Bitmap.createScaledBitmap(fiveGraphic, boardHeight/4, boardHeight/4, false);
        scaledSixGraphic =
                Bitmap.createScaledBitmap(sixGraphic, boardHeight/4, boardHeight/4, false);
        scaledSevenGraphic =
                Bitmap.createScaledBitmap(sevenGraphic, boardHeight/4, boardHeight/4, false);
        scaledEightGraphic =
                Bitmap.createScaledBitmap(eightGraphic, boardHeight/4, boardHeight/4, false);
        scaledNineGraphic =
                Bitmap.createScaledBitmap(nineGraphic, boardHeight/4, boardHeight/4, false);
        scaledTenGraphic =
                Bitmap.createScaledBitmap(tenGraphic, boardHeight/4, boardHeight/4, false);
        scaledElevenGraphic =
                Bitmap.createScaledBitmap(elevenGraphic, boardHeight/4, boardHeight/4, false);
        scaledTwelveGraphic =
                Bitmap.createScaledBitmap(twelveGraphic, boardHeight/4, boardHeight/4, false);
        scaledThirteenGraphic =
                Bitmap.createScaledBitmap(thirteenGraphic, boardHeight/4, boardHeight/4, false);
        scaledFourteenGraphic =
                Bitmap.createScaledBitmap(fourteenGraphic, boardHeight/4, boardHeight/4, false);
        scaledFifteenGraphic =
                Bitmap.createScaledBitmap(fifteenGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteOneGraphic =
                Bitmap.createScaledBitmap(completeOneGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteTwoGraphic =
                Bitmap.createScaledBitmap(completeTwoGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteThreeGraphic =
                Bitmap.createScaledBitmap(completeThreeGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteFourGraphic =
                Bitmap.createScaledBitmap(completeFourGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteFiveGraphic =
                Bitmap.createScaledBitmap(completeFiveGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteSixGraphic =
                Bitmap.createScaledBitmap(completeSixGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteSevenGraphic =
                Bitmap.createScaledBitmap(completeSevenGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteEightGraphic =
                Bitmap.createScaledBitmap(completeEightGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteNineGraphic =
                Bitmap.createScaledBitmap(completeNineGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteTenGraphic =
                Bitmap.createScaledBitmap(completeTenGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteElevenGraphic =
                Bitmap.createScaledBitmap(completeElevenGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteTwelveGraphic =
                Bitmap.createScaledBitmap(completeTwelveGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteThirteenGraphic =
                Bitmap.createScaledBitmap(completeThirteenGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteFourteenGraphic =
                Bitmap.createScaledBitmap(completeFourteenGraphic, boardHeight/4, boardHeight/4, false);
        scaledCompleteFifteenGraphic =
                Bitmap.createScaledBitmap(completeFifteenGraphic, boardHeight/4, boardHeight/4, false);
    }

    /**
     * determines which bitmap to draw based on the desired row and num
     *
     * @param row row to search
     * @param col col to search
     * @return the Bitmap to be drawn
     */
    public Bitmap assignProperBitmap(int row, int col) {
        switch (board[row][col]) {
            case 1: //piece is a 1
                if (isGameOver == false) {
                    return scaledOneGraphic;
                } else {
                    return scaledCompleteOneGraphic;
                }
            case 2: //piece is a 2
                if (isGameOver == false) {
                    return scaledTwoGraphic;
                } else {
                    return scaledCompleteTwoGraphic;
                }
            case 3: //piece is a 3
                if (isGameOver == false) {
                    return scaledThreeGraphic;
                } else {
                    return scaledCompleteThreeGraphic;
                }
            case 4: //piece is a 4
                if (isGameOver == false) {
                    return scaledFourGraphic;
                } else {
                    return scaledCompleteFourGraphic;
                }
            case 5: //piece is a 5
                if (isGameOver == false) {
                    return scaledFiveGraphic;
                } else {
                    return scaledCompleteFiveGraphic;
                }
            case 6: //piece is a 6
                if (isGameOver == false) {
                    return scaledSixGraphic;
                } else {
                    return scaledCompleteSixGraphic;
                }
            case 7: //piece is a 7
                if (isGameOver == false) {
                    return scaledSevenGraphic;
                } else {
                    return scaledCompleteSevenGraphic;
                }
            case 8: //piece is a 8
                if (isGameOver == false) {
                    return scaledEightGraphic;
                } else {
                    return scaledCompleteEightGraphic;
                }
            case 9: //piece is a 9
                if (isGameOver == false) {
                    return scaledNineGraphic;
                } else {
                    return scaledCompleteNineGraphic;
                }
            case 10: //piece is a 10
                if (isGameOver == false) {
                    return scaledTenGraphic;
                } else {
                    return scaledCompleteTenGraphic;
                }
            case 11: //piece is a 11
                if (isGameOver == false) {
                    return scaledElevenGraphic;
                } else {
                    return scaledCompleteElevenGraphic;
                }
            case 12: //piece is a 12
                if (isGameOver == false) {
                    return scaledTwelveGraphic;
                } else {
                    return scaledCompleteTwelveGraphic;
                }
            case 13: //piece is a 13
                if (isGameOver == false) {
                    return scaledThirteenGraphic;
                } else {
                    return scaledCompleteThirteenGraphic;
                }
            case 14: //piece is a 14
                if (isGameOver == false) {
                    return scaledFourteenGraphic;
                } else {
                    return scaledCompleteFourteenGraphic;
                }
            case 15: //piece is a 15
                if (isGameOver == false) {
                    return scaledFifteenGraphic;
                } else {
                    return scaledCompleteFifteenGraphic;
                }
            default: //defaults to empty graphic
                return scaledBlankGraphic;
        }

    }

    /**
     * instructions for how to draw the surface view
     *
     * @param canvas where stuff will be drawn on
     */
    @Override
    public void onDraw(Canvas canvas) {
        /**
         * External Citation
         * Date:    31 October 2019
         * Problem: Didn't want to create bitmaps multiple times
         *
         * Resource: https://stackoverflow.com/questions/5088360/android-surfaceview-width-height-problem/9711285
         * Solution: I followed the flow of the example code
         */
        //goes through each board and draws the proper bitmap in the correct spot
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                Bitmap bitmapToDraw;
                Log.i("msg", "" + board[row][col]);
                bitmapToDraw = assignProperBitmap(row, col);

                canvas.drawBitmap(bitmapToDraw, (col * boardHeight) / 4 + (boardWidth - boardHeight) / 2, (row * boardHeight) / 4, null);
            }
        }

        //draws the reset button
        canvas.drawBitmap(scaledResetGraphic, boardHeight + (boardWidth - boardHeight) / 2, 0, null);
    }

    /**
     * External Citation
     * Date: 9 November 2019
     * Problem: did not know how to add drag and drop functionality
     *
     * Resource: https://www.vogella.com/tutorials/AndroidDragAndDrop/article.html
     * Solution: I used the sample code found in this online resource
     */
    /**
     * handles drag actions received by the drag listener
     *
     * @param v view the drag is in
     * @param event contains the current location of the tap
     * @return true when drag event is handled correctly
     *         false when the drag event has not been handled yet
     */
    @Override
    public boolean onDrag (View v, DragEvent event) {
        //finds the place that contains the empty block
        int indexOfSixteen=-1;
        for(int x=0; x<16; x++) {
            if(board[x/4][x%4] == 16) {
                indexOfSixteen = x;
            }
        }

        //gets the type of drag the user inputs
        int action = event.getAction();
        //the user has just started a drag
        if(action == DragEvent.ACTION_DRAG_STARTED) {
            //stores the row and col of the action
            storedRow = (int) (event.getY() * 4 / boardHeight);
            storedCol = (int) ((event.getX() - (boardWidth - boardHeight)/2) * 4 / boardHeight);
            /*if the tapped block is not one off of the blank square return that
            the action has been handle */
            if ((storedRow * 4 + storedCol) != indexOfSixteen + 1
                    || (storedRow * 4 + storedCol) != indexOfSixteen - 1
                    || (storedRow * 4 + storedCol) != indexOfSixteen + 4
                    || (storedRow * 4 + storedCol) != indexOfSixteen - 4) {
                return true;
            }
        }
        //the user stops a drag
        else if (action == DragEvent.ACTION_DROP) {
            //reads the position of the drop
            int row2 = (int) (event.getY() * 4 / boardHeight);
            int col2 = (int) ((event.getX() - (boardWidth - boardHeight)/2) * 4 / boardHeight);
            //makes sure the drag started in a legal position
            if(storedRow > 3 || storedRow < 0 || storedCol < 0 || storedCol > 3) {
                return true;
            }
            //if the user drops on the empty square register a tap
            if((row2 * 4) + col2 == indexOfSixteen) {
                tapSquare(storedRow, storedCol);
            }
            //otherwises return that the drag and drop has been handled
            else {
                return true;
            }
        }
        return true;
    }

    /**
     * tells the surface view what to do if it is touched
     *
     * @param v view that was touched
     * @param me contains information about the touch
     * @return true when touch is handled correctly
     *         false when the touch has not finished being handled
     */
    @Override
    public boolean onTouch(View v, MotionEvent me) {

        //tells the board to reset the board when the reset button is touched
        if(me.getX() > boardHeight + (boardWidth-boardHeight)/2) {
            isGameOver=false;
            this.randomizeBoard();
            this.invalidate();
            return true;
        }

        //tells the game what to happen when a drag has been started
        if(me.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            DragShadowBuilder shadowBuilder = new View.DragShadowBuilder();
            v.startDrag(data, shadowBuilder, v, 0);
            return true;
        }

        return true;
    }

    /**
     * tells the surfaceView what to do when a square is tapped
     *
     * @param row row of the tap
     * @param col col of the tap
     */
    public void tapSquare(int row, int col) {
        //does not do anything if the game is over
        if(isGameOver == true) {
            return;
        }

        //stores index of the tap
        int index = row * 4 + col;

        //moves the tapped square up if possible
        if(index-4 >= 0 && board[row-1][col] == 16) {
            int temp = board[row][col];
            board[row][col] = board[row-1][col];
            board[row-1][col] = temp;
        }
        //moves the tapped square left if possible
        else if ((index + 1) % 4 != 1 && board[row][col-1] == 16){
            int temp = board[row][col];
            board[row][col] = board[row][col-1];
            board[row][col-1] = temp;
        }
        //moves the tapped square right if possible
        else if ((index + 1) % 4 != 0 && board[row][col+1] == 16){
            int temp = board[row][col];
            board[row][col]=board[row][col+1];
            board[row][col+1]=temp;
        }
        //moves the tapped square down if possible
        else if ((index + 4) < 16 && board[row+1][col] == 16){
            int temp = board[row][col];
            board[row][col]=board[row+1][col];
            board[row+1][col]=temp;
        }
        //reevaluates if the games over and updates the screen
        checkIfGameOver();
        this.invalidate();
    }

    /**
     * checks if the game is over
     */
    public void checkIfGameOver() {
        //goes through each block and makes sure it contains the right number
        for(int x = 1; x<17; x++) {
            //if number is incorrect exit method
            if(board[(x-1)/4][(x-1)%4] != x) {
                break;
            }
            //if all 16 blocks contain the correct number, assert that the game is over
            if(x == 16) {
                isGameOver = true;
            }
        }

    }
}
