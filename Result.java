package com.example.event_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView rt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        rt1=findViewById(R.id.re1);
        Intent intent=getIntent();
        String s=intent.getStringExtra("key");
        rt1.setText(s);

    }
}