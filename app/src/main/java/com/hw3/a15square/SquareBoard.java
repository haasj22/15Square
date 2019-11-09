package com.hw3.a15square;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

public class SquareBoard extends SurfaceView implements View.OnTouchListener{

    Paint timerPaint;

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
    /*Bitmap timerOneGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.timer1);
    Bitmap timerTwoGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.timer2);
    Bitmap timerThreeGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.timer3);
    Bitmap timerFourGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.timer4);
    Bitmap timerFiveGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.timer5);
    Bitmap timerSixGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.timer6);
    Bitmap timerSevenGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.timer7);
    Bitmap timerEightGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.timer8);
    Bitmap timerNineGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.timer9);
    Bitmap timerTenGraphic = BitmapFactory.decodeResource(getResources(), R.drawable.timer10);*/
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
    /*Bitmap scaledTimerOneGraphic;
    Bitmap scaledTimerTwoGraphic;
    Bitmap scaledTimerThreeGraphic;
    Bitmap scaledTimerFourGraphic;
    Bitmap scaledTimerFiveGraphic;
    Bitmap scaledTimerSixGraphic;
    Bitmap scaledTimerSevenGraphic;
    Bitmap scaledTimerEightGraphic;
    Bitmap scaledTimerNineGraphic;
    Bitmap scaledTimerTenGraphic;*/

    //instance variables
    private int[][] board = new int[4][4];
    private int boardHeight;
    private int boardWidth;
    private boolean oneTime = false;
    private boolean oneTimeRandomize = false;
    private boolean isGameOver=false;

    private long timeLeft;

    CountDownTimer turnOverTimer;

    public SquareBoard(Context context, AttributeSet attr) {
        super(context, attr);
        setWillNotDraw(false);

        timerPaint = new Paint(Color.BLUE);
        if(!oneTimeRandomize) {
            oneTimeRandomize=true;
            randomizeBoard();
        }
        timeLeft = 10000;
    }

    public void randomizeBoard() {
        resetBoard();

        for(int num=1; num<=16; num++) {
            int row= (int)(Math.random() * 4);
            int col= (int)(Math.random() * 4);

            if(containsPiece(row, col)) {
                num--;
                continue;
            } else {
                board[row][col] = num;
            }
        }


        if(!(this.containsLegalBoard())) {
            randomizeBoard();
        }
    }

    public void resetBoard() {
        for(int row=0; row<4; row++) {
            for(int col=0; col<4; col++) {
                board[row][col] = -1;
            }
        }
    }

    public boolean containsPiece(int row, int col) {
        return board[row][col] != -1;
    }

