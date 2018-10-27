package com.example.discovery.discovery;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*try {
            showImage();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO EXception!!");
        }*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchActivity = findViewById(R.id.searchButton);

        searchActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final EditText keywords = findViewById(R.id.editText);
                String search = keywords.getText().toString();

                if (search.isEmpty()) {

                }else{
                    Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                    intent.putExtra("search", search);
                    startActivity(intent);
                }

            }

        });

    }

    private void showImage() throws MalformedURLException, IOException {
        URL url = new URL("https://cdn.teslarati.com/wp-content/uploads/2017/11/Roadster_Front_34_1-e1512593855725.jpg");
        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        ImageView i = findViewById(R.id.image);
        i.setImageBitmap(bmp);

    }
}


