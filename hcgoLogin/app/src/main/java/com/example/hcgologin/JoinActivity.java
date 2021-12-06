package com.example.hcgologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        Button btnCreatId;

        btnCreatId = findViewById(R.id.btn_CreatId);

        btnCreatId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CreatIdIntent = new Intent(JoinActivity.this, MainActivity.class);
                Toast.makeText(getApplicationContext(),"회원가입이 되었습니다",Toast.LENGTH_SHORT).show();
                startActivity(CreatIdIntent);
            }
        });

    }
}