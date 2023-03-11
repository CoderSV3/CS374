package com.example.whowroteit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mBookInput;
    private TextView bookTitle;
    private TextView bookAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBookInput = (EditText) findViewById(R.id.bookInput);
        bookTitle = (TextView) findViewById(R.id.titleText);
        bookAuthor = (TextView) findViewById(R.id.authorText);
    }

    public void searchBooks(View view) {
        // This is to get the text from the user input, and then change into string format.
        String queryString = mBookInput.getText().toString();
    }



}