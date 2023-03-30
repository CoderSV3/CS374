package com.example.conversionsamuelviverosv3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Converter extends AppCompatActivity {

    private TextView prompt;
    private TextView dollars;
    private TextView amountDisplayed;
    private TextView retry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);
        prompt = findViewById(R.id.prompt);
        dollars = findViewById(R.id.dollarsLabel);
        amountDisplayed = findViewById(R.id.amountDisplayed);
        retry = findViewById(R.id.retry);

    }



    public void convert(View view) {

    }
}
