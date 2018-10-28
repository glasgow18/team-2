package com.example.discovery.discovery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();
        String artworkId = extras.get("activityId").toString();

        //Do a sql lookup and populate text views
    }
}
