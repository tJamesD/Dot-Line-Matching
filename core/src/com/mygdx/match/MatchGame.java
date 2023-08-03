package com.mygdx.match;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MatchGame extends Game {

    public SpriteBatch batch;

    public BitmapFont font;

    int correctCount;
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        correctCount = 0;
        //this.setScreen(new MatchScreen(this));
        this.setScreen(new PatternScreen(this,0));
    }

    public void render() {
        super.render(); //important!
//        batch.begin();
//        font.draw(batch, "COUNT: " + correctCount, 10, 20);
//        batch.end();
    }

    public void dispose() {
    }

    public void updateCorrectCount() {
        correctCount++;
    }

    public int getCorrectCount() {
        return correctCount;
    }
}
