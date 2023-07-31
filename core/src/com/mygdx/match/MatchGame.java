package com.mygdx.match;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MatchGame extends Game {
    public void create() {
        //this.setScreen(new MatchScreen(this));
        this.setScreen(new PatternScreen(this,0));
    }

    public void render() {
        super.render(); //important!
    }

    public void dispose() {
    }
}
