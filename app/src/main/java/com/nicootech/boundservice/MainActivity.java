package com.nicootech.boundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nicootech.boundservice.MyService.MyLocalBinder;

public class MainActivity extends AppCompatActivity {

    MyService ehsansService;
    boolean isBound = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, MyService.class);
        bindService(i,ehsansConnection, Context.BIND_AUTO_CREATE);

    }

    public void showTime(View view) {
        String currentDate = ehsansService.getMyDate();
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(currentDate);
        String CurrentTime = ehsansService.getCurrentTime();
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setText(CurrentTime);
    }

    private ServiceConnection ehsansConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalBinder binder = (MyLocalBinder) service;
            ehsansService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
}
