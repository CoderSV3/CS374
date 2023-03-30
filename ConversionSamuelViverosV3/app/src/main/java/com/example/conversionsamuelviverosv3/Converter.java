package com.example.conversionsamuelviverosv3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Scanner;

public class Converter extends AppCompatActivity {

    public static final String INPUT = "com.example.converstionsamuelviverosv3.extra.INPUT";
    private TextView prompt;
    private TextView dollars;
    private TextView amountDisplayed;
    private TextView retry;

    private Button convert;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);
        prompt = findViewById(R.id.prompt);
        dollars = findViewById(R.id.dollarsLabel);
        amountDisplayed = findViewById(R.id.amountDisplayed);
        retry = findViewById(R.id.retry);
        convert = findViewById(R.id.convert_button);
        editText = findViewById(R.id.input_field);

        String input = editText.getText().toString();

    }

    protected void onClick(@NonNull View view) {

        convert(convert);

    }

    public void convert(View view) {
        
    }
}
