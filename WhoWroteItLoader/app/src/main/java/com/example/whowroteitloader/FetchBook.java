package com.example.whowroteitloader;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class FetchBook extends AsyncTask <String, Void, String> {

    private WeakReference<TextView> mTitleText;
    private WeakReference<TextView> mAuthorText;

    FetchBook(TextView mTitleText, TextView mAuthorText) {
        this.mTitleText = new WeakReference<TextView>(mTitleText);
        this.mAuthorText = new WeakReference<TextView>(mAuthorText);
    }

    @Override
    protected String doInBackground(String ... strings) {
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            // Convert respone into JSON object
            JSONObject jsonObject = new JSONObject(s);
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

            // If both are found, display the result.
            if (title != null && authors != null) {
                mTitleText.get().setText(title);
                mAuthorText.get().setText(authors);
            } else {
                // If none are found, update UI to show failed results.
                mTitleText.get().setText(R.string.no_results);
                mAuthorText.get().setText("");
            }

        } catch (Exception e) {
            mTitleText.get().setText(R.string.no_results);
            mAuthorText.get().setText("");
        }

    }

}
