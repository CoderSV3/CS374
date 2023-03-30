package com.example.conversionsamuelviverosv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startConverter(View view) {
        Log.d(LOG_TAG, "Button clicked, converter starting.");
        Intent startConverter = new Intent(this, Converter.class);
        startActivity(startConverter);
    }
}