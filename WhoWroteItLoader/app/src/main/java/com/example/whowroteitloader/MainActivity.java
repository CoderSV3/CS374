package com.example.whowroteitloader;

import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.LoaderManager.LoaderCallbacks;

import com.example.whowroteitloader.FetchBook;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

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

        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;

        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected() && queryString.length() != 0) {

            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);

            bookTitle.setText("");
            bookAuthor.setText(R.string.loading);
        } else {
            if (queryString.length() == 0) {
                bookAuthor.setText("");
                bookTitle.setText(R.string.no_search_term);
            } else {
                bookAuthor.setText("");
                bookTitle.setText(R.string.no_network);
            }
        }

    }

    @NonNull
    @Override
    public Loader onCreateLoader(int id, @Nullable Bundle args) {
        String queryString = "";

        if (args != null) {
            queryString = args.getString("queryString");
        }

        return new BookLoader(this, queryString);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {

        try {
            // Convert respone into JSON object
            JSONObject jsonObject = new JSONObject(data);
            // Get JSONArray of book items
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            // Initialize iterator and results fields.
            int i = 0;
            String title = null;
            String authors = null;

            // Search and retrieve results from the items array, exiting
            // once both the title and the author info have been found
            // or if all the itmes have been checked.

            while (i < itemsArray.length() && (authors == null && title == null)) {

                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                // Try catch block for getting the author and title from current item
                // catch block runs if either field is empty.
                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // Iterate
                i++;
            }


        } catch (Exception e) {

        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

}