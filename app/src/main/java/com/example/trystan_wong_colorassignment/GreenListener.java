package com.example.trystan_wong_colorassignment;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Listener for the the Green SeekBar
 *
 * implements the OnSeekBarChangeListener interface and its methods.
 * @author: Trystan Wong
 */
public class GreenListener implements SeekBar.OnSeekBarChangeListener {

    //private CustomElement instance variable to access its setGreen() method.
    private CustomElement ce;

    /**
     * Constructor for the GreenListener class
     * @param initCE - CustomElement object
     */
    public GreenListener(CustomElement initCE) {
        ce = initCE;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        //sets the green value in the CustomElement object to the progress of the seekbar
        ce.setGreen(i);
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

