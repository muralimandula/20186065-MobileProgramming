package com.example.android.sunshine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView weatherDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        weatherDetail = (TextView) findViewById(R.id.tv_weather_detail);

        weatherDetail.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
    }

}
