package com.lfoliveira.lasalle.exampleexam2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textViewTime;

        SeekBar seekBar = findViewById(R.id.seekBar);
        textViewTime = findViewById(R.id.textViewTime);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int hours = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                hours = (progress - 2) / 4;

                if (hours == 24) {
                    hours = hours - 1;
                }

                textViewTime.setText(hours+":00");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {



            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
