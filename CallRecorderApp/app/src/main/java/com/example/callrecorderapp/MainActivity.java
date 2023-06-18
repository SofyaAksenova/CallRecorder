package com.example.callrecorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText phonenumber;
    FloatingActionButton callbutton;
    private final int REQUEST_CALL_PERMISSION = 100;
    private final int READ_PHONE_STATE_PERMISSION = 101;
    private final int REQUEST_MICROPHONE_PERMISSION = 102;
    private final int WRITE_EXTERNAL_STORAGE_PERMISSION = 103;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phonenumber = findViewById(R.id.editTextPhone);
        callbutton = findViewById(R.id.callbutton);

        if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL_PERMISSION);

        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, READ_PHONE_STATE_PERMISSION);
        }

        if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.RECORD_AUDIO},REQUEST_MICROPHONE_PERMISSION);

        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_PERMISSION);
        }


        callbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phonenum = phonenumber.getText().toString();
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+phonenum));
                startActivity(i);
            }
        });

        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        NewPhoneStateListener phoneStateListener = new NewPhoneStateListener();
        tm.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
    }

}
