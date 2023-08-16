package com.mygdx.match;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.IntArray;

public class Dot {

    Circle dot;

//    Rectangle dot;
    Texture touch;

    Texture touch0;
    Texture touch45;
    Texture touch90;
    Texture touch135;
    Texture touch180;
    Texture touch225;
    Texture touch270;
    Texture touch315;

    Texture noTouch;

    Texture dotTexture;
    SpriteBatch sb;

    ShapeRenderer shapeRenderer;

    IntArray validNeighbors;
    IntArray currentPattern;

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

        touch0 = new Texture("touch0.png");
        touch45 = new Texture("touch45.png");
        touch90 = new Texture("touch90.png");
        touch135 = new Texture("touch135.png");
        touch180 = new Texture("touch180.png");
        touch225 = new Texture("touch225.png");
        touch270 = new Texture("touch270.png");
        touch315 = new Texture("touch315.png");


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
        genNeighbors();

    }

    public void draw() {
        //sb.setProjectionMatrix();

        //shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //System.out.println("X: " + x + "Y: " + y);
        //shapeRenderer.circle(x,y,5);
        //shapeRenderer.end();
        if(isTouched) {
            sb.begin();
            sb.draw(touch, x, y);
            sb.end();
        }
        else if(isPattern || isTouched) {
            //System.out.println("ISPATTERN/ISTOUCHED" + iD);
            setTouchArrow();
            sb.begin();
            sb.draw(touch, x, y);
            sb.end();
        } else {
            //System.out.println("NOTOUCH");
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

    public void genNeighbors() {

        validNeighbors = new IntArray();

        if(iD == 1) {
            validNeighbors.add(2,4,5);
        }
        if(iD == 2) {
            validNeighbors.add(1,3,4,5);
            validNeighbors.add(6);
        }
        if(iD == 3) {
            validNeighbors.add(2,5,6);
        }
        if(iD == 4) {
            validNeighbors.add(1,2,5,7);
            validNeighbors.add(8);
        }
        if(iD == 5) {
            validNeighbors.add(1,2,3,4);
            validNeighbors.add(6,7,8,9);
        }
        if(iD == 6) {
            validNeighbors.add(2,3,5,8);
            validNeighbors.add(9);
        }
        if(iD == 7) {
            validNeighbors.add(4,5,8);
        }
        if(iD == 8) {
            validNeighbors.add(4,5,6,7);
            validNeighbors.add(9);
        }
        if(iD == 9) {
            validNeighbors.add(5,6,8);
        }


    }

    public void setCurrentPattern(IntArray currentPattern) {
        this.currentPattern = currentPattern;
    }

    public void setTouchArrow() {
        int neighbor;
        if(currentPattern.contains(iD) && currentPattern.indexOf(iD) != currentPattern.size-1) {
            if(iD == 1 ) {
                neighbor = currentPattern.get(currentPattern.indexOf(iD) + 1);
                if(neighbor == 2 ) {
                    touch = new Texture("TOUCH90.png");
                }
                if(neighbor == 5 ) {
                    touch = new Texture("TOUCH135.png");
                }
                if(neighbor == 4) {
                    touch = new Texture("TOUCH180.png");
                }
            }
            if(iD == 2 ) {
                neighbor = currentPattern.get(currentPattern.indexOf(iD) + 1);
                if(neighbor == 1 ) {
                    touch = new Texture("TOUCH270.png");
                }
                if(neighbor == 3 ) {
                    touch = new Texture("TOUCH90.png");
                }
                if(neighbor == 4) {
                    touch = new Texture("TOUCH225.png");
                }
                if(neighbor == 5 ) {
                    touch = new Texture("TOUCH180.png");
                }
                if(neighbor == 6) {
                    touch = new Texture("TOUCH135.png");
                }
            }

            if(iD == 3 ) {
                neighbor = currentPattern.get(currentPattern.indexOf(iD) + 1);
                if(neighbor == 2 ) {
                    touch = new Texture("TOUCH270.png");
                }
                if(neighbor == 5 ) {
                    touch = new Texture("TOUCH225.png");
                }
                if(neighbor == 6) {
                    touch = new Texture("TOUCH180.png");
                }
            }
            if(iD == 4 ) {
                neighbor = currentPattern.get(currentPattern.indexOf(iD) + 1);
                if(neighbor == 1 ) {
                    touch = new Texture("TOUCH0.png");
                }
                if(neighbor == 2 ) {
                    touch = new Texture("TOUCH45.png");
                }
                if(neighbor == 5) {
                    touch = new Texture("TOUCH90.png");
                }
                if(neighbor == 7 ) {
                    touch = new Texture("TOUCH180.png");
                }
                if(neighbor == 8) {
                    touch = new Texture("TOUCH135.png");
                }
            }
            if(iD == 5 ) {
                neighbor = currentPattern.get(currentPattern.indexOf(iD) + 1);
                if(neighbor == 1 ) {
                    touch = new Texture("TOUCH315.png");
                }
                if(neighbor == 2 ) {
                    touch = new Texture("TOUCH0.png");
                }
                if(neighbor == 3) {
                    touch = new Texture("TOUCH45.png");
                }
                if(neighbor == 4 ) {
                    touch = new Texture("TOUCH270.png");
                }
                if(neighbor == 6 ) {
                    touch = new Texture("TOUCH90.png");
                }
                if(neighbor == 7) {
                    touch = new Texture("TOUCH225.png");
                }
                if(neighbor == 8) {
                    touch = new Texture("TOUCH180.png");
                }
                if(neighbor == 9) {
                    touch = new Texture("TOUCH135.png");
                }
            }
            if(iD == 6 ) {
                neighbor = currentPattern.get(currentPattern.indexOf(iD) + 1);
                if(neighbor == 2 ) {
                    touch = new Texture("TOUCH315.png");
                }
                if(neighbor == 3 ) {
                    touch = new Texture("TOUCH0.png");
                }
                if(neighbor == 5) {
                    touch = new Texture("TOUCH270.png");
                }
                if(neighbor == 8 ) {
                    touch = new Texture("TOUCH225.png");
                }
                if(neighbor == 9) {
                    touch = new Texture("TOUCH180.png");
                }
            }
            if(iD == 7 ) {
                neighbor = currentPattern.get(currentPattern.indexOf(iD) + 1);
                if(neighbor == 4 ) {
                    touch = new Texture("TOUCH0.png");
                }
                if(neighbor == 5 ) {
                    touch = new Texture("TOUCH45.png");
                }
                if(neighbor == 8) {
                    touch = new Texture("TOUCH90.png");
                }
            }
            if(iD == 8 ) {
                neighbor = currentPattern.get(currentPattern.indexOf(iD) + 1);
                if(neighbor == 4 ) {
                    touch = new Texture("TOUCH315.png");
                }
                if(neighbor == 5 ) {
                    touch = new Texture("TOUCH0.png");
                }
                if(neighbor == 6 ) {
                    touch = new Texture("TOUCH45.png");
                }
                if(neighbor == 7) {
                    touch = new Texture("TOUCH270.png");
                }
                if(neighbor == 9) {
                    touch = new Texture("TOUCH90.png");
                }
            }
            if(iD == 9 ) {
                neighbor = currentPattern.get(currentPattern.indexOf(iD) + 1);
                if(neighbor == 5 ) {
                    touch = new Texture("TOUCH315.png");
                }
                if(neighbor == 6 ) {
                    touch = new Texture("TOUCH0.png");
                }
                if(neighbor == 8) {
                    touch = new Texture("TOUCH270.png");
                }
            }
        }
    }

    public void resetTouchArrow() {
        touch = new Texture("touch.png");
    }
}
