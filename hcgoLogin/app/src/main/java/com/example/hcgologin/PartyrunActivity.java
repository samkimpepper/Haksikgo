package com.example.hcgologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PartyrunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partyrun);

        TextView tvrunpartypagetitle, tvrunpartypagename, tvrunpartypagepeo, tvrunpartypagespace, tvrunpartypageindex;
        LinearLayout llrunp1,llrunp2,llrunp3,llrunp4;
        Button btnrunrunrun;
        TextView tvmakepartyLast, tvMyName, tvMyName2, tvMyName3;
        ImageButton imgb_run;

        tvrunpartypagetitle = findViewById(R.id.tv_run_partypage_title);
        tvrunpartypagename = findViewById(R.id.tv_run_partypage_name);
        tvrunpartypagepeo = findViewById(R.id.tv_run_partypage_peo);
        tvrunpartypagespace = findViewById(R.id.tv_run_partypage_space);
        tvrunpartypageindex = findViewById(R.id.tv_run_partypage_index);
        llrunp1 = findViewById(R.id.ll_runp4);
        llrunp2 = findViewById(R.id.ll_runp2);
        llrunp3 = findViewById(R.id.ll_runp3);
        llrunp4 = findViewById(R.id.ll_runp4);
        btnrunrunrun = findViewById(R.id.btn_runrunrun);
        tvmakepartyLast = findViewById(R.id.tv_makepartyLast);
        tvMyName = findViewById(R.id.tv_Myname);
        tvMyName2 = findViewById(R.id.tv_MyName2);
        tvMyName3 = findViewById(R.id.tv_MyName3);
        imgb_run = findViewById(R.id.imgb_run);



        Intent getrun = getIntent();
        String []allindex = getrun.getExtras().getStringArray("arr");
        int invisible = getrun.getIntExtra("invisible",1);

        //textview 세팅
        tvrunpartypagetitle.setText(allindex[0]);
        tvrunpartypagename.setText(allindex[1]);
        tvrunpartypagespace.setText(allindex[3]);
        tvrunpartypageindex.setText(allindex[4]);

        //파티원수 수정
        if(invisible == 1){
            tvrunpartypagepeo.setText("(4 / 4)");
            tvMyName3.setText("김요환 (남)");
        }else if(invisible == 2){
            llrunp4.setVisibility(View.GONE);
            tvrunpartypagepeo.setText("(3 / 4)");
            tvMyName2.setText("김요환 (남)");
        }else if(invisible == 3){
            llrunp3.setVisibility(View.GONE);
            llrunp4.setVisibility(View.GONE);
            tvrunpartypagepeo.setText("(2 / 4)");
            tvMyName.setText("김요환 (남)");
        }else if (invisible == 4){
            llrunp2.setVisibility(View.GONE);
            llrunp3.setVisibility(View.GONE);
            llrunp4.setVisibility(View.GONE);
            tvrunpartypagespace.setText("위치 : " + allindex[3]);
            tvrunpartypagepeo.setText("(1 / "+allindex[2]+")");
            tvmakepartyLast.setText("김요환 (남)");
        }

        imgb_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnrunrunrun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}