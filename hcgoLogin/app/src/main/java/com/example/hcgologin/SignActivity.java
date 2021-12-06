package com.example.hcgologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        Button btngoMain;
        EditText edID, edPW;

        btngoMain = findViewById(R.id.btn_goMain);
        edID = findViewById(R.id.ed_ID);
        edPW = findViewById(R.id.ed_PW);

        btngoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(SignActivity.this,MainMenuActivity.class);
                Intent intent = new Intent(SignActivity.this, WelcomeActivity.class);
                String strId = edID.getText().toString();
                intent.putExtra("id", strId);
                startActivity(intent);
            }
        });

    }
}