package com.mygdx.match;

import com.badlogic.gdx.utils.IntArray;

import java.util.Random;

public class PatternGenerator {

    int genLimit;
    int currPatLength;

    int dupeSeedCount;
    int dupeSeed;

    int[] oneArr;
    int[] twoArr;
    int[] threeArr;
    int[] fourArr;
    int[] fiveArr;
    int[] sixArr;
    int[] sevenArr;
    int[] eightArr;
    int[] nineArr;
    int[] availArr;

    IntArray oneList;
    IntArray twoList;
    IntArray threeList;
    IntArray fourList;
    IntArray fiveList;
    IntArray sixList;
    IntArray sevenList;
    IntArray eightList;
    IntArray nineList;
    IntArray availList;

    IntArray pattern;

    Random rand;




    public PatternGenerator() {

        genLimit = 8;
        currPatLength = 0;
        dupeSeedCount = 0;
        dupeSeed = 0;
        rand = new Random();

        oneArr = new int[]{2,4,5};
        twoArr = new int[]{1,3,4,5,6};
        threeArr = new int[]{2,5,6};
        fourArr = new int[]{1,2,5,7,8};
        fiveArr = new int[]{1,2,3,4,6,7,8,9};
        sixArr = new int[]{2,3,5,8,9};
        sevenArr = new int[]{4,5,8};
        eightArr = new int[]{4,5,6,7,9};
        nineArr = new int[]{5,6,8};
        availArr = new int[]{1,2,3,4,5,6,7,8,9};

        pattern = new IntArray();

        oneList = new IntArray(oneArr);
        twoList = new IntArray(twoArr);
        threeList = new IntArray(threeArr);
        fourList = new IntArray(fourArr);
        fiveList = new IntArray(fiveArr);
        sixList = new IntArray(sixArr);
        sevenList = new IntArray(sevenArr);
        eightList = new IntArray(eightArr);
        nineList = new IntArray(nineArr);
        availList = new IntArray(availArr);

        generatePattern();
        System.out.println(pattern.toString());

    }

    public void generatePattern() {

        int start = rand.nextInt(9) + 1;
        removeChosenValue(start);
        pattern.add(start);
        currPatLength++;

        int seed = start;



        System.out.println("SEED: " + seed);

        while(currPatLength < genLimit) {


            int nextInt = searchSeedArray(seed);
            dupeSeed = nextInt;
            while(!validSeedArray(nextInt) ) {
                nextInt = searchSeedArray(seed);
                dupeSeed = nextInt;

            }
            System.out.println("NEXTINT: " + nextInt);

            removeChosenValue(nextInt);
            pattern.add(nextInt);
            seed = nextInt;
            currPatLength++;
        }
    }

    public boolean dupeCheck(int nextInt) {
        return false;
    }



