package com.example.hcgologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin, btnJoin;

        btnLogin = findViewById(R.id.btn_Login);
        btnJoin = findViewById(R.id.btn_Join);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignIntent = new Intent(MainActivity.this,SignActivity.class);
                startActivity(SignIntent);
            }
        });

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent JoinIntent = new Intent(MainActivity.this,JoinActivity.class);
                startActivity(JoinIntent);
            }
        });

    }
}