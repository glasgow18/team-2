package com.example.discovery.discovery;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    List<ActivityPreview> activityPreviews = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ActivityPreview test5 = new ActivityPreview("testjkndsa", "19 adfj, adhfjkl aa", (float) 13.23, "123", "123", null);
        ActivityPreview test4 = new ActivityPreview("tesjkdt", "a", (float) 53.5, "123", "123",null);
        ActivityPreview test1 = new ActivityPreview("test", "a", (float) 46.5, "123", "123",null);
        ActivityPreview test2 = new ActivityPreview("test2", "a", (float) 435, "123", "123",null);
        ActivityPreview test3 = new ActivityPreview("test3", "a", (float) 345, "123", "123", "https://i.imgur.com/iHsr4Nd.png");
        activityPreviews.add(test1);
        activityPreviews.add(test2);
        activityPreviews.add(test3);
        activityPreviews.add(test4);
        activityPreviews.add(test5);
        ListView activityList = findViewById(R.id.activityListView);

        ActivityAdapter activityAdapter = new ActivityAdapter();
        activityList.setAdapter(activityAdapter);

        activityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Start a new intent and throw to new activity

            }
        });

        RequestQueue request = Volley.newRequestQueue(this);
        String test = "http://www.google.co.uk";

        Bundle extras = getIntent().getExtras();
        final String search = extras.get("search").toString();

        StringRequest stringR = new StringRequest(Request.Method.GET, test, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Here is the response " + response.substring(0, 100));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("An error occured");
            }
        });

        request.add(stringR);

    }

    public class ActivityAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return activityPreviews.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }



        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.activity_preview_row, null);
            TextView activityName = view.findViewById(R.id.activityName);
            TextView address = view.findViewById(R.id.address);
            TextView price = view.findViewById(R.id.price);
            ImageView thumbnail = view.findViewById(R.id.thumbnail);
            activityName.setText(activityPreviews.get(position).getActivityName());
            address.setText(activityPreviews.get(position).getAddress());
            price.setText(Float.toString(activityPreviews.get(position).getPrice()));

            Picasso.with(parent.getContext()).load(activityPreviews.get(position).getURL()).into(thumbnail);


            return view;

        }
    }



}
