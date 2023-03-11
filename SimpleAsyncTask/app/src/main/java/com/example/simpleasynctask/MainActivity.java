package com.example.simpleasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // We will use this textview to show our results
    private TextView mTextView;
    private static final String TEXT_STATE = "currentText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);

        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    public void startTask(View view) {
        // Putting a message into the textview
        mTextView.setText(R.string.napping);
        // Start the Async Task
        // The AsyncTask task has a callback that will update the TextView
        new SimpleAsyncTask(mTextView).execute();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Saves the state of the TextView
        outState.putString(TEXT_STATE,
                mTextView.getText().toString());

    }

}