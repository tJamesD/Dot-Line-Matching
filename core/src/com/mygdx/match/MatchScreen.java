package com.mygdx.match;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MatchScreen implements Screen {

	BitmapFont font;

	MatchGame matchGame;

	IntArray givenPattern;

	IntArray userPattern;

	int uPIndex;
	int correctCount;
	SpriteBatch batch;
	Texture noTouch;
	Texture touch;
	ShapeRenderer shape;

	OrthographicCamera cam;
	Viewport viewport;

	//Circle dot1;
	//Circle dot2;
	//Circle dot3;
	//Circle dot4;
	//Circle dot5;
	//Circle dot6;
	//Circle dot7;
	//Circle dot8;
	//Circle dot9;



	//Circle[][] dotMatrix;

	DotMatrix dM;

	public MatchScreen(MatchGame matchGame, IntArray pattern, DotMatrix dM) {
		this.matchGame = matchGame;
		this.givenPattern = pattern;
		userPattern = new IntArray(givenPattern.size);
		uPIndex = 0;
		correctCount = 0;
		//dM = new DotMatrix();
		this.dM = dM;
		this.dM.unCode();
		shape = new ShapeRenderer();

		cam = new OrthographicCamera();
		cam.setToOrtho(false, 350, 350);
		viewport = new FitViewport(350,350,cam);


		//batch = new SpriteBatch();
		//noTouch = new Texture("noTouch.png");
		//touch = new Texture("touch.png");
		//camera = new OrthographicCamera();
		//camera.setToOrtho(true, 350, 350);
		//camera.update();

		//dotMatrix = new Circle[3][3];

		//dot1 = new Circle(80,160,25);
		//dot2 = new Circle(190,170,25);
		//dot3 = new Circle(310,180,25);

//		dot4 = new Circle(80,310,25);
//		dot5 = new Circle(190,320,25);
//		dot6 = new Circle(310,330,25);
//
//		dot7 = new Circle(80,460,25);
//		dot8 = new Circle(190,470,25);
//		dot9 = new Circle(310,486,25);
//
//		dotMatrix[0][0] = dot1;
//		dotMatrix[0][1] = dot2;
//		dotMatrix[0][2] = dot3;
//		dotMatrix[1][0] = dot4;
//		dotMatrix[1][1] = dot5;
//		dotMatrix[1][2] = dot6;
//		dotMatrix[2][0] = dot7;
//		dotMatrix[2][1] = dot8;
//		dotMatrix[2][2] = dot9;
	}
	
	//@Override
//	public void create () {
//		batch = new SpriteBatch();
//		noTouch = new Texture("noTouch.png");
//		touch = new Texture("touch.png");
//		shape = new ShapeRenderer();
//		camera = new OrthographicCamera();
//		camera.setToOrtho(true, 350, 600);
//		camera.update();
//
//		dotMatrix = new Circle[3][3];
//
//		dot1 = new Circle(80,160,25);
//		dot2 = new Circle(190,170,25);
//		dot3 = new Circle(310,180,25);
//
//		dot4 = new Circle(80,310,25);
//		dot5 = new Circle(190,320,25);
//		dot6 = new Circle(310,330,25);
//
//		dot7 = new Circle(80,460,25);
//		dot8 = new Circle(190,470,25);
//		dot9 = new Circle(310,486,25);
////
//		dotMatrix[0][0] = dot1;
//		dotMatrix[0][1] = dot2;
//		dotMatrix[0][2] = dot3;
//		dotMatrix[1][0] = dot4;
//		dotMatrix[1][1] = dot5;
//		dotMatrix[1][2] = dot6;
//		dotMatrix[2][0] = dot7;
//		dotMatrix[2][1] = dot8;
//		dotMatrix[2][2] = dot9;
//	}

	@Override
	public void render (float delta) {



		//viewport.apply();
		dM.draw();

		if(checkPattern()) {
			correctCount++;
			//ScreenUtils.clear(0, 0, 0, 0);
			matchGame.setScreen(new PatternScreen(matchGame, correctCount));
		}
		//ScreenUtils.clear(0, 0, 0, 1);
		//camera.update();
		//batch.setProjectionMatrix(camera.combined);

		//shape.begin(ShapeRenderer.ShapeType.Filled);
		//shape.circle(x,y,25);
		//shape.end();

		if(Gdx.input.isTouched()) {
			Circle mHB = new Circle(Gdx.input.getX(), Gdx.input.getY(), 25);
//			shape.begin(ShapeRenderer.ShapeType.Filled);
//			shape.circle(mHB.x,350-mHB.y,25);
//			System.out.println(mHB.y);
//			shape.end();
			//Rectangle mHB = new Rectangle(Gdx.input.getX(), Gdx.input.getY(), 5,5);
//			if(dM.getDot(0,0).getHitBox().contains(mHB.x, mHB.y)) {
//				dM.getDot(0,0).isTouched();
//				userPattern.insert(uPIndex, 1);
//				uPIndex++;
//				System.out.println("GIVEN " + givenPattern.toString());
//				System.out.println("USER " + userPattern.toString());
//			}
			if(mHB.overlaps(dM.getDot(0,0).getHitBox()) && !dM.getDot(0,0).getIsTouched()) {
				dM.getDot(0,0).isTouched();
				userPattern.insert(uPIndex, 1);
				uPIndex++;
				System.out.println("GIVEN " + givenPattern.toString());
				System.out.println("USER " + userPattern.toString());
			}
			if(mHB.overlaps(dM.getDot(0,1).getHitBox()) && !dM.getDot(0,1).getIsTouched()) {
				dM.getDot(0,1).isTouched();
				userPattern.insert(uPIndex, 2);
				uPIndex++;
				System.out.println("GIVEN " + givenPattern.toString());
				System.out.println("USER " + userPattern.toString());
			}
			if(mHB.overlaps(dM.getDot(0,2).getHitBox()) && !dM.getDot(0,2).getIsTouched()) {
				dM.getDot(0,2).isTouched();
				userPattern.insert(uPIndex, 3);
				uPIndex++;
				System.out.println("GIVEN " + givenPattern.toString());
				System.out.println("USER " + userPattern.toString());
			}
			if(mHB.overlaps(dM.getDot(1,0).getHitBox()) && !dM.getDot(1,0).getIsTouched()) {
				dM.getDot(1,0).isTouched();
				userPattern.insert(uPIndex, 4);
				uPIndex++;
				System.out.println("GIVEN " + givenPattern.toString());
				System.out.println("USER " + userPattern.toString());
			}
			if(mHB.overlaps(dM.getDot(1,1).getHitBox()) && !dM.getDot(1,1).getIsTouched()) {
				dM.getDot(1,1).isTouched();
				userPattern.insert(uPIndex, 5);
				uPIndex++;
				System.out.println("GIVEN " + givenPattern.toString());
				System.out.println("USER " + userPattern.toString());
			}
			if(mHB.overlaps(dM.getDot(1,2).getHitBox()) && !dM.getDot(1,2).getIsTouched()) {
				dM.getDot(1,2).isTouched();
				userPattern.insert(uPIndex, 6);
				uPIndex++;
				System.out.println("GIVEN " + givenPattern.toString());
				System.out.println("USER " + userPattern.toString());
			}
			if(mHB.overlaps(dM.getDot(2,0).getHitBox()) && !dM.getDot(2,0).getIsTouched()) {
				dM.getDot(2,0).isTouched();
				userPattern.insert(uPIndex, 7);
				uPIndex++;
				System.out.println("GIVEN " + givenPattern.toString());
				System.out.println("USER " + userPattern.toString());
			}
			if(mHB.overlaps(dM.getDot(2,1).getHitBox()) && !dM.getDot(2,1).getIsTouched()) {
				dM.getDot(2,1).isTouched();
				userPattern.insert(uPIndex, 8);
				uPIndex++;
				System.out.println("GIVEN " + givenPattern.toString());
				System.out.println("USER " + userPattern.toString());
			}
			if(mHB.overlaps(dM.getDot(2,2).getHitBox()) && !dM.getDot(2,2).getIsTouched()) {
				dM.getDot(2,2).isTouched();
				userPattern.insert(uPIndex, 9);
				uPIndex++;
				System.out.println("GIVEN " + givenPattern.toString());
				System.out.println("USER " + userPattern.toString());
			}
			//System.out.println(checkPattern());

		}

	}

	public boolean checkPattern() {
		if(userPattern.size+1 == givenPattern.size) {
			for(int i = 0; i<userPattern.size; i++) {
				if(userPattern.get(i) != givenPattern.get(i)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}


	@Override
	public void resize(int width, int height) {

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
	public void dispose () {
		batch.dispose();
		touch.dispose();
		noTouch.dispose();
	}
}
