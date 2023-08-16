package com.mygdx.match;

import com.badlogic.gdx.utils.IntArray;

import java.util.Random;

public class PatternSearch {
    Cell[][] grid;
    IntArray pattern;

    int currPatLength;
    int currGenLimit;

    Random rand;

    public IntArray getPattern() {
        return pattern;
    }

    public IntArray getPatternOneAdded() {
        pattern.add(-1);
        return pattern;
    }

    public PatternSearch() {
        grid = new Cell[3][3];
        grid[0][0] = new Cell(1);
        grid[0][1] = new Cell(2);
        grid[0][2] = new Cell(3);
        grid[1][0] = new Cell(4);
        grid[1][1] = new Cell(5);
        grid[1][2] = new Cell(6);
        grid[2][0] = new Cell(7);
        grid[2][1] = new Cell(8);
        grid[2][2] = new Cell(9);
        pattern = new IntArray();
        currGenLimit = 3;
        currPatLength = 0;
        rand = new Random();
        genPattern();
    }

    public int getStartRow() {
        return rand.nextInt(3);
    }
    public int getStartCol() {
        return rand.nextInt(3);
    }

    public Cell getStartCell() {
        int cellId = rand.nextInt(9) + 1;
        return returnCellFromID(cellId);
    }

    public void genPattern() {
        //int startR = getStartRow();
        //int startC = getStartCol();
        //int nextR = startR;
        //int nextC = startC;
        //int startCell;
        int nextCell;
        Cell startCell = getStartCell();
        Cell holdCell;
        //pattern.add(grid[startR][startC].getiD());
        pattern.add(startCell.getiD());
        currPatLength++;
        //grid[startR][startC].setChosen();
        startCell.setChosen();

        while(currPatLength < currGenLimit && checkSurroundingNeighbors(startCell) ) {
            //IntArray tempNeighbors = grid[nextR][nextC].getNeighbors();
            //System.out.println("STARTCELLIDSTARTLOOP: " + startCell.getiD());
            IntArray tempNeighbors = startCell.getNeighbors();
            int randIndex = rand.nextInt(tempNeighbors.size);
            int tempId = tempNeighbors.get(randIndex);

            while(checkValidNeighbor(tempId) ) {
                //System.out.println("IN WHILE LOOP - TEMPID: " + tempId);
                //returnCellFromID(tempId).removeNeighbor(tempId);
                returnCellFromID(startCell.getiD()).removeNeighbor(tempId);
                tempNeighbors= startCell.getNeighbors();
                //IFFY at best - probs not good.
                if(tempNeighbors.isEmpty()) {
                    break;
                }
                randIndex = rand.nextInt(tempNeighbors.size);
                tempId = tempNeighbors.get(randIndex);
            }
            //iffy 2 - no good
            if(!pattern.contains(tempId)) {
                pattern.add(tempId);
                System.out.println("HERE: " + pattern.toString());
                currPatLength++;
            }
            //returnCellFromID(tempId).removeNeighbor(tempId);
            returnCellFromID(startCell.getiD()).removeNeighbor(tempId);
            startCell.setChosen();
            startCell = returnCellFromID(tempId);
            //System.out.println("STARTCELLIDENDLOOP: " + startCell.getiD());


        }

        if(currPatLength<currGenLimit) {
            patternReset();
            genPattern();
            System.out.println("PATTERNSEARCHIF: " + pattern.toString());

        }

        System.out.println("PATTERNSEARCH: " + pattern.toString());

    }

    public void patternReset() {
        for(int r = 0; r< grid.length;r++) {
            for(int c = 0; c<grid[0].length;c++) {
                grid[r][c].resetNeighbors();
                grid[r][c].resetChosen();
            }
        }

        pattern = new IntArray();
        currPatLength = 0;
    }
    public boolean checkValidNeighbor(int iD) {
        //System.out.println("PASSED ID: " + iD);
        //System.out.println("NEIGHBORSCVN: " + returnCellFromID(iD).getNeighbors().toString());
        //System.out.println(pattern.toString());
        if(iD == 1) {
            return grid[0][0].isChosen();
        }
        if(iD == 2) {
            return grid[0][1].isChosen();
        }
        if(iD == 3) {
            return grid[0][2].isChosen();
        }
        if(iD == 4) {
            return grid[1][0].isChosen();
        }
        if(iD == 5) {
            return grid[1][1].isChosen();
        }
        if(iD == 6) {
            return grid[1][2].isChosen();
        }
        if(iD == 7) {
            return grid[2][0].isChosen();
        }
        if(iD == 8) {
            return grid[2][1].isChosen();
        }
        if(iD == 9) {
            return grid[2][2].isChosen();
        }
        return true;
    }

    public boolean checkSurroundingNeighbors(Cell holdCell) {
        IntArray tempArray = holdCell.getNeighbors();
       // System.out.println("NEIGHBORSCSN: " + tempArray.toString());

        for(int i = 0; i<tempArray.size; i++) {
            if(checkValidNeighbor(tempArray.get(i)) == false) {
                return true;
            }
        }
        return false;
    }

    public boolean checkforAddCell(Cell holdCell) {
        //if(!checkSurroundingNeighbors(holdCell) && )
        return false;
    }

    public Cell returnCellFromID(int iD) {
        Cell errorCell = new Cell(-1);
        if(iD == 1) {
            return grid[0][0];
        }
        if(iD == 2) {
            return grid[0][1];
        }
        if(iD == 3) {
            return grid[0][2];
        }
        if(iD == 4) {
            return grid[1][0];
        }
        if(iD == 5) {
            return grid[1][1];
        }
        if(iD == 6) {
            return grid[1][2];
        }
        if(iD == 7) {
            return grid[2][0];
        }
        if(iD == 8) {
            return grid[2][1];
        }
        if(iD == 9) {
            return grid[2][2];
        }
        return errorCell;
    }

    public int getCurrGenLimit() {
        return currGenLimit;
    }

    public void increaseCurrGenLimit() {
        currGenLimit++;
    }

}
