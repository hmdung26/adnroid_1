package com.example.all_lab.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.all_lab.R;

public class Bai2 extends AppCompatActivity {
 private EditText edtName,edtMaSV,edtAge;
 private TextView txtMess;
 private RadioButton radioMale,radioFMale;
 private CheckBox boxDaBong,boxGame;
 private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);


        edtName = findViewById(R.id.edtName);
        edtMaSV = findViewById(R.id.edtMaSV);
        edtAge = findViewById(R.id.edtAge);

        txtMess = findViewById(R.id.txtMess);

        radioMale = findViewById(R.id.radioMale);
        radioFMale = findViewById(R.id.radioFMale);

        boxDaBong = findViewById(R.id.boxDaBong);
        boxGame = findViewById(R.id.boxGame);

        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString().trim();
                String msv = edtMaSV.getText().toString().trim();
                String age = edtAge.getText().toString().trim();

                String gender = radioMale.isChecked()? radioMale.getText().toString() : radioFMale.getText().toString();
                String hobby = "";
                if (boxDaBong.isChecked()) {
                    hobby += " Đá bóng";
                }
                if (boxGame.isChecked()) {
                    hobby += " Chơi game";
                }

                txtMess.setText("Họ tên: " + name +
                        "\nMã SV: " + msv +
                        "\nTuổi: " + age +
                        "\nGiới tính: " + gender  +
                        "\nSở thích: " + hobby);

            }
        });

    }
}