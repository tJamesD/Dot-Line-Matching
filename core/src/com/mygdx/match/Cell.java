package com.mygdx.match;

import com.badlogic.gdx.utils.IntArray;

public class Cell {

    int r;
    int c;
    int iD;
    boolean isChosen;

    IntArray neighbors;
    String arrName;

    int[] oneArr = new int[]{2,4,5};
    int[] twoArr = new int[]{1,3,4,5,6};
    int[] threeArr = new int[]{2,5,6};
    int[] fourArr = new int[]{1,2,5,7,8};
    int[] fiveArr = new int[]{1,2,3,4,6,7,8,9};
    int[] sixArr = new int[]{2,3,5,8,9};
    int[] sevenArr = new int[]{4,5,8};
    int[] eightArr = new int[]{4,5,6,7,9};
    int[] nineArr = new int[]{5,6,8};

    public Cell(int iD) {
        isChosen = false;
        this.iD = iD;

        if(iD == -1) {
            r=-1;
            c=-1;
            neighbors = new IntArray();
        }

        if(iD == 1) {
            r = 0;
            c = 0;
            neighbors = new IntArray(oneArr);
        }
        if(iD == 2) {
            r = 0;
            c = 1;
            neighbors = new IntArray(twoArr);
        }
        if(iD == 3) {
            r = 0;
            c = 2;
            neighbors = new IntArray(threeArr);
        }
        if(iD == 4) {
            r = 1;
            c = 0;
            neighbors = new IntArray(fourArr);
        }
        if(iD == 5) {
            r = 1;
            c = 1;
            neighbors = new IntArray(fiveArr);
        }
        if(iD == 6) {
            r = 1;
            c = 2;
            neighbors = new IntArray(sixArr);
        }
        if(iD == 7) {
            r = 2;
            c = 0;
            neighbors = new IntArray(sevenArr);
        }
        if(iD == 8) {
            r = 2;
            c = 1;
            neighbors = new IntArray(eightArr);
        }
        if(iD == 9) {
            r = 2;
            c = 2;
            neighbors = new IntArray(nineArr);
        }
    }


    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getiD() {
        return iD;
    }

    public boolean isChosen() {
        return isChosen;
    }

    public void removeNeighbor(int n){
        neighbors.removeValue(n);
    }

    public void resetNeighbors() {
        if(iD == 1) {
            neighbors = new IntArray(oneArr);
        }
        if(iD == 2) {
            neighbors = new IntArray(twoArr);
        }
        if(iD == 3) {
            neighbors = new IntArray(threeArr);
        }
        if(iD == 4) {
            neighbors = new IntArray(fourArr);
        }
        if(iD == 5) {
            neighbors = new IntArray(fiveArr);
        }
        if(iD == 6) {
            neighbors = new IntArray(sixArr);
        }
        if(iD == 7) {
            neighbors = new IntArray(sevenArr);
        }
        if(iD == 8) {
            neighbors = new IntArray(eightArr);
        }
        if(iD == 9) {
            neighbors = new IntArray(nineArr);
        }
    }

    public IntArray getNeighbors() {
        return neighbors;
    }

    public void setChosen() {
        isChosen = true;
    }

    public void resetChosen() {
        isChosen = false;
    }
}
