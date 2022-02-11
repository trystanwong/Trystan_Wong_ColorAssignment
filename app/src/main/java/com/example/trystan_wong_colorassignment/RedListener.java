package com.example.trystan_wong_colorassignment;

import android.widget.SeekBar;

/**
 * Listener for the the Red SeekBar
 *
 * implements the OnSeekBarChangeListener interface and its methods.
 * @author: Trystan Wong
 */
public class RedListener implements SeekBar.OnSeekBarChangeListener {

    //private CustomElement instance variable to access its setRed() method.
    private CustomElement ce;

    /**
     * Constructor for the RedListener class
     * @param initCE - CustomElement object
     */
    public RedListener(CustomElement initCE){
        ce = initCE;
    }

    /**
     External Citation
     Date: 08 February 2022
     Problem: Did not know how what the parameters of the onProgressedChanged method meant.
     Resource:
     https://developer.android.com/reference/android/widget/SeekBar.OnSeekBarChangeListener
     Solution: I read the source code to understand what each parameter did for the function.
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        //sets the red value in the CustomElement object to the progress of the seekbar
        ce.setRed(i);
        ce.setNewColor();

    }

    //not used
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //not used
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //not used
    }
}
