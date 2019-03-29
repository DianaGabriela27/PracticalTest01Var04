package ro.pub.cs.systems.eim.practicaltest01var04;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {


    private Button topLeftButton;
    private Button topRightButton;
    private Button bottomLeftButton;
    private Button bottomRightButton;
    private Button centerButton;
    private Button navigateButton;
    private EditText textEditText;
    private static int numberOfClicks;

    private StartedServiceBroadcastReceiver startedServiceBroadcastReceiver;
    private IntentFilter startedServiceIntentFilter;

    private TopLeftButtonClickListener topLeftButtonClickListener = new TopLeftButtonClickListener();
    private class TopLeftButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String text = null;
            if(numberOfClicks == 0) {
                text = "Top Left";
            }
            else {
                text = ", Top Left";
            }
            textEditText.setText(textEditText.getText().append(text));
            numberOfClicks++;
            if(numberOfClicks > Constants.PRAG) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(getApplicationContext(), PracticalTest01Var04Service.class));
                intent.putExtra("TEXT", textEditText.getText().toString());
                intent.putExtra("CLICKS", String.valueOf(numberOfClicks));
                startService(intent);

                startedServiceBroadcastReceiver = new StartedServiceBroadcastReceiver();

                startedServiceIntentFilter = new IntentFilter();
                startedServiceIntentFilter.addAction(Constants.ACTION_GEN);

            }
        }
    }

    private TopRightButtonClickListener topRightButtonClickListener = new TopRightButtonClickListener();
    private class TopRightButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
                String text = null;
                if(numberOfClicks == 0) {
                    text = "Top Right";
                }
                else {
                    text = ", Top Right";
                }
                textEditText.setText(textEditText.getText().append(text));
                numberOfClicks++;
                if(numberOfClicks > Constants.PRAG) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(getApplicationContext(), PracticalTest01Var04Service.class));
                    intent.putExtra("TEXT", textEditText.getText().toString());
                    intent.putExtra("CLICKS", String.valueOf(numberOfClicks));
                    startService(intent);

                    startedServiceBroadcastReceiver = new StartedServiceBroadcastReceiver();

                    startedServiceIntentFilter = new IntentFilter();
                    startedServiceIntentFilter.addAction(Constants.ACTION_GEN);

                }
        }
    }

    private BottomLeftButtonClickListener bottomLeftButtonClickListener = new BottomLeftButtonClickListener();
    private class BottomLeftButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
                String text = null;
                if(numberOfClicks == 0) {
                    text = "Bottom left";
                }
                else {
                    text = ", Bottom Left";
                }
                textEditText.setText(textEditText.getText().append(text));
                numberOfClicks++;
                if(numberOfClicks > Constants.PRAG) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(getApplicationContext(), PracticalTest01Var04Service.class));
                    intent.putExtra("TEXT", textEditText.getText().toString());
                    intent.putExtra("CLICKS", String.valueOf(numberOfClicks));
                    startService(intent);

                    startedServiceBroadcastReceiver = new StartedServiceBroadcastReceiver();

                    startedServiceIntentFilter = new IntentFilter();
                    startedServiceIntentFilter.addAction(Constants.ACTION_GEN);

                }
        }
    }

    private BottomRightButtonClickListener bottomRightButtonClickListener = new BottomRightButtonClickListener();
    private class BottomRightButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
                String text = null;
                if(numberOfClicks == 0) {
                    text = "Bottom right";
                }
                else {
                    text = ", Bottom right";
                }
                textEditText.setText(textEditText.getText().append(text));
                numberOfClicks++;
                if(numberOfClicks > Constants.PRAG) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(getApplicationContext(), PracticalTest01Var04Service.class));
                    intent.putExtra("TEXT", textEditText.getText().toString());
                    intent.putExtra("CLICKS", String.valueOf(numberOfClicks));
                    startService(intent);

                    startedServiceBroadcastReceiver = new StartedServiceBroadcastReceiver();

                    startedServiceIntentFilter = new IntentFilter();
                    startedServiceIntentFilter.addAction(Constants.ACTION_GEN);

                }
        }
    }

    private CenterButtonClickListener centerButtonClickListener = new CenterButtonClickListener ();
    private class CenterButtonClickListener  implements View.OnClickListener {
        @Override
        public void onClick(View view) {
                String text = null;
                if(numberOfClicks == 0) {
                    text = "Center";
                }
                else {
                    text = ", Center";
                }
                textEditText.setText(textEditText.getText().append(text));
                numberOfClicks++;
                if(numberOfClicks > Constants.PRAG) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(getApplicationContext(), PracticalTest01Var04Service.class));

                    intent.putExtra("TEXT", textEditText.getText().toString());
                    intent.putExtra("CLICKS", String.valueOf(numberOfClicks));
                    startService(intent);

                    startedServiceBroadcastReceiver = new StartedServiceBroadcastReceiver();

                    startedServiceIntentFilter = new IntentFilter();
                    startedServiceIntentFilter.addAction(Constants.ACTION_GEN);

                }
        }
    }

    private NavigateButtonClickListener navigateButtonClickListener = new NavigateButtonClickListener();
    private class NavigateButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04SecondaryActivity.class);
            intent.putExtra("TEXT", textEditText.getText().toString());
            startActivityForResult(intent, Constants.REQUEST_CODE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        topLeftButton = (Button)findViewById(R.id.topLeftButton);
        topLeftButton.setOnClickListener(topLeftButtonClickListener);

        topRightButton = (Button)findViewById(R.id.topRightButton);
        topRightButton.setOnClickListener(topRightButtonClickListener);

        bottomLeftButton = (Button)findViewById(R.id.bottomLeftButton);
        bottomLeftButton.setOnClickListener(bottomLeftButtonClickListener);

        bottomRightButton = (Button)findViewById(R.id.bottomRightButton);
        bottomRightButton.setOnClickListener(bottomRightButtonClickListener);

        centerButton = (Button)findViewById(R.id.centerButton);
        centerButton.setOnClickListener(centerButtonClickListener);

        navigateButton = (Button)findViewById(R.id.navigateButton);
        navigateButton.setOnClickListener(navigateButtonClickListener);

        textEditText = (EditText)findViewById(R.id.textEditText);

        if(savedInstanceState != null)
            Toast.makeText(this, "Previous number of clicks " + String.valueOf(this.numberOfClicks), Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("NUMBER OF CLICKS", String.valueOf(this.numberOfClicks));

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey("NUMBER OF CLICKS"))
            this.numberOfClicks = Integer.parseInt(savedInstanceState.getString("NUMBER OF CLICKS"));
        if(savedInstanceState != null)
            Toast.makeText(this, "Previous number of clicks " + String.valueOf(this.numberOfClicks), Toast.LENGTH_LONG).show();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case Constants.REQUEST_CODE:
                Toast.makeText(this, "Activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
                textEditText.setText("");
                this.numberOfClicks = 0;
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // TODO: exercise 8c - register the broadcast receiver with the corresponding intent filter
        if(startedServiceBroadcastReceiver != null && startedServiceIntentFilter != null)
            registerReceiver(startedServiceBroadcastReceiver, startedServiceIntentFilter);
    }

    @Override
    protected void onPause() {
        // TODO: exercise 8c - unregister the broadcast receiver
        unregisterReceiver(startedServiceBroadcastReceiver);

        super.onPause();
    }

    @Override
    protected void onDestroy() {
        // TODO: exercise 8d - stop the service
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("ro.pub.cs.systems.eim.practicaltest01var04", "practicaltest01.eim.systems.cs.pub.ro.practicaltest01.PracticalTest01Service"));
        stopService(intent);

        super.onDestroy();
    }

}
