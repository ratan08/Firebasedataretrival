package com.group.firebasedataretrival;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView name,email,number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.viewName);
        email = findViewById(R.id.viewEmail);
        number = findViewById(R.id.viewNumber);
        Intent intent = getIntent();

        String a= intent.getStringExtra("key");
        name.setText(a);
    }
}