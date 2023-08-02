package com.mygdx.match;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Dot {

    Circle dot;

//    Rectangle dot;
    Texture touch;
    Texture noTouch;

    Texture dotTexture;
    SpriteBatch sb;

    ShapeRenderer shapeRenderer;

    boolean isPattern;
    boolean isTouched;
    int x;
    int y;

    int iD;

    //New

    Vector2 center;
    Vector2 edge;

    public Dot(int x, int y, int iD) {
        touch = new Texture("touch.png");
        noTouch = new Texture("noTouch.png");

        shapeRenderer = new ShapeRenderer();
//        center = new Vector2(x+50,y-50);
//        edge = new Vector2(x,y-25);

        if(iD == 1 || iD == 2|| iD == 3) {
            //dot = new Circle(x, 50, 25);
            dot = new Circle(x+25, 75, 25);
            //dot = new Rectangle(x, 50,25,25);



            //dot = new Circle(center,edge);
        }else if(iD == 7 || iD == 8 || iD ==9) {
            dot = new Circle(x+25, 275, 25);
            //            dot = new Circle(x, 250, 25);
            //dot = new Rectangle(x, 250,25,25);
            //dot = new Circle(center,edge);
        } else {
            dot = new Circle(x+25, y+25, 25);
            //dot = new Rectangle(x, 25,25,25);
            //dot = new Circle(center,edge);
        }
        isPattern = false;
        isTouched = false;
        this.x = x;
        this.y = y;
        this.iD = iD;
        sb = new SpriteBatch();
        System.out.println("ID: " + iD + " " + "Y: " + y + " CIRCLE Y: " + dot.y );

    }

    public void draw() {
        //sb.setProjectionMatrix();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //System.out.println("X: " + x + "Y: " + y);
        shapeRenderer.circle(x,y,5);
        shapeRenderer.end();
        if(isPattern || isTouched) {
            sb.begin();
            sb.draw(touch, x, y);
            sb.end();
        } else {
            sb.begin();
            sb.draw(noTouch, x, y);
            sb.end();
        }

//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        //System.out.println("X: " + x + "Y: " + y);
//        shapeRenderer.circle(x,y,25);
//        shapeRenderer.end();
    }

    public void drawBlank() {
        sb.begin();
        sb.draw(noTouch, x, y);
        sb.end();
    }

//    public void isTouched() {
//        noTouch.dispose();
//        sb.begin();
//        sb.draw(touch, x, y);
//        sb.end();
//    }

    public void isPattern() {
        isPattern = true;
    }
    public void isTouched() {
        isTouched = true;
    }

    public void reset() {
        isPattern = false;
        isTouched = false;
    }

    public Circle getHitBox() {
        return dot;
    }

    public boolean getIsTouched() {
        return isTouched;
    }

    public boolean getIsPattern() {
        return isPattern;
    }

}
