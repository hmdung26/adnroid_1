package com.example.all_lab.Lab5;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.example.all_lab.Lab4.Bai3_ph18450.SignIn_Activity;
import com.example.all_lab.R;

import java.util.ArrayList;

public class DSSVienActivity extends AppCompatActivity {
    private ListView listView;
    private Button btnAddSV;
    private ArrayList<StudenModelph18450> lstSt;
    private ListStudentApdaterph18450 adapter;
    private Toolbar toolbar;
    private EditText editTextSearch;
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
//        btnAddSV = findViewById(R.id.btnAddSV);
        editTextSearch = findViewById(R.id.editTextSearch);
        toolbar = findViewById(R.id.toobar);
        setSupportActionBar(toolbar);

//        btnAddSV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(DSSVienActivity.this , AddSVActivity.class);
//               getnewSt.launch(i);
//
//            }
//        });

        toolbar.setOnClickListener(v -> {
            editTextSearch.setVisibility(View.VISIBLE);
            editTextSearch.requestFocus();

        });
        if (lstSt == null) {
            lstSt = new ArrayList<>();
        }
        adapter = new ListStudentApdaterph18450(this, lstSt);
        listView.setAdapter(adapter);

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s.toString());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if (item.getItemId() == R.id.action_add_student){

           Intent i = new Intent(DSSVienActivity.this , AddSVActivity.class);
              getnewSt.launch(i);
           Toast.makeText(getApplicationContext(),"Thêm mới",Toast.LENGTH_LONG).show();
       } else if (item.getItemId() == R.id.action_logout) {
           Intent i = new Intent(DSSVienActivity.this , SignIn_Activity.class);

           startActivity(i);
           Toast.makeText(getApplicationContext(),"Đăng xuất thành công",Toast.LENGTH_LONG).show();
       }


        return super.onOptionsItemSelected(item);
    }
}