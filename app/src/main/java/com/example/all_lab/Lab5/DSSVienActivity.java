package com.example.all_lab.Lab5;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.all_lab.R;

import java.util.ArrayList;

public class DSSVienActivity extends AppCompatActivity {
    private ListView listView;
    private Button btnAddSV;
    private ArrayList<StudenModelph18450> lstSt;
    private ListStudentApdaterph18450 adapter;

    private ActivityResultLauncher<Intent> getnewSt =  registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == 1){
                Intent data = result.getData();
                StudenModelph18450 stnew = (StudenModelph18450) data.getSerializableExtra("newSt");
                Log.i("lỗi", "" + stnew.getName());
                if (stnew != null){

                    if (lstSt == null) {
                        lstSt = new ArrayList<>();
                    }
                    lstSt.add(stnew);
                    adapter = new ListStudentApdaterph18450(DSSVienActivity.this, lstSt);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(getApplicationContext(),"Không có dữ liệu được thêm mới",Toast.LENGTH_LONG).show();}

            }
            else {
                Toast.makeText(getApplicationContext(),"Không lấy được",Toast.LENGTH_LONG).show();}
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dssvien);
        listView = findViewById(R.id.lstDSSinhVien);
        btnAddSV = findViewById(R.id.btnAddSV);

        btnAddSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DSSVienActivity.this , AddSVActivity.class);
               getnewSt.launch(i);

            }
        });
        if (lstSt == null) {
            lstSt = new ArrayList<>();
        }
        adapter = new ListStudentApdaterph18450(this, lstSt);
        listView.setAdapter(adapter);

    }





}