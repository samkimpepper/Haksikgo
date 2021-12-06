package com.example.hcgologin;

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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MakePartyActivity extends AppCompatActivity {
    String address;
    TextView tvmakepartypagetitle;
    EditText edmakepartytitle, edmakepartyMaxp, edmakepartyspace, edmakepartyEtc;
    ImageButton imgbmakepartypage;
    Button btnMakeParty, btnmaps;

    private ActivityResultLauncher<Intent> resultLauncher= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();
                address = intent.getStringExtra("address");
                Toast.makeText(MakePartyActivity.this, address, Toast.LENGTH_SHORT).show();
                putAddress(address);
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_party);




        tvmakepartypagetitle = findViewById(R.id.tv_make_partypage_title);
        edmakepartytitle = findViewById(R.id.ed_makepartytitle);
        edmakepartyMaxp = findViewById(R.id.ed_makepartyMaxp);
        edmakepartyspace = findViewById(R.id.ed_makepartyspace);
        edmakepartyEtc = findViewById(R.id.ed_makepartyEtc);
        imgbmakepartypage = findViewById(R.id.imgb_makepartypage);
        btnMakeParty = findViewById(R.id.btn_MakeParty);
        btnmaps = findViewById(R.id.btn_maps);

        Intent getMakeParty = getIntent();

        int page = getMakeParty.getIntExtra("page",20);

        //페이지 이름 정하기
        if(page == 20){
            tvmakepartypagetitle.setText("학식");
        }else if(page == 30){
            tvmakepartypagetitle.setText("일번가");
        }

        //지도버튼
        btnmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MapIntent = new Intent(MakePartyActivity.this,MapsActivity.class);
                resultLauncher.launch(MapIntent);
            }
        });



        //파티만들기 버튼
        btnMakeParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String [] makepartyarr = new String[5];

                makepartyarr[0] = tvmakepartypagetitle.getText().toString();
                makepartyarr[1] = edmakepartytitle.getText().toString();
                makepartyarr[2] = edmakepartyMaxp.getText().toString();
                makepartyarr[3] = edmakepartyspace.getText().toString();
                makepartyarr[4] = edmakepartyEtc.getText().toString();

                Intent MakeParty = new Intent(MakePartyActivity.this, PartyrunActivity.class);
                MakeParty.putExtra("arr",makepartyarr);
                MakeParty.putExtra("invisible",4);
                startActivity(MakeParty);
            }
        });

        //x버튼 뒤로가기
        imgbmakepartypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void putAddress(String add) {
        edmakepartyspace.setText(add);
    }
}