package com.mygdx.match;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MatchGame extends Game {

    public SpriteBatch batch;

    public BitmapFont font;

    public PatternScreen pS;

    public MatchScreen mS;

    public DotMatrix dM;

    int correctCount;
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        correctCount = 0;
        dM = new DotMatrix();
        pS = new PatternScreen(this, 0);
        mS = new MatchScreen(this, pS.dM.getPattern(), pS.getDM());
        //this.setScreen(new MatchScreen(this));
        //this.setScreen(new PatternScreen(this,0));
        this.setScreen(pS);
    }

    public void render() {
        super.render(); //important!
//        batch.begin();
//        font.draw(batch, "COUNT: " + correctCount, 10, 20);
//        batch.end();
    }

    public void dispose() {
    }

    public void updatePS() {
        pS = new PatternScreen(this, correctCount);
    }

    public void updateMS() {
        mS = new MatchScreen(this,pS.dM.getPattern(), pS.getDM());
    }

    public void updateCorrectCount() {
        correctCount++;
    }

    public int getCorrectCount() {
        return correctCount;
    }
}