    public boolean containsLegalBoard() {
        int rowOf16=-1;
        int numInversionCounts=0;
        for(int boardIndex=0; boardIndex<16; boardIndex++) {
            if(board[boardIndex / 4][boardIndex % 4] == 16) {
                rowOf16=boardIndex/4 + 1;
            }
            for(int nextNumbers=boardIndex + 1; nextNumbers<16; nextNumbers++) {
                if(board[boardIndex / 4][boardIndex % 4] > board[nextNumbers / 4][nextNumbers % 4]) {
                    numInversionCounts++;
                }
            }
        }
        numInversionCounts+=rowOf16;

        if(numInversionCounts % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

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
        if(!oneTime) {
            oneTime = true;
            boardHeight=canvas.getHeight();
            boardWidth=canvas.getWidth();

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
            /*scaledTimerOneGraphic =
                    Bitmap.createScaledBitmap(timerOneGraphic, boardHeight/6, boardHeight/6, false);
            scaledTimerTwoGraphic =
                    Bitmap.createScaledBitmap(timerTwoGraphic, boardHeight/6, boardHeight/6, false);
            scaledTimerThreeGraphic =
                    Bitmap.createScaledBitmap(timerThreeGraphic, boardHeight/6, boardHeight/6, false);
            scaledTimerFourGraphic =
                    Bitmap.createScaledBitmap(timerFourGraphic, boardHeight/6, boardHeight/6, false);
            scaledTimerFiveGraphic =
                    Bitmap.createScaledBitmap(timerFiveGraphic, boardHeight/6, boardHeight/6, false);
            scaledTimerSixGraphic =
                    Bitmap.createScaledBitmap(timerSixGraphic, boardHeight/6, boardHeight/6, false);
            scaledTimerSevenGraphic =
                    Bitmap.createScaledBitmap(timerSevenGraphic, boardHeight/6, boardHeight/6, false);
            scaledTimerEightGraphic =
                    Bitmap.createScaledBitmap(timerEightGraphic, boardHeight/6, boardHeight/6, false);
            scaledTimerNineGraphic =
                    Bitmap.createScaledBitmap(timerNineGraphic, boardHeight/6, boardHeight/6, false);
            scaledTimerTenGraphic =
                    Bitmap.createScaledBitmap(timerTenGraphic, boardHeight/6, boardHeight/6, false);*/
        }

            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    Bitmap bitmapToDraw;
                    Log.i("msg", "" + board[row][col]);
                    switch (board[row][col]) {
                        case 1:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledOneGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteOneGraphic;
                            }
                            break;
                        case 2:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledTwoGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteTwoGraphic;
                            }
                            break;
                        case 3:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledThreeGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteThreeGraphic;
                            }
                            break;
                        case 4:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledFourGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteFourGraphic;
                            }
                            break;
                        case 5:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledFiveGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteFiveGraphic;
                            }
                            break;
                        case 6:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledSixGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteSixGraphic;
                            }
                            break;
                        case 7:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledSevenGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteSevenGraphic;
                            }
                            break;
                        case 8:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledEightGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteEightGraphic;
                            }
                            break;
                        case 9:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledNineGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteNineGraphic;
                            }
                            break;
                        case 10:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledTenGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteTenGraphic;
                            }
                            break;
                        case 11:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledElevenGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteElevenGraphic;
                            }
                            break;
                        case 12:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledTwelveGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteTwelveGraphic;
                            }
                            break;
                        case 13:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledThirteenGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteThirteenGraphic;
                            }
                            break;
                        case 14:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledFourteenGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteFourteenGraphic;
                            }
                            break;
                        case 15:
                            if (isGameOver == false) {
                                bitmapToDraw = scaledFifteenGraphic;
                            } else {
                                bitmapToDraw = scaledCompleteFifteenGraphic;
                            }
                            break;
                        default:
                            bitmapToDraw = scaledBlankGraphic;
                    }
                    canvas.drawBitmap(bitmapToDraw, (col * boardHeight) / 4 + (boardWidth - boardHeight) / 2, (row * boardHeight) / 4, null);
                }
            }

            /**
            Bitmap timerBitmapToDraw;
            switch ((int) timeLeft / 1000) {
                case 0:
                    timerBitmapToDraw = scaledBlankGraphic;
                    break;
                case 1:
                    timerBitmapToDraw = scaledTimerOneGraphic;
                    break;
                case 2:
                    timerBitmapToDraw = scaledTimerTwoGraphic;
                    break;
                case 3:
                    timerBitmapToDraw = scaledTimerThreeGraphic;
                    break;
                case 4:
                    timerBitmapToDraw = scaledTimerFourGraphic;
                    break;
                case 5:
                    timerBitmapToDraw = scaledTimerFiveGraphic;
                    break;
                case 6:
                    timerBitmapToDraw = scaledTimerSixGraphic;
                    break;
                case 7:
                    timerBitmapToDraw = scaledTimerSevenGraphic;
                    break;
                case 8:
                    timerBitmapToDraw = scaledTimerEightGraphic;
                    break;
                case 9:
                    timerBitmapToDraw = scaledTimerNineGraphic;
                    break;
                case 10:
                    timerBitmapToDraw = scaledTimerTenGraphic;
                    break;

                default:
                    timerBitmapToDraw = scaledBlankGraphic;
                    break;

            }*/

            //canvas.drawBitmap(timerBitmapToDraw, 0, 0, null);
        canvas.drawBitmap(scaledResetGraphic, boardHeight + (boardWidth - boardHeight) / 2, 0, null);
        //startTimer();
    }

    @Override
    public boolean onTouch(View v, MotionEvent me) {

        int xTap = (int)me.getX();
        if(xTap >= boardHeight + (boardWidth-boardHeight)/2) {
            isGameOver=false;
            this.randomizeBoard();
            this.invalidate();
            return true;
        }

        if(isGameOver == true) {
            return true;
        }

        int yTap = (int)me.getY();

        if(xTap <= (boardWidth-boardHeight)/2) {
            return true;
        }

        int rowTap = yTap * 4 / boardHeight;
        int colTap = (xTap - (boardWidth - boardHeight)/2) * 4 /boardHeight;

        tapSquare(rowTap, colTap);
        return true;
    }

    public void tapSquare(int row, int col) {
        if(isGameOver == true) {
            return;
        }

        int index = row * 4 + col;
        if(index-4 >= 0 && board[row-1][col] == 16) {
            int temp = board[row][col];
            board[row][col] = board[row-1][col];
            board[row-1][col] = temp;
        } else if ((index + 1) % 4 != 1 && board[row][col-1] == 16){
            int temp = board[row][col];
            board[row][col] = board[row][col-1];
            board[row][col-1] = temp;
        } else if ((index + 1) % 4 != 0 && board[row][col+1] == 16){
            int temp = board[row][col];
            board[row][col]=board[row][col+1];
            board[row][col+1]=temp;
        } else if ((index + 4) < 16 && board[row+1][col] == 16){
            int temp = board[row][col];
            board[row][col]=board[row+1][col];
            board[row+1][col]=temp;
        }
        checkIfGameOver();
        this.invalidate();
        /*
        synchronized (this) {
            timeLeft = 10000;
        }*/
    }

    public void checkIfGameOver() {
        for(int x = 1; x<17; x++) {
            if(board[(x-1)/4][(x-1)%4] != x) {
                break;
            }
            Log.i("msg", "" + x);
            if(x == 16) {
                isGameOver = true;
            }
        }

    }

    /*public void startTimer() {
        turnOverTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                Log.i("msg", "tick" + l);
                timeLeft = l;
            }

            @Override
            public void onFinish() {
                Log.i("msg", "turn Taken");
                takeRandomTurn();
            }

        }.start();
    }*/

    /*public void takeRandomTurn() {
        int sixteenIndex = -1;
        int row = -1;
        int col =-1;

        for(int x = 0; x<15; x++) {
            if(board[x/4][x%4] == 16) {
                sixteenIndex = x;
            }
        }

        row = (int)(Math.random() * 3) - 1;
        col = (int)(Math.random() * 3) - 1;
        if(row == col) {
            takeRandomTurn();
        } else if(row == 1 && sixteenIndex > 11) {
            takeRandomTurn();
        } else if(row == -1 && sixteenIndex < 4) {
            takeRandomTurn();
        } else if(col == 1 && sixteenIndex % 4 == 3) {
            takeRandomTurn();
        } else if(col == -1 && sixteenIndex % 4 == 0) {
            takeRandomTurn();
        }

        Log.i("msg", "" + row);
        Log.i("msg", "" + col);
        if(row == 1 && col == 0) {
            Log.i("msg", "down");
        } else if(row == -1 && col == 0) {
            Log.i("msg", "up");
        } else if (row == 0 && col == 1) {
            Log.i("msg", "right");
        } else if (row == 0 && col == -1) {
            Log.i("msg", "left");
        }

        Log.i("msg", "moved");
        tapSquare((sixteenIndex + 4*row)/4, (sixteenIndex+col)%4 );



    }*/

}
