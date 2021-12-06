package com.example.hcgologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class WherePartyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whereparty);

        TextView tvWhereParty, tvPlace1, tvPlace2;
        ListView listV, listV1;
        FloatingActionButton fabtnmakeparty;

        tvWhereParty = findViewById(R.id.tv_WhereParty);
        tvPlace1 = findViewById(R.id.tv_Place1);
        tvPlace2 = findViewById(R.id.tv_Place2);
        listV = findViewById(R.id.listView);
        listV1 = findViewById(R.id.listView2);
        fabtnmakeparty = findViewById(R.id.favbtn_makeparty);


        //인텐트
        Intent getIntent = getIntent();
        String WherePlace = getIntent.getStringExtra("whereparty");
        String place1 = getIntent.getStringExtra("place1");
        String place2 = getIntent.getStringExtra("place2");
        int PartyDisplay = getIntent.getIntExtra("P",0);
        //파티이름
        tvWhereParty.setText(WherePlace);
        tvPlace1.setText(place1);
        tvPlace2.setText(place2);

        if(PartyDisplay == 1){
            //학식 페이지
            ListView listView = findViewById(R.id.listView);
            ConerAdapter adapter = new ConerAdapter();
            adapter.addItem(new ConerItem("학-식", "전산관 1층", R.drawable.ic_launcher_background, "(1/4)", "10분남음"));
            adapter.addItem(new ConerItem("먹-자", "임곡관 정문 앞", R.drawable.ic_launcher_background, "(2/4)", "8분남음"));
            adapter.addItem(new ConerItem("오늘 학식 ㄱ?", "스마트 스테이션 앞", R.drawable.ic_launcher_background, "(3/4)", "4분 남음"));
            listView.setAdapter(adapter);

            ListView listView2 = findViewById(R.id.listView2);
            ConerAdapter adapter2 = new ConerAdapter();
            adapter2.addItem(new ConerItem("매점 쏜다", "구내식당 매점 앞", R.drawable.ic_launcher_background, "(2/4)", "6분남음"));
            adapter2.addItem(new ConerItem("너만 오면 출발", "구내식당 정문 앞", R.drawable.ic_launcher_background, "(3/4)", "2분남음"));
            listView2.setAdapter(adapter2);
        }else if(PartyDisplay == 2){
            //일번가 페이지
            ListView listView = findViewById(R.id.listView);
            ConerAdapter adapter = new ConerAdapter();
            adapter.addItem(new ConerItem("맥도날드ㄱ 차있음", "자동차관 앞", R.drawable.ic_launcher_background, "(2/4)", "8분남음"));
            adapter.addItem(new ConerItem("롯데리아 가실분", "스마트 스테이션 앞", R.drawable.ic_launcher_background, "(3/4)", "4분 남음"));
            listView.setAdapter(adapter);

            ListView listView2 = findViewById(R.id.listView2);
            ConerAdapter adapter2 = new ConerAdapter();

            adapter2.addItem(new ConerItem("돈까스어때", "롯데리아 앞", R.drawable.ic_launcher_background, "(2/4)", "6분남음"));
            adapter2.addItem(new ConerItem("수업 끝난사람 술ㄱ?", "안양억 1번출구", R.drawable.ic_launcher_background, "(3/4)", "2분남음"));
            adapter2.addItem(new ConerItem("회덮밥 먹을분", "전산관 1층", R.drawable.ic_launcher_background, "(1/4)", "10분남음"));
            adapter2.addItem(new ConerItem("고칸 어때요", "홍지관 앞", R.drawable.ic_launcher_background, "(1/4)", "7분남음"));
            listView2.setAdapter(adapter2);
        }


        //page = 20 학식, page = 30 일번가
        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent a = new Intent(WherePartyActivity.this, JoinBActivity.class);
                a.putExtra("pos",position);
                a.putExtra("list",1);
                if(PartyDisplay == 1){
                    a.putExtra("page",20);
                }else if(PartyDisplay == 2){
                    a.putExtra("page",30);
                }

                startActivity(a);
            }
        });
        listV1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent a = new Intent(WherePartyActivity.this, JoinBActivity.class);
                a.putExtra("pos",position);
                a.putExtra("list",2);
                if(PartyDisplay == 1){
                    a.putExtra("page",20);
                }else if(PartyDisplay == 2){
                    a.putExtra("page",30);
                }
                startActivity(a);
            }
        });

        fabtnmakeparty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fabtnIntent = new Intent(WherePartyActivity.this, MakePartyActivity.class);
                if(PartyDisplay == 1){
                    fabtnIntent.putExtra("page",20);
                }else if(PartyDisplay == 2){
                    fabtnIntent.putExtra("page",30);
                }
                startActivity(fabtnIntent);
            }
        });



    }
    class ConerAdapter extends BaseAdapter {
        ArrayList<ConerItem> items = new ArrayList<ConerItem>();

        @Override
        public int getCount() {
            return items.size();
        }
        public void addItem(ConerItem item){
            items.add(item);
        }
        public Object getItem(int position){
            return items.get(position);
        }
        public long getItemId(int position){
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            ConerItemView conerItemView = null;

            if(convertView==null){
                conerItemView = new ConerItemView(getApplicationContext());
            }else{
                conerItemView = (ConerItemView)convertView;
            }
            ConerItem item = items.get(position);
            conerItemView.setName(item.getName());
            conerItemView.setPlace(item.getPlace());
            conerItemView.setPeople(item.getPeople());
            conerItemView.setTime(item.getTime());
            //conerItemView.setImage(item.getResld());
            return conerItemView;
        }
    }
}