package com.example.whowroteit;

import android.os.AsyncTask;
import android.widget.TextView;

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
    }

}
