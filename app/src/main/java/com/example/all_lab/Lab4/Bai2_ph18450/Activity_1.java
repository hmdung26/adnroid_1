package com.example.all_lab.Lab4.Bai2_ph18450;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.all_lab.R;

public class Activity_1 extends AppCompatActivity {
private EditText edtMuonMua;
private Button btnUMua;
private TextView txtGiaSp;
    private  ActivityResultLauncher<Intent> setSanPham =  registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == 1){
                Intent intent = result.getData();
                if (intent != null){
                    Bundle bundle = intent.getExtras();
                    String getSP = bundle.getString("BaoGia");
                    txtGiaSp.setText(getSP);
                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_lab4_2);


        edtMuonMua = findViewById(R.id.edtBenMua);
        btnUMua = findViewById(R.id.btnUMua);
        txtGiaSp = findViewById(R.id.txtGiaSp);

        btnUMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_1.this,Activity_2.class);
                i.putExtra("SpMua",edtMuonMua.getText().toString());
                setSanPham.launch(i);

            }
        });



    }
}