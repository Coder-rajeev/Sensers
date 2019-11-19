package com.hashcodes.sensers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    Sensor sensor;
    SensorManager sensorManager;
    Vibrator vibrator;
    TextView textView;
    Float aFloat;


    @Override
    protected void onPostResume() {
        super.onPostResume();
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txt);
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!=null){
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
            aFloat=sensor.getMaximumRange()/2;

        }


        vibrator=(Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.notify();
                vibrator.vibrate(1000);
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textView.setText(Float.toString(aFloat));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
