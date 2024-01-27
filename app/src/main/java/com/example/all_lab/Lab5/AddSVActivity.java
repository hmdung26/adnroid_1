package com.example.all_lab.Lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.all_lab.R;

import java.util.ArrayList;

public class AddSVActivity extends AppCompatActivity {
     private Spinner schoolSpiner;
     private EditText edtNameSV,edtDiaChiSV;
     private Button btnSUMMIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_svactivity);

        ArrayList<SchoolModel> lst = new ArrayList<>();
        lst.add(new SchoolModel(R.drawable.ha_noi,"Hà Nội"));
        lst.add(new SchoolModel(R.drawable.ho_chi_minh,"Hồ Chí Minh"));
        lst.add(new SchoolModel(R.drawable.da_nang,"Đà Nẵng"));
        lst.add(new SchoolModel(R.drawable.can_tho,"Cần Thơ"));
        lst.add(new SchoolModel(R.drawable.tay_nguyen,"Tây Nguyên"));

        schoolSpiner = findViewById(R.id.spinerScloll);
        edtDiaChiSV = findViewById(R.id.edtDiaChiSV);
        edtNameSV = findViewById(R.id.edtNameSV);
        btnSUMMIT = findViewById(R.id.btnSUMMIT);
        SchoolSpinnerAdapter_dunghmph18450 schoolSpinnerAdapterDunghmph18450 = new SchoolSpinnerAdapter_dunghmph18450(this,lst);
        schoolSpiner.setAdapter(schoolSpinnerAdapterDunghmph18450);


        btnSUMMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtNameSV.getText().toString();
                String diachi = edtDiaChiSV.getText().toString();
                String coso = ((SchoolModel) schoolSpiner.getSelectedItem()).getName();

                StudenModelph18450 st = new StudenModelph18450(coso,name,diachi);
                Intent i = new Intent();
                i.putExtra("newSt",st);
                setResult(1,i);
                finish();
            }
        });

    }
}