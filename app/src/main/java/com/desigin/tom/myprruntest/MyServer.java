package com.desigin.tom.myprruntest;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/1/8.
 */
public class MyServer extends Service {
    Timer timer;
    public MyServer(){

    }
    @Override
    public void onCreate() {
        System.out.println("1111111111111111onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("22222222222222222onStartCommand");
        timer = new Timer(true);
        timer.schedule(task, 1000, 1000); //延时1000ms后执行，1000ms执行一次

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        timer.cancel(); //退出计时器
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    TimerTask task = new TimerTask(){
             public void run() {

                 String str=GetThing.doSomething(MyServer.this);
                 System.out.println("FFFFFFFFFFFFFFFFFFF"+str);

               }
         };


}
