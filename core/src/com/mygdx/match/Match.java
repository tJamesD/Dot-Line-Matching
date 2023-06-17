package com.mygdx.match;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.Graphics;

public class Match extends ApplicationAdapter {
	SpriteBatch batch;
	Texture noTouch;
	Texture touch;
	ShapeRenderer shape;

	OrthographicCamera camera;

	Circle dot1;
	Circle dot2;
	Circle dot3;
	Circle dot4;
	Circle dot5;
	Circle dot6;
	Circle dot7;
	Circle dot8;
	Circle dot9;



	Circle[][] dotMatrix;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		noTouch = new Texture("noTouch.png");
		touch = new Texture("touch.png");
		shape = new ShapeRenderer();
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 350, 600);
		camera.update();

		dotMatrix = new Circle[3][3];

		dot1 = new Circle(80,160,25);
		dot2 = new Circle(190,170,25);
		dot3 = new Circle(310,180,25);

		dot4 = new Circle(80,310,25);
		dot5 = new Circle(190,320,25);
		dot6 = new Circle(310,330,25);

		dot7 = new Circle(80,460,25);
		dot8 = new Circle(190,470,25);
		dot9 = new Circle(310,486,25);

		dotMatrix[0][0] = dot1;
		dotMatrix[0][1] = dot2;
		dotMatrix[0][2] = dot3;
		dotMatrix[1][0] = dot4;
		dotMatrix[1][1] = dot5;
		dotMatrix[1][2] = dot6;
		dotMatrix[2][0] = dot7;
		dotMatrix[2][1] = dot8;
		dotMatrix[2][2] = dot9;
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		batch.draw(noTouch, 50, 150);
		batch.draw(noTouch, 150, 150);
		batch.draw(noTouch, 250, 150);

		batch.draw(noTouch, 50, 300);
		batch.draw(noTouch, 150, 300);
		batch.draw(noTouch, 250, 300);

		batch.draw(noTouch, 50, 450);
		batch.draw(noTouch, 150, 450);
		batch.draw(noTouch, 250, 450);

		//batch.draw(noTouch, 0, 0);
		//batch.draw(noTouch, 0, 0);
		//batch.draw(noTouch, 0, 0);
		//batch.draw(noTouch, 0, 0);
		//batch.draw(noTouch, 0, 0);
		//batch.draw(noTouch, 0, 0);
		//batch.draw(noTouch, 0, 0);

		//batch.draw(touch, 100, 100);
		batch.end();

		showPattern();

		if(Gdx.input.isTouched()) {
			Circle mHB = new Circle(Gdx.input.getX(), Gdx.input.getY(), 10);
			if(mHB.overlaps(dot1)) {
				batch.begin();
				batch.draw(touch,50,150);
				batch.end();
			}
			if(mHB.overlaps(dot2)) {
				batch.begin();
				batch.draw(touch,150,150);
				batch.end();
			}
			if(mHB.overlaps(dot3)) {
				batch.begin();
				batch.draw(touch,250,150);
				batch.end();
			}
			if(mHB.overlaps(dot4)) {
				batch.begin();
				batch.draw(touch,50,300);
				batch.end();
			}
			if(mHB.overlaps(dot5)) {
				batch.begin();
				batch.draw(touch,150,300);
				batch.end();
			}
			if(mHB.overlaps(dot6)) {
				batch.begin();
				batch.draw(touch,250,300);
				batch.end();
			}
			if(mHB.overlaps(dot7)) {
				batch.begin();
				batch.draw(touch,50,450);
				batch.end();
			}
			if(mHB.overlaps(dot8)) {
				batch.begin();
				batch.draw(touch,150,450);
				batch.end();
			}
			if(mHB.overlaps(dot9)) {
				batch.begin();
				batch.draw(touch,250,450);
				batch.end();
			}
		}
	}

	public void showPattern() {
		int[] pattern = {1,1,1,1,1,1,1,1,1,1};
		for(int i = 1; i< pattern.length; i++) {
			if(pattern[i] == 1 ) {
				batch.begin();
				batch.draw(touch,50,150);
				batch.draw(noTouch,50,150);
				//batch.draw(touch,50,150);
				//batch.draw(noTouch,50,150);
				//batch.draw(touch,50,150);
				//batch.draw(noTouch,50,150);
				//batch.draw(touch,50,150);
				//batch.draw(noTouch,50,150);
				//batch.draw(touch,50,150);
				//batch.draw(noTouch,50,150);

				batch.end();
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		touch.dispose();
		noTouch.dispose();
	}
}
