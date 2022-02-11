package com.example.trystan_wong_colorassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * MainActivity class used to run our app on our tablet
 * @Author: Trystan Wong
 */
public class MainActivity extends AppCompatActivity {

    /**
     * What happens when our app is turned on
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Seekbars
        SeekBar red = findViewById(R.id.redSeekBar);
        SeekBar green = findViewById(R.id.greenSeekBar);
        SeekBar blue = findViewById(R.id.blueSeekBar);

        //TextView of the current element
        TextView text = findViewById(R.id.currentDrawingElement);

        //Draw object used to draw our custom elements on the SurfaceView
        Draw drawing = new Draw(this);
        drawing = findViewById(R.id.canvas);


        //ArrayList of the drawn elements
        ArrayList<CustomElement> elements = drawing.getElements();

        //creating a TouchListener object and setting it as the onTouchListener of our
        //surfaceView
        TouchListener tl = new TouchListener(elements,text,red,green,blue);
        drawing.setOnTouchListener(tl);



    }
}