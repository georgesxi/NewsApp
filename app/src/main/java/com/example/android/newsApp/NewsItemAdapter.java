package com.example.android.newsApp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import android.graphics.drawable.GradientDrawable;


public class NewsItemAdapter extends ArrayAdapter<NewsItem> {

    public NewsItemAdapter(Activity context, ArrayList<NewsItem> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        NewsItem currentEntry = getItem(position);

        // Find the TextView in the list_item.xml layout
        TextView webTitleView = (TextView) listItemView.findViewById(R.id.web_title);
        TextView sectionNameView = (TextView) listItemView.findViewById(R.id.section);
        TextView authorNameView = (TextView) listItemView.findViewById(R.id.author);

        ImageView thumbnailView = (ImageView) listItemView.findViewById(R.id.thumbnail);
        Bitmap mybit = getBitmapFromURL(currentEntry.getThumbnailSrc());

        thumbnailView.setImageBitmap(mybit);

        String webTitle = currentEntry.getWebTitle();

        // Get the web title from the current NewsItem object and
        // set this text on the name TextView
        webTitleView.setText(webTitle);

        String sectionName = currentEntry.getSectionName();
        sectionNameView.setText(sectionName);

        String authorName = currentEntry.getAuthorName();
        authorNameView.setText(authorName);

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        String date = currentEntry.getWebPublicationDate();
        dateView.setText(date);

        // Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }


    public static Bitmap getBitmapFromURL(String src) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (Exception e) {
            Log.e("mytag", "This thumbnail will not appear due to an exception");
            return null;
        }
    }
}
