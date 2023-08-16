package com.mygdx.match;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.IntArray;

import java.util.Random;

public class DotMatrix {

    Dot[][] dotMatrix;
    IntArray pattern;
    IntArray availableInts;

    PatternGenerator patGen;
    PatternSearch patSearch;

    SpriteBatch sb;
    BitmapFont font;
    int patCapacity;
    int currPatSize;
    int patLimit;
    int countOfCurrentPatSize;

    boolean patComplete;

    int curDrawIndex;

    float DT;
    float cDT;

    int CC;

    Random rand;

    public DotMatrix() {
        dotMatrix = new Dot[3][3];

        dotMatrix[0][0] = new Dot(50,250,1);
        dotMatrix[0][1] = new Dot(150,250,2);
        dotMatrix[0][2] = new Dot(250,250,3);

        dotMatrix[1][0] = new Dot(50,150,4);
        dotMatrix[1][1] = new Dot(150,150,5);
        dotMatrix[1][2] = new Dot(250,150,6);

        dotMatrix[2][0] = new Dot(50,50, 7);
        dotMatrix[2][1] = new Dot(150,50,8);
        dotMatrix[2][2] = new Dot(250,50,9);

        patComplete = false;
        currPatSize = 3;
        patCapacity = 10;
        availableInts = new IntArray();
        availableInts.add(1,2,3);
        availableInts.add(4,5,6);
        availableInts.add(7,8,9);
        rand = new Random();
        sb = new SpriteBatch();
        font = new BitmapFont();

        //patGen = new PatternGenerator();
        //pattern = patGen.getPattern();

        patSearch = new PatternSearch();

        pattern = patSearch.getPatternOneAdded();
        System.out.println("DM: " + pattern.toString());





//        dotMatrix[0][0] = new Dot(50,50, 1);
//        dotMatrix[0][1] = new Dot(150,50,2);
//        dotMatrix[0][2] = new Dot(250,50,3);
//
//        dotMatrix[1][0] = new Dot(50,150,4);
//        dotMatrix[1][1] = new Dot(150,150,5);
//        dotMatrix[1][2] = new Dot(250,150,6);
//
//        dotMatrix[2][0] = new Dot(50,250,7);
//        dotMatrix[2][1] = new Dot(150,250,8);
//        dotMatrix[2][2] = new Dot(250,250,9);

//        pattern = new IntArray(10);
//        pattern.insert(0, 2);
//        pattern.insert(1,5);
//        pattern.insert(2,9);
//        pattern.insert(3, 1);
//        pattern.insert(4,3);
//        pattern.insert(5,4);
//        pattern.insert(6, 6);
//        pattern.insert(7,7);
//        pattern.insert(8,8);
//        pattern.insert(9,-1);

        DT = Gdx.graphics.getDeltaTime();
        cDT = Gdx.graphics.getDeltaTime();
        curDrawIndex = 0;

        CC = 0;
        sendCurrentPattern();

    }

    public void draw() {
        for(int i = 0;i< dotMatrix.length ; i++) {
            for(int j=0; j<dotMatrix[0].length; j++) {
                dotMatrix[i][j].draw();
                sb.begin();
                font.draw(sb, "COUNT: " + CC, 10, 20);
                sb.end();
            }
        }

    }

    public void showPattern(float dt) {
        DT = dt;
        //System.out.println("CDT " + cDT);
        //System.out.println("IDT " + DT);
        //System.out.println();
        cDT = cDT + DT;
        //System.out.println();

        if(cDT > 1) {
            System.out.println("SP1");
            deCode(pattern.get(curDrawIndex));
            cDT = 0;
            curDrawIndex++;
        }

        if(curDrawIndex > currPatSize) {
            patComplete = true;
            System.out.println("SP2");
        }

        if(curDrawIndex >= pattern.size) {
            curDrawIndex = 0;
            System.out.println("SP3");
        }



    }

    public void deCode(int i) {
        if( i == 1 ) {
            dotMatrix[0][0].isPattern();
        }
        if( i == 2 ) {
            dotMatrix[0][1].isPattern();
        }
        if( i == 3 ) {
            dotMatrix[0][2].isPattern();
        }
        if( i == 4 ) {
            dotMatrix[1][0].isPattern();
        }
        if( i == 5 ) {
            dotMatrix[1][1].isPattern();
        }
        if( i == 6 ) {
            dotMatrix[1][2].isPattern();
        }
        if( i == 7 ) {
            dotMatrix[2][0].isPattern();
        }
        if( i == 8 ) {
            dotMatrix[2][1].isPattern();
        }
        if( i == 9 ) {
            dotMatrix[2][2].isPattern();
        }

    }

    public void unCode() {
        for(int r = 0; r<dotMatrix.length; r++) {
            for(int c = 0; c<dotMatrix[0].length; c++) {
                dotMatrix[r][c].reset();
                dotMatrix[r][c].resetTouchArrow();
            }
        }
    }


    public Dot getDot(int r, int c) {
        return dotMatrix[r][c];
    }

    public boolean isPatComplete() {
        return patComplete;
    }

    public void resetPatcomplete() {
        patComplete = false;
    }

    public IntArray getPattern() {
        return pattern;
    }

    public void genNewPattern() {
        unCode();
        patSearch.patternReset();
        patSearch.genPattern();
        patComplete = false;
        curDrawIndex = 0;
        pattern = patSearch.getPatternOneAdded();
        sendCurrentPattern();
        //updateCurrPatSize();
    }

    public void resetDeltaTime() {
        DT = Gdx.graphics.getDeltaTime();
        cDT = Gdx.graphics.getDeltaTime();
    }

    public void printIsTouchIsPattern() {
        for(int r = 0; r<dotMatrix.length; r++) {
            for (int c = 0; c < dotMatrix[0].length; c++) {
                System.out.println("R: " + r + "C: " + c + " " + dotMatrix[r][c].getIsTouched());
                System.out.println("R: " + r + "C: " + c + " " + dotMatrix[r][c].getIsPattern());
            }
        }
    }

    public void updateCC() {
        CC++;
    }

    public void updateCurrPatSize() {
        if(CC == 5 ) {
            currPatSize = 4;
            patSearch.increaseCurrGenLimit();
        }
        if(CC == 10 ) {
            currPatSize = 5;
            patSearch.increaseCurrGenLimit();
        }
        if(CC == 15 ) {
            currPatSize = 6;
            patSearch.increaseCurrGenLimit();
        }
        if(CC == 20 ) {
            currPatSize = 7;
            patSearch.increaseCurrGenLimit();
        }
        if(CC == 25 ) {
            currPatSize = 8;
            patSearch.increaseCurrGenLimit();
        }
        if(CC == 30 ) {
            currPatSize = 9;
            patSearch.increaseCurrGenLimit();
        }

    }

    public void sendCurrentPattern() {
        for(int r = 0; r<dotMatrix.length; r++) {
            for(int c = 0; c<dotMatrix[0].length;c++) {
                dotMatrix[r][c].setCurrentPattern(pattern);
            }
        }
    }

    public void resetArrows() {
        for(int r = 0; r<dotMatrix.length; r++) {
            for(int c = 0; c<dotMatrix[0].length;c++) {
                dotMatrix[r][c].resetTouchArrow();
                System.out.println("RESETTOUCHARROW");
            }
        }
    }
}
