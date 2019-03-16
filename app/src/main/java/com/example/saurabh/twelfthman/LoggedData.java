package com.example.saurabh.twelfthman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoggedData extends AppCompatActivity {
   TextView musername, mpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_data);

     musername= findViewById(R.id.tv_username);
     mpassword= findViewById(R.id.tv_password);

     Intent in = getIntent();
     musername.setText(in.getStringExtra("name"));
     mpassword.setText(in.getStringExtra("password"));
    }
}
