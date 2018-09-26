package com.nicootech.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    private final IBinder ehsansBinder = new MyLocalBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return ehsansBinder;
    }

    //This is the method for time

    public String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return(df.format(new Date()));
    }

    //This is the method for Date
    public String getMyDate(){
        Date d = new Date();
        CharSequence s  = DateFormat.format("EEEE, MMMM d, yyyy ", d.getTime());
        return (s.toString());
    }


    public class MyLocalBinder extends Binder {

        MyService getService(){
            return MyService.this;
        }

    }





}
