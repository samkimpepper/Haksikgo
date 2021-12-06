package com.example.hcgologin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JoinBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_b);

        TextView tvinpartypagetitle, tvinpartypagename, tvinpartypagepeo, tvinpartypagespace, tvinpartypageindex;
        LinearLayout llp1,llp2,llp3,llp4;
        Button btngogogo;
        ImageButton imgbin;

        tvinpartypagetitle = findViewById(R.id.tv_make_partypage_title);
        tvinpartypagename = findViewById(R.id.tv_in_partypage_name);
        tvinpartypagepeo = findViewById(R.id.tv_in_partypage_peo);
        tvinpartypagespace = findViewById(R.id.tv_in_partypage_space);
        tvinpartypageindex = findViewById(R.id.tv_in_partypage_index);
        llp1 = findViewById(R.id.ll_p1);
        llp2 = findViewById(R.id.ll_p2);
        llp3 = findViewById(R.id.ll_p3);
        llp4 = findViewById(R.id.ll_p4);
        btngogogo = findViewById(R.id.btn_gogogo);
        imgbin = findViewById(R.id.imgb_makepartypage);


        Intent asd = getIntent();
        int page = asd.getIntExtra("page",10);
        int list = asd.getIntExtra("list",1);
        int position = asd.getIntExtra("pos",0);

        // 배열만들기!
        String [] arr = new String[5];
        int invisible = 1;

        //페이지 구분 (10 = 메인화면, 20 = 학식, 30 = 일번가)
        //메인화면 -> 파티참여 시작
        if(page == 10){
            if(position == 0){
                tvinpartypagetitle.setText("학식");
                tvinpartypagename.setText("라면ㄱㄱ");
                tvinpartypagepeo.setText("(2/4)");
                tvinpartypagespace.setText("위치 : 학생식당 앞");
                tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                llp3.setVisibility(View.GONE);
                llp4.setVisibility(View.GONE);
                invisible = 2;

            }else if(position == 1){
                tvinpartypagetitle.setText("안양일번가");
                tvinpartypagename.setText("고기드실분");
                tvinpartypagepeo.setText("(3/4)");
                tvinpartypagespace.setText("위치 : 홍지관 앞");
                tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                llp4.setVisibility(View.GONE);
                invisible = 1;
            }else if(position == 2){
                tvinpartypagetitle.setText("안양일번가");
                tvinpartypagename.setText("국밥땡긴다");
                tvinpartypagepeo.setText("(2/4)");
                tvinpartypagespace.setText("위치 : 홍지관 앞");
                tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                llp3.setVisibility(View.GONE);
                llp4.setVisibility(View.GONE);
                invisible = 2;
            }else if(position == 3){
                tvinpartypagetitle.setText("안양일번가");
                tvinpartypagename.setText("구경하실분");
                tvinpartypagepeo.setText("(2/4)");
                tvinpartypagespace.setText("위치 : 홍지관 앞");
                tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                llp3.setVisibility(View.GONE);
                llp4.setVisibility(View.GONE);
                invisible = 2;
            }
        //메인화면 -> 파티참여 끝    !    학식목록 -> 파티참여 시작
        }else if(page == 20) {
            if(list == 1){
                if (position == 0) {
                    tvinpartypagetitle.setText("학식");
                    tvinpartypagename.setText("학-식");
                    tvinpartypagepeo.setText("(1/4)");
                    tvinpartypagespace.setText("위치 : 전산관 1층");
                    tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                    llp2.setVisibility(View.GONE);
                    llp3.setVisibility(View.GONE);
                    llp4.setVisibility(View.GONE);
                    invisible = 3;
                } else if (position == 1) {
                    tvinpartypagetitle.setText("학식");
                    tvinpartypagename.setText("먹-자");
                    tvinpartypagepeo.setText("(2/4)");
                    tvinpartypagespace.setText("위치 : 임곡관 정문 앞");
                    tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                    llp3.setVisibility(View.GONE);
                    llp4.setVisibility(View.GONE);
                    invisible = 2;
                } else if (position == 2) {
                    tvinpartypagetitle.setText("학식");
                    tvinpartypagename.setText("오늘 학식 ㄱ?");
                    tvinpartypagepeo.setText("(3/4)");
                    tvinpartypagespace.setText("위치 : 스마트 스테이션 앞");
                    tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                    llp4.setVisibility(View.GONE);
                    invisible = 1;
                }
            }else if(list == 2){
                if (position == 0) {
                    tvinpartypagetitle.setText("학식");
                    tvinpartypagename.setText("매점 쏜다");
                    tvinpartypagepeo.setText("(2/4)");
                    tvinpartypagespace.setText("위치 : 구내식당 매점 앞");
                    tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                    llp3.setVisibility(View.GONE);
                    llp4.setVisibility(View.GONE);
                    invisible = 2;
                } else if (position == 1) {
                    tvinpartypagetitle.setText("학식");
                    tvinpartypagename.setText("너만 오면 출발");
                    tvinpartypagepeo.setText("(3/4)");
                    tvinpartypagespace.setText("위치 : 임곡관 정문 앞");
                    tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                    llp4.setVisibility(View.GONE);
                    invisible = 1;
                }

            }
            //학식목록 -> 파티참여 끝    !    일번가목록 -> 파티참여 시작
        }else if(page == 30){
            if(list == 1) {
                if (position == 0) {
                    tvinpartypagetitle.setText("일번가");
                    tvinpartypagename.setText("맥도날드ㄱ 차있음");
                    tvinpartypagepeo.setText("(2/4)");
                    tvinpartypagespace.setText("위치 : 자동차관 앞");
                    tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                    llp3.setVisibility(View.GONE);
                    llp4.setVisibility(View.GONE);
                    invisible = 2;
                } else if (position == 1) {
                    tvinpartypagetitle.setText("일번가");
                    tvinpartypagename.setText("롯데리아 가실분");
                    tvinpartypagepeo.setText("(3/4)");
                    tvinpartypagespace.setText("위치 : 스마트 스테이션 앞");
                    tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                    llp4.setVisibility(View.GONE);
                    invisible = 1;
                }
            }else if(list == 2){
                if (position == 0) {
                    tvinpartypagetitle.setText("일번가");
                    tvinpartypagename.setText("돈까스어때");
                    tvinpartypagepeo.setText("(2/4)");
                    tvinpartypagespace.setText("위치 : 롯데리아 앞");
                    tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                    llp3.setVisibility(View.GONE);
                    llp4.setVisibility(View.GONE);
                    invisible = 2;
                } else if (position == 1) {
                    tvinpartypagetitle.setText("일번가");
                    tvinpartypagename.setText("수업 끝난사람 술ㄱ?");
                    tvinpartypagepeo.setText("(3/4)");
                    tvinpartypagespace.setText("위치 : 안양억 1번출구");
                    tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                    llp4.setVisibility(View.GONE);
                    invisible = 1;
                } else if (position == 2) {
                    tvinpartypagetitle.setText("일번가");
                    tvinpartypagename.setText("회덮밥 먹을분");
                    tvinpartypagepeo.setText("(1/4)");
                    tvinpartypagespace.setText("위치 : 전산관 1층");
                    tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                    llp2.setVisibility(View.GONE);
                    llp3.setVisibility(View.GONE);
                    llp4.setVisibility(View.GONE);
                    invisible = 3;
                } else if (position == 3) {
                    tvinpartypagetitle.setText("일번가");
                    tvinpartypagename.setText("고칸 어때요");
                    tvinpartypagepeo.setText("(1/4)");
                    tvinpartypagespace.setText("위치 : 홍지관 앞");
                    tvinpartypageindex.setText("누구보다 빠르게 밥만 먹고 도망갑니다! \n알아서 참여하세요");
                    llp2.setVisibility(View.GONE);
                    llp3.setVisibility(View.GONE);
                    llp4.setVisibility(View.GONE);
                    invisible = 3;
                }

            }
        }   //일번가목록 -> 파티참여 끝

            arr[0] = tvinpartypagetitle.getText().toString();
            arr[1] = tvinpartypagename.getText().toString();
            arr[2] = tvinpartypagepeo.getText().toString();
            arr[3] = tvinpartypagespace.getText().toString();
            arr[4] = tvinpartypageindex.getText().toString();

            int thisInvisible = invisible;
        btngogogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent runIntent = new Intent(JoinBActivity.this, PartyrunActivity.class);
                runIntent.putExtra("arr",arr);
                runIntent.putExtra("invisible", thisInvisible);
                startActivity(runIntent);
            }
        });
        imgbin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}