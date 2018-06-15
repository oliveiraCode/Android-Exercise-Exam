package com.lfoliveira.lasalle.exampleexam;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LightFragment extends Fragment implements SensorEventListener {


    private SensorManager sensorManager;
    private Sensor light;
    TextView textViewLightSensor;

    public LightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_light, container, false);


        textViewLightSensor = rootView.findViewById(R.id.textViewLightSensor);


        sensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this,light, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        textViewLightSensor.setText(Float.toString(event.values[0]));

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
