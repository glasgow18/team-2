package com.example.discovery.discovery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        ActivityPreview test1 = new ActivityPreview("test", "a", (float) 20.5, "123", "123");
        ListView activityList = findViewById(R.id.activityListView);
        ArrayAdapter<ActivityPreview> activityPreviewArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,test1);
        activityList.setAdapter(activityPreviewArrayAdapter);

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
}
