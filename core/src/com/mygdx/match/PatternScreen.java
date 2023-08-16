package com.mygdx.match;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
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

    SpriteBatch textBatch;
    Texture touch;

    Texture noTouch;
    OrthographicCamera cam;
    DotMatrix dM;

    Viewport viewport;

    int correctCount;

    boolean firstRun;


    public PatternScreen( MatchGame game, int cc, DotMatrix dM) {
        this.game = game;
        //super(game);
        sb = new SpriteBatch();
        textBatch = new SpriteBatch();
        touch = new Texture("touch.png");
        noTouch = new Texture("noTouch.png");
        //this.cam = game.cam;
        cam = new OrthographicCamera();
        cam.setToOrtho(false,350, 350);
        //cam.setToOrtho(true,350, 350);
        viewport = new FitViewport(350,350, cam);
        cam.update();

        firstRun = true;

        //dM = new DotMatrix();
        this.dM = dM;
        correctCount = cc;
        font = new BitmapFont();
        //ScreenUtils.clear(0, 0, 0, 0);
    }

    @Override
    public void render(float delta) {
        //ScreenUtils.clear(0, 0, 0, 0);
        //System.out.println("PSRENDERPS");
        cam.update();
        sb.setProjectionMatrix(cam.combined);
        viewport.apply();
        //sb.setProjectionMatrix(cam.combined);

        //textBatch.begin();
        //font.dispose();
        //font.draw(textBatch, "COUNT: " + correctCount, 10, 20);

        //textBatch.end();
        //textBatch.dispose();

        //font.dispose();
//        game.batch.begin();
//        game.font.draw(game.batch,"COUNT: " + game.getCorrectCount(), 10,20);
//        game.batch.end();

        //System.out.println("PATCOMPLETE: " + dM.patComplete);
        if(!dM.isPatComplete()) {
            //System.out.println("PATCOMPLETEIF: " + dM.patComplete);
            dM.draw();
            dM.showPattern(delta);
//            System.out.println("Not COMPLETE");
//            System.out.println("COMPLETE not");
//            System.out.println("Not COMPLETE");
//            System.out.println("COMPLETE not");


            //cam.update();

        } else {
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++++++");
            ScreenUtils.clear(0,0,0,0);
            Gdx.gl.glClearColor(0,0,0,0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            font.dispose();
            //textBatch.dispose();
            //stage.clear();
            //sb.dispose();
            //game.batch.dispose();
            //game.setScreen(new MatchScreen(game, dM.getPattern(), dM));
            dM.resetPatcomplete();
            firstRun = false;
            game.updateMS();
            dM.resetArrows();
            game.setScreen(game.mS);
        }
    }

    public DotMatrix getDM() {
        return dM;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
        //viewport.update(Gdx.graphics.getWidth(),Gdx.graphics.getWidth());
    }

    @Override
    public void show() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ScreenUtils.clear(0,0,0,0);
        System.out.println("PSSHOW");
        //dM.resetPatcomplete();
        //dM.genNewPattern();
        //System.out.println("PATCOMPLETE:  " + dM.patComplete);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        dM.unCode();
        if(!firstRun) {
            dM.unCode();
            dM.resetDeltaTime();
            dM.genNewPattern();
            System.out.println("GENPATTERNDONE");
            dM.printIsTouchIsPattern();

        }

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
