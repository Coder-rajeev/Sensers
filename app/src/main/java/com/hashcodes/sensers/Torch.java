package com.hashcodes.sensers;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.TargetApi;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class Torch extends AppCompatActivity {

    AppCompatButton onnn, blinker;

    Boolean aBoolean = false;
    String string = "010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101010101010101010101010101010101010101101010101010101010101010101";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);

        onnn =findViewById(R.id.on);

        blinker =findViewById(R.id.blink);

        onnn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (aBoolean == false){
                    aBoolean=true;
                    CameraManager  cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
                    try {
                        String id = cameraManager.getCameraIdList()[0];

                        cameraManager.setTorchMode(id,true);


                    }catch (Exception e){

                    }
                }

                else if (aBoolean==true){
                    aBoolean=false;
                    CameraManager  cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
                    try {
                        String id = cameraManager.getCameraIdList()[0];

                        cameraManager.setTorchMode(id,false);


                    }catch (Exception e){

                    }
                }
            }
        });


        blinker.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                CameraManager  cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
                for (int i=0 ; i<string.length(); i++) {
                    if (string.charAt(i)=='0') {


                        try {
                            String id = cameraManager.getCameraIdList()[0];

                            cameraManager.setTorchMode(id, true);


                        } catch (Exception e) {

                        }
                    } else if (string.charAt(i)=='1') {


                        try {
                            String id = cameraManager.getCameraIdList()[0];

                            cameraManager.setTorchMode(id, false);


                        } catch (Exception e) {

                        }
                        try {
                            Thread.sleep(100);
                        }catch (Exception a){

                        }


                    }

                }
            }
        });


    }
}
