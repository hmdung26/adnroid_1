package com.example.all_lab.Lab4.Bai1_ph18450;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.all_lab.R;

public class Activity2 extends AppCompatActivity {
private Button btnnextac1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_lab4_1);
        btnnextac1 = findViewById(R.id.btnnextac1);

        btnnextac1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this,Activity1.class));
            }
        });

    }
}