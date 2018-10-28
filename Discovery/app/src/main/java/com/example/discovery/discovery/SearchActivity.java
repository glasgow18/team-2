package com.example.discovery.discovery;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    List<ActivityPreview> activityPreviews = new ArrayList<>();
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);






        ActivityPreview test4 = new ActivityPreview(2,"Outdoor Environmental Day Service", (float) 0.0, "55.899668", "-3.272208");
        ActivityPreview test1 = new ActivityPreview(3,"Long fence to make sound on at Vogrie",  (float) 0.0, "55.857549", "-2.992875");
        ActivityPreview test2 = new ActivityPreview(4,"Wheelchair friendly Cycle Path with 500m long tunnel",  (float) 0.0, "55.941456", "-3.172207");
        ActivityPreview test3 = new ActivityPreview(5,"Bendy Tunnel with darkness",  (float) 0.0, "55.907921", "-3.260044");
        activityPreviews.add(test1);
        activityPreviews.add(test2);
        activityPreviews.add(test3);
        activityPreviews.add(test4);
        ListView activityList = findViewById(R.id.activityListView);

        ActivityAdapter activityAdapter = new ActivityAdapter();
        activityList.setAdapter(activityAdapter);

        activityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Start a new intent and throw to new activity
                Intent intent = new Intent(getApplicationContext(), ActivityDetails.class);
                intent.putExtra("activityId" , Integer.toString(activityPreviews.get(position).getActivityId()));
                intent.putExtra("activityFullURL" , activityPreviews.get(position).getFullURL());
                intent.putExtra("activityName", activityPreviews.get(position).getActivityName());
                startActivity(intent);
            }
        });

        RequestQueue request = Volley.newRequestQueue(this);
        String test = "http://localhost:8080/activities";

        Bundle extras = getIntent().getExtras();
        final String search = extras.get("search").toString();

        StringRequest stringR = new StringRequest(Request.Method.GET, test, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Here is the response " + response);
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
            price.setText(Float.toString(activityPreviews.get(position).getPrice()));

            Picasso.with(parent.getContext()).load(activityPreviews.get(position).getThumbURL()).into(thumbnail);


            return view;

        }
    }




}
