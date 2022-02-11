package com.example.trystan_wong_colorassignment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;
import java.util.ArrayList;


/**
 * Draw Class is the class that extends SurfaceView that our
 * @Author: Trystan Wong
 */
public class Draw extends SurfaceView {

    //private ArrayList of CustomElements
    private ArrayList<CustomElement> elements;

    //getter for the array of CustomElements
    public ArrayList<CustomElement> getElements()
    {
        return elements;
    }

    //never used
    public Draw(Context context) {
        super(context);
        initialize();
        setWillNotDraw(false);
    }


    //never used
    public Draw(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
        setWillNotDraw(false);
    }

    //never used
    public Draw (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
        setWillNotDraw(false);
    }

    /**
     * initialize method creates CustomElement objects "drawn" on the surface view
     */
    public void initialize() {


        this.setBackgroundColor(Color.BLUE);

        //customElement objects that are going to be drawn

        CustomElement sun = new CustomElement("Sun",100,100,
                255,255,0,200,0,true);

        CustomElement wheel1 = new CustomElement("Wheel 1",300,650,
                0,0,0,100,0,true);

        CustomElement wheel2 = new CustomElement("Wheel 2",600,650,
                0,0,0,100,0,true);

        CustomElement carBody = new CustomElement("Car Body",450,500,
                255,0,0,600,300,false);

        CustomElement window1 = new CustomElement("Rear Window",300,450,
                255,255,255,200,100,false);

        CustomElement window2 = new CustomElement("Front Window",600,450,
                255,255,255,200,100,false);

        CustomElement treeTrunk = new CustomElement("Tree Stem",900,500,
                218, 160, 109,150,400,false);

        CustomElement treeLeaves = new CustomElement("Tree Leaves",900,300,
                0,255,0,150,0,true);

        CustomElement road = new CustomElement("Road", 600,775,
                80,80,80,4000,200,false);

        //ArrayList of the CustomElement objects
        elements = new ArrayList<>();

        //adding the CustomElements to our elements ArrayList in the order they are added
        //to the surfaceView.
        elements.add(sun);
        elements.add(treeTrunk);
        elements.add(treeLeaves);
        elements.add(road);
        elements.add(carBody);
        elements.add(wheel1);
        elements.add(wheel2);
        elements.add(window1);
        elements.add(window2);

    }

    /**
     *
     * onDraw draws the CustomElement objects from our elements array on to a canvas
     *
     * @param canvas - the canvas that the objects are drawn on
     */
    @Override
    public void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        //going through each element in the elements array and drawing them on the given canvas
        for(CustomElement c : elements) {
            c.draw(canvas);
        }

        //calls the invalidate function to update the SurfaceView
        invalidate();

    }
}

