package com.example.flappybird;

import java.util.Random;

public class Tube {

    private int tubeX, tubeY;
    private Random random;
    private int tubeColor;

    public Tube(int tubeX, int tubeY) {
        this.tubeX = tubeX;
        this.tubeY = tubeY;
        random = new Random();
    }

    public int getTubeX() {
        return tubeX;
    }

    public void setTubeX(int tubeX) {
        this.tubeX = tubeX;
    }

    public int getTubeY() {
        return tubeY;
    }

    public void setTubeY(int tubeY) {
        this.tubeY = tubeY;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getTopTubeY(){
        return tubeY - AppConstants.getBitmapBank().getTubeHeight();
    }

    public int getBottomTubeY(){
        return tubeY + AppConstants.gapBetweenTubes;
    }

    public void setTubeColor() {
        this.tubeColor = random.nextInt(2);
    }

    public int getTubeColor() {
        return tubeColor;
    }
}
