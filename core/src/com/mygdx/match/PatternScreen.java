package com.mygdx.match;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;
import java.util.Timer;

public class PatternScreen implements Screen {

    BitmapFont font;
    MatchGame game;
    SpriteBatch sb;
    Texture touch;

    Texture noTouch;
    OrthographicCamera cam;
    DotMatrix dM;

    Viewport viewport;

    int correctCount;


    public PatternScreen( MatchGame game, int cc) {
        this.game = game;
        //super(game);
        sb = new SpriteBatch();
        touch = new Texture("touch.png");
        noTouch = new Texture("noTouch.png");
        cam = new OrthographicCamera();
        cam.setToOrtho(false,350, 350);
        //cam.setToOrtho(true,350, 350);
        viewport = new FitViewport(350,350, cam);
        cam.update();

        dM = new DotMatrix();
        correctCount = cc;
        font = new BitmapFont();
        //ScreenUtils.clear(0, 0, 0, 0);
    }

    @Override
    public void render(float delta) {
        //ScreenUtils.clear(0, 0, 0, 0);
        cam.update();
        sb.setProjectionMatrix(cam.combined);
        viewport.apply();
        //sb.setProjectionMatrix(cam.combined);

        sb.begin();
        //font.dispose();
        font.draw(sb, "COUNT: " + correctCount, 10, 20);
        //font.dispose();
        sb.end();

        //font.dispose();
        if(!dM.isPatComplete()) {
            dM.draw();
            dM.showPattern(delta);
            //System.out.println("Not COMPLETE");
            //System.out.println("COMPLETE not");


            //cam.update();

        } else {
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++++++");
            //ScreenUtils.clear(0,0,0,0);
            //font.dispose();
            //sb.dispose();
            game.setScreen(new MatchScreen(game, dM.getPattern(), dM));
        }
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
        //viewport.update(Gdx.graphics.getWidth(),Gdx.graphics.getWidth());
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
