package com.example.discovery.discovery;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        final EditText keywords = (EditText) findViewById(R.id.editText);
//
//        RequestQueue request = Volley.newRequestQueue(this);
//        String test = "http://www.google.co.uk";
//
//        StringRequest stringR = new StringRequest(Request.Method.GET, test, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                keywords.setText("Here is the response " + response.substring(0, 100));
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                keywords.setText("An error occured");
//            }
//        });
//
//        request.add(stringR);





//        Button searchActivity = (Button) findViewById(R.id.searchButton);
//
//        searchActivity.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                String search = keywords.getText().toString();
//
//                if (search.isEmpty())
//                {
////                   showErrorDialog(search, 0);
//
//                }
//
//
//
//
//            }
//
//
//        });

    }
}


