package com.example.conversionsamuelviverosv3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    private Button begin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        begin = findViewById(R.id.begin);
    }

    protected void onClick(@NonNull View view) {
        startConverter(begin);
    }

    public void startConverter(View view) {
        Log.d(LOG_TAG, "Button clicked, converter starting.");
        Intent startConverter = new Intent(this, Converter.class);
        startActivity(startConverter);
    }
}