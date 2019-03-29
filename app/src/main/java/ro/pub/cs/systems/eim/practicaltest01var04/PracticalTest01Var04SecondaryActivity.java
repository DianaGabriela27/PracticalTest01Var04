package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    Button verifyButton;
    Button cancelButton;
    EditText textEditText;

    public PracticalTest01Var04SecondaryActivity () {

    }

    private CancelButtonClickListener cancelButtonClickListener = new CancelButtonClickListener();
    private class CancelButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            setResult(2, null);
            finish();
        }
    }

    private VerifyButtonClickListener verifyButtonClickListener = new VerifyButtonClickListener();
    private class VerifyButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            setResult(1, null);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        cancelButton = (Button)findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(cancelButtonClickListener);

        verifyButton = (Button)findViewById(R.id.verifyButton);
        verifyButton.setOnClickListener(verifyButtonClickListener);

        textEditText = (EditText) findViewById(R.id.textEditText);


        Intent intent = getIntent();
        if (intent != null) {
            String text = intent.getStringExtra("TEXT");

            if (text != null) {
                textEditText.setText(text);
            }
        }
    }
}
