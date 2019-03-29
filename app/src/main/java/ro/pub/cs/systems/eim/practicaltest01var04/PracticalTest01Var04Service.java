package ro.pub.cs.systems.eim.practicaltest01var04;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class PracticalTest01Var04Service extends Service {
    public PracticalTest01Var04Service() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Constants.TAG, "onCreate() method was invoked");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(Constants.TAG, "onBind() method was invoked");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(Constants.TAG, "onUnbind() method was invoked");
        return true;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(Constants.TAG, "onRebind() method was invoked");
    }

    @Override
    public void onDestroy() {
        Log.d(Constants.TAG, "onDestroy() method was invoked");
        super.onDestroy();
    }

    // TODO exercise 5 - implement onStartCommand method
    // it needs to start a thread that sends three different type of broadcast intents
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(Constants.TAG, "onStartCommand() method was invoked");
        String text = intent.getStringExtra("TEXT");
        //Log.d(Constants.TAG, text);
        int numberOfClicks = Integer.parseInt(intent.getStringExtra("CLICKS"));
        Log.d(Constants.TAG, text);
        Log.d(Constants.TAG, String.valueOf(numberOfClicks));

        ProcessingThread processingThread = new ProcessingThread(this, numberOfClicks, text);
        processingThread.start();

        return START_REDELIVER_INTENT;
    }
}