    public boolean validSeedArray(int seed) {
        if(seed == 1) {
            if(oneList.size == 0  && currPatLength+1 != genLimit && !availList.contains(seed) ) {
                return false;
            }
            return true;
        }
        if(seed == 2 ) {
            if(twoList.size == 0 && currPatLength+1 != genLimit  && !availList.contains(seed) ) {
                return false;
            }
            return true;
        }
        if(seed == 3 ) {
            if(threeList.size == 0 && currPatLength+1 != genLimit  && !availList.contains(seed) ) {
                return false;
            }
            return true;
        }
        if(seed == 4 ) {
            if(fourList.size == 0 && currPatLength+1 != genLimit  && !availList.contains(seed) ) {
                return false;
            }
            return true;
        }
        if(seed == 5 ) {
            if(fiveList.size == 0 && currPatLength+1 != genLimit  && !availList.contains(seed) ) {
                return false;
            }
            return true;
        }
        if(seed == 6 ) {
            if(sixList.size == 0 && currPatLength+1 != genLimit  && !availList.contains(seed) ) {
                return false;
            }
            return true;
        }
        if(seed == 7 ) {
            if(sevenList.size == 0 && currPatLength+1 != genLimit  && !availList.contains(seed) ) {
                return false;
            }
            return true;
        }
        if(seed == 8 ) {
            if(eightList.size == 0 && currPatLength+1 != genLimit  && !availList.contains(seed) ) {
                return false;
            }
            return true;
        }
        if(seed == 9 ) {
            if(nineList.size == 0 && currPatLength+1 != genLimit  && !availList.contains(seed) ) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int searchSeedArray(int seed) {
        int randIndex;
        int returnValue = -1;

        if(seed == 1 ) {
            randIndex = rand.nextInt(oneList.size);
             returnValue = oneList.get(randIndex);
            while(returnValue == -1) {
                randIndex = rand.nextInt(oneList.size);
                returnValue = oneList.get(randIndex);
            }
        }
        if(seed == 2 ) {
            randIndex = rand.nextInt(twoList.size);
             returnValue = twoList.get(randIndex);
            while(returnValue == -1) {
                randIndex = rand.nextInt(twoList.size);
                returnValue = twoList.get(randIndex);
            }
        }
        if(seed == 3 ) {
            randIndex = rand.nextInt(threeList.size);
             returnValue = threeList.get(randIndex);
            while(returnValue == -1) {
                randIndex = rand.nextInt(threeList.size);
                returnValue = threeList.get(randIndex);
            }
        }
        if(seed == 4 ) {
            randIndex = rand.nextInt(fourList.size);
             returnValue = fourList.get(randIndex);
            while(returnValue == -1) {
                randIndex = rand.nextInt(fourList.size);
                returnValue = fourList.get(randIndex);
            }
        }
        if(seed == 5 ) {
            randIndex = rand.nextInt(fiveList.size);
             returnValue = fiveList.get(randIndex);
            while(returnValue == -1) {
                randIndex = rand.nextInt(fiveList.size);
                returnValue = fiveList.get(randIndex);
            }
        }
        if(seed == 6 ) {
            randIndex = rand.nextInt(sixList.size);
             returnValue = sixList.get(randIndex);
            while(returnValue == -1) {
                randIndex = rand.nextInt(sixList.size);
                returnValue = sixList.get(randIndex);
            }
        }
        if(seed == 7 ) {
            randIndex = rand.nextInt(sevenList.size);
             returnValue = sevenList.get(randIndex);
            while(returnValue == -1) {
                randIndex = rand.nextInt(sevenList.size);
                returnValue = sevenList.get(randIndex);
            }
        }
        if(seed == 8 ) {
            randIndex = rand.nextInt(eightList.size);
             returnValue = eightList.get(randIndex);
            while(returnValue == -1) {
                randIndex = rand.nextInt(eightList.size);
                returnValue = eightList.get(randIndex);
            }
        }
        if(seed == 9 ) {
            randIndex = rand.nextInt(nineList.size);
             returnValue = nineList.get(randIndex);
            while(returnValue == -1) {
                randIndex = rand.nextInt(nineList.size);
                returnValue = nineList.get(randIndex);
            }
        }
        System.out.println("RETURN VALUE: " + returnValue);
        System.out.println("PATTERN: " + getPattern().toString());
        return returnValue;
    }

    public void removeChosenValue(int value) {
        int index = availList.indexOf(value);
        //availList.set(index, -1);
        availList.removeIndex(index);
        if(oneList.contains(value)) {
            index = oneList.indexOf(value);
            //oneList.set(index, -1);
            oneList.removeIndex(index);
            System.out.println("oneList " + oneList.toString());
        }
        if(twoList.contains(value)) {
            index = twoList.indexOf(value);
            //twoList.set(index, -1);
            twoList.removeIndex(index);
            System.out.println("twoList " + twoList.toString());
        }
        if(threeList.contains(value)) {
            index = threeList.indexOf(value);
            //threeList.set(index, -1);
            threeList.removeIndex(index);
            System.out.println("threeList " + threeList.toString());
        }
        if(fourList.contains(value)) {
            index = fourList.indexOf(value);
            //fourList.set(index, -1);
            fourList.removeIndex(index);
            System.out.println("fourList " + fourList.toString());
        }
        if(fiveList.contains(value)) {
            index = fiveList.indexOf(value);
            //fiveList.set(index, -1);
            fiveList.removeIndex(index);
            System.out.println("fiveList " + fiveList.toString());
        }
        if(sixList.contains(value)) {
            index = sixList.indexOf(value);
            //sixList.set(index, -1);
            sixList.removeIndex(index);
            System.out.println("sixList " + sixList.toString());
        }
        if(sevenList.contains(value)) {
            index = sevenList.indexOf(value);
            //sevenList.set(index, -1);
            sevenList.removeIndex(index);
            System.out.println("sevenList " + sevenList.toString());
        }
        if(eightList.contains(value)) {
            index = eightList.indexOf(value);
            //eightList.set(index, -1);
            eightList.removeIndex(index);
            System.out.println("eightList " + eightList.toString());
        }
        if(nineList.contains(value)) {
            index = nineList.indexOf(value);
            //nineList.set(index, -1);
            nineList.removeIndex(index);
            System.out.println("nineList " + nineList.toString());
        }
    }


    public IntArray getPattern() {
        //pattern.add(-1);
        return pattern;
    }
}
