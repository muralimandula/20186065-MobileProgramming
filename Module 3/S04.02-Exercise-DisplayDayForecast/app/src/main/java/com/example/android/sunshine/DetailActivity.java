package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    TextView aaaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        aaaa = (TextView) findViewById(R.id.aaa);

        aaaa.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));

        // TODO (2) Display the weather forecast that was passed from MainActivity
    }
}