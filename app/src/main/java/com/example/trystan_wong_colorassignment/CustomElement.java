package com.example.trystan_wong_colorassignment;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * This class represents an element (circle or rectangle) drawn on the surfaceView
 * @Author: Trystan Wong
 * */
public class CustomElement {

    //instance variables
    protected float x; // x-coordinate
    protected float y; // y-coordinate
    protected int r; //red value of the objects color
    protected int g; //green value of the objects color
    protected int b; //blue value of the objects color
    protected float length;
    protected float height;
    protected String name; //name used for the currentElement TextView
    protected boolean isCircle; //is the object a circle
    protected Paint myPaint; //color of the object

    /**
     * Constructor creates a CustomElement with given values
     *
     * @param initName - name of the element
     * @param initX - x-coordinate of the center of the object
     * @param initY - y-coordinate of the center of the object
     * @param initR - starting value of red
     * @param initG - starting value of green
     * @param initB - starting value of blue
     * @param initLength - length of the object (serves as the radius if the object is a circle)
     * @param initHeight - height of the object
     * @param circle - is the object a circle
     */
    public CustomElement(String initName, int initX, int initY, int initR, int initG, int initB,
                         float initLength, float initHeight, boolean circle) {

        //assigning the values from the parameter of this constructor to its corresponding
        //instance variable
        name = initName;
        x = initX;
        y = initY;
        r = initR;
        g = initG;
        b = initB;
        length = initLength;
        height = initHeight;
        isCircle = circle;

        //calling the setNewColor function to set the color of the object
        setNewColor();
    }

    /** sets the color of the object based on its current r, g, and b values */
    protected void setNewColor() {
        int myColor = Color.rgb(r,g,b);
        myPaint = new Paint();
        myPaint.setColor(myColor);
    }

    /** returns the current value of red */
    protected int getRed()
    {
        return r;
    }

    /** returns the current value of green */
    protected int getGreen()
    {
        return g;
    }

    /** returns the current value of blue */
    protected int getBlue()
    {
        return b;
    }

    /** returns the name of the object */
    protected String getName()
    {
        return name;
    }

    /** returns the current x coordinate */
    protected float getX()
    {
        return x;
    }

    /** returns the current y coordinate */
    protected float getY()
    {
        return y;
    }

    /** sets the value of r (red)*/
    protected void setRed(int initR)
    {
        r = initR;
    }

    /** sets the value of g (green)*/
    protected void setGreen(int initG)
    {
        g = initG;
    }

    /** sets the value of b (blue)*/
    protected void setBlue(int initB)
    {
        b = initB;
    }



    /** a spot knows how to draw itself on a given canvas */
    public void draw(Canvas canvas) {

        //calculating the top, bottom, and right using the length and height if the object
        //is a rectangle
        float top = y - (height/2);
        float left = x - (length/2);
        float bottom = y + (height/2);
        float right = x + (length/2);

        //if the object is a circle, draw a circle. If it isn't, draw a rectangle
        if(isCircle) {
            canvas.drawCircle(x, y, length, myPaint);
        }
        else
        {
            canvas.drawRect(left,top,right,bottom,myPaint);
        }

    }
}// class Spot



