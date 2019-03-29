package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ProcessingThread extends Thread {

    private Context context;
    int numberOfClicks;
    String text;

    public ProcessingThread(Context context, int numberOfClicks, String text) {
        this.numberOfClicks = numberOfClicks;
        this.text = text;
        this.context = context;
    }

    @Override
    public void run() {
        Log.d(Constants.TAG, "Thread.run() was invoked, PID: " + android.os.Process.myPid() + " TID: " + android.os.Process.myTid());

        String[] words = text.split(", ");

        int i = 0;
        while(true) {
            sendMessage(Constants.MESSAGE_GEN, words[i]);
            i++;
            sleep();
            numberOfClicks--;
            if(numberOfClicks < 1)
                break;
        }

    }

    private void sendMessage(int messageType, String textToSend) {
        Intent intent = new Intent();
        switch (messageType) {
            case Constants.MESSAGE_GEN:
                intent.setAction(Constants.ACTION_GEN);
                intent.putExtra(Constants.DATA, textToSend);
                Log.d(Constants.TAG, textToSend);
                break;
        }
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException interruptedException) {
            Log.e(Constants.TAG, interruptedException.getMessage());
            interruptedException.printStackTrace();
        }
    }
}
