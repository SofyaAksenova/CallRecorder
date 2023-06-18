package com.example.callrecorderapp;

import android.media.MediaRecorder;
import android.os.Environment;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class NewPhoneStateListener extends PhoneStateListener {
    private MediaRecorder recorder = null;
    private boolean isRecording = false;
    private final String dir = Environment.getExternalStorageDirectory() + "/CallRecorder";
    private final String file = dir + "/call.mp3";


    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:
                if (isRecording) {
                    stopRecording();
                }
                Log.d("dbg", "recording stopped");
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                try {
                    startRecording();
                    Log.d("dbg", "recording in progress");
                    Log.d("file", file);
                } catch (IOException e) {
                    Log.e("err", "recording is not in progress");
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void startRecording() throws IOException {
        File directory = new File(dir);
        if (directory.exists() == false) {
            directory.mkdir();
        }

        File out = new File(file);
        if (out.exists()) {
            out.delete();
        }

        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(file);

        recorder.prepare();
        recorder.start();
        isRecording = true;
    }

    private void stopRecording() {
        recorder.stop();
        recorder.reset();
        recorder.release();
        recorder = null;
        isRecording = false;
    }
}
