package com.example.trystan_wong_colorassignment;

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * TouchListener implements the OnTouchListener interface to determine what object is being touched
 * on the screen
 * @author: Trystan Wong
 */
public class TouchListener implements View.OnTouchListener {

    //instance variables
    private ArrayList<CustomElement> elements; //CustomElements that can be touched
    private TextView tv; //the textView that displays the name of the object being touched
    private SeekBar r; //red seekbar
    private SeekBar g; //green seekbar
    private SeekBar b; //blue seekbar

    /**
     * Constructor that creates a TouchListener with given values
     *
     * @param initCE - ArrayList of objects on the surface view
     * @param initTV - TextView that changes to the current object touched
     * @param initR - red seekbar
     * @param initG - green seekbar
     * @param initB - blue seekbar
     */
    public TouchListener(ArrayList<CustomElement> initCE, TextView initTV, SeekBar initR, SeekBar initG, SeekBar initB) {

        //assigning values to the corresponding private instance variables
        elements = initCE;
        tv = initTV;
        r = initR;
        g = initG;
        b = initB;

    }

    /**
     * onTouch method checks if any of the objects on the surface view are where the user has just
     * touched
     *
     * @param view
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        // x and y values of the user's touch
        float x = motionEvent.getX();
        float y = motionEvent.getY();


        //going through each element in the ArrayList of CustomElements to see if it is within
        //range of the user's touch
        for(CustomElement e : elements) {

            //if the object is a circle
            if(e.isCircle) {
                //if the users touch is within the radius of the circle
                if (Math.abs(e.getX() - x) < e.length) {
                    if (Math.abs(e.getY() - y) < e.length) {

                        //creates new instances of Listeners for each color of seekbar for each
                        //object that has been touched
                        RedListener rl = new RedListener(e);
                        GreenListener gl = new GreenListener(e);
                        BlueListener bl = new BlueListener(e);

                        r.setOnSeekBarChangeListener(rl);
                        g.setOnSeekBarChangeListener(gl);
                        b.setOnSeekBarChangeListener(bl);

                        //sets the textview to the name of the object that has been touched
                        tv.setText(e.getName());

                        //sets the progress of the seekbars to the corresponding values of
                        //r, g, and b for the object touched
                        r.setProgress(e.getRed());
                        g.setProgress(e.getGreen());
                        b.setProgress(e.getBlue());

                    }
                }
            }
            //if the object is not a circle (it is a rectangle)
            else {
                //checks if the use
                // if the user's touch is within the area of the rectangle
                if (Math.abs(e.getX() - x) <= e.length/2) {
                    if (Math.abs(e.getY() - y) < e.height/2) {

                        //creates new instances of Listeners for each color of seekbar for each
                        //object that has been touched
                        RedListener rl = new RedListener(e);
                        GreenListener gl = new GreenListener(e);
                        BlueListener bl = new BlueListener(e);

                        r.setOnSeekBarChangeListener(rl);
                        g.setOnSeekBarChangeListener(gl);
                        b.setOnSeekBarChangeListener(bl);

                        //sets the textview to the name of the object that has been touched
                        tv.setText(e.getName());

                        //sets the progress of the seekbars to the corresponding values of
                        //r, g, and b for the object touched
                        r.setProgress(e.getRed());
                        g.setProgress(e.getGreen());
                        b.setProgress(e.getBlue());
                    }
                }
            }
        }

        return true;
    }

}
