package com.example.hcgologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    TextView tv_welcome;
    Button btn_gomain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tv_welcome = findViewById(R.id.tv_welcome);
        btn_gomain = findViewById(R.id.btn_gomain);

        Intent intent = getIntent();
        tv_welcome.setText(intent.getStringExtra("id") + "님, 환영합니다!");

        btn_gomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(WelcomeActivity.this, MainMenuActivity.class);
                startActivity(intent2);
            }
        });
    }
}