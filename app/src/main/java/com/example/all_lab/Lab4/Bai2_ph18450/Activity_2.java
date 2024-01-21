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

public class Activity_2 extends AppCompatActivity {
private TextView txtSp;
private EditText edtBenBan;
private Button btnBaoGia;

    private  ActivityResultLauncher<Intent> setGiaSP =  registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == 1){
                Intent intent = result.getData();
                if (intent != null){
                    Bundle bundle = intent.getExtras();
                    String getSP = bundle.getString("SpMua");
                    txtSp.setText(getSP);
                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_lab4_2);

        txtSp = findViewById(R.id.txtSp);
        edtBenBan = findViewById(R.id.edtBenBan);
        btnBaoGia = findViewById(R.id.btnUBanHang);

        String getSPP = getIntent().getStringExtra("SpMua");
        txtSp.setText(getSPP);


        btnBaoGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("BaoGia",edtBenBan.getText().toString());
                i.putExtras(bundle);
                setResult(1,i);
                finish();

            }
        });
    }
}