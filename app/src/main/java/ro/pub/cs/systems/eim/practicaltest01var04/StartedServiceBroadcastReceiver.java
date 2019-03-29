package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: exercise 7 - get the action and the extra information from the intent
        // and set the text on the messageTextView

        String action = intent.getAction();
        String data = null;
        Log.d(Constants.TAG, "SDASDSADASDSA");
        if (Constants.ACTION_GEN.equals(action)) {
            data = intent.getStringExtra(Constants.DATA);
            Log.d(Constants.TAG, data);
        }


    }
}
