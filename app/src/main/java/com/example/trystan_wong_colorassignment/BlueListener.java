package com.example.trystan_wong_colorassignment;

import android.widget.SeekBar;

/**
 * Listener for the the Blue SeekBar
 *
 * implements the OnSeekBarChangeListener interface and its methods.
 * @author: Trystan Wong
 */
public class BlueListener implements SeekBar.OnSeekBarChangeListener {

    //private CustomElement instance variable to access its setBlue() method.
    private CustomElement ce;

    /**
     * Constructor for the BlueListener class
     * @param initCE - CustomElement object
     */
    public BlueListener(CustomElement initCE){
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

        //sets the blue value in the CustomElement object to the progress of the seekbar
        ce.setBlue(i);
        ce.setNewColor();
    }

    //not used
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //not used
    }

    //not used
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //not used
    }
}
