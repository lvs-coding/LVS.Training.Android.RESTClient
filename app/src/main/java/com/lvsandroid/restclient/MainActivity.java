package com.lvsandroid.restclient;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Handler handler = new Handler();


        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                final JSONObject obj = RemoteFetch.getJSON(getApplicationContext(),"Sydney");

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("fds",obj.toString());
                    }
                });
                return null;
            }
        }.execute();


    }
}
