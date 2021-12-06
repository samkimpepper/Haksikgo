package com.example.hcgologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class MainMenuActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button btnInParty, btnOutParty;
        TextView tvToday,tvTomorrow, tvTdMainFood,tvTdSubFood, tvTmMainFood,tvTmSubFood;


        btnInParty = findViewById(R.id.btn_InParty);
        btnOutParty = findViewById(R.id.btn_OutParty);
        tvToday = findViewById(R.id.tv_Today);
        tvTomorrow = findViewById(R.id.tv_Tomorrow);
        tvTdMainFood = findViewById(R.id.tv_TdMainFood);
        tvTdSubFood = findViewById(R.id.tv_TdSubFood);
        tvTmMainFood = findViewById(R.id.tv_TmMainFood);
        tvTmSubFood = findViewById(R.id.tv_TmSubFood);

        ListView lvLiveParty;
        lvLiveParty = findViewById(R.id.lv_LiveParty);

        //실시간 파티 내용
        lvAdapter adapter = new lvAdapter();
        adapter.addItem(new lvitem("라면 ㄱㄱ","(2/4)","학식"));
        adapter.addItem(new lvitem("고기드실분","(3/4)","안양 일번가"));
        adapter.addItem(new lvitem("국밥땡긴다","(2/4)","안양 일번가"));
        adapter.addItem(new lvitem("구경하실분","(2/4)","안양 일번가"));
        lvLiveParty.setAdapter(adapter);

        //리스트뷰 클릭 이벤트
        lvLiveParty.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent a = new Intent(MainMenuActivity.this, JoinBActivity.class);
                a.putExtra("pos",position);
                a.putExtra("page",10);
                startActivity(a);
            }
        });


        //날짜
        Calendar cal = Calendar.getInstance();

        int tdMonth, tdDays, tdDayofWeek, tmMonth, tmDays, tmDayofWeek, endofMonth;
        String sDayOfWeek = null, dDayOfWeek = null;

        tdMonth = cal.get(Calendar.MONTH);
        tdDays = cal.get(Calendar.DATE);
        tdDayofWeek = cal.get(Calendar.DAY_OF_WEEK);
        endofMonth = cal.getActualMaximum(Calendar.DATE);

        tdMonth +=1; // 1더해야 정상 값 출력
        tmMonth = tdMonth;
        tmDays = tdDays+1;

        if(tmDays == endofMonth){
            tmMonth = tdMonth+1;
            tmDays = 1;
        }
        tmDayofWeek = tdDayofWeek+1;
        if(tmDayofWeek == 8){
            tmDayofWeek = 1;
        }
        if ( tdDayofWeek == 1 )sDayOfWeek="일요일";
        else if ( tdDayofWeek == 2 )sDayOfWeek="월요일";
        else if ( tdDayofWeek == 3 )sDayOfWeek="화요일";
        else if ( tdDayofWeek == 4 )sDayOfWeek="수요일";
        else if ( tdDayofWeek == 5 )sDayOfWeek="목요일";
        else if ( tdDayofWeek == 6 )sDayOfWeek="금요일";
        else if ( tdDayofWeek == 7 )sDayOfWeek="토요일";

        if ( tmDayofWeek == 1 )dDayOfWeek="일요일";
        else if ( tmDayofWeek == 2 )dDayOfWeek="월요일";
        else if ( tmDayofWeek == 3 )dDayOfWeek="화요일";
        else if ( tmDayofWeek == 4 )dDayOfWeek="수요일";
        else if ( tmDayofWeek == 5 )dDayOfWeek="목요일";
        else if ( tmDayofWeek == 6 )dDayOfWeek="금요일";
        else if ( tmDayofWeek == 7 )dDayOfWeek="토요일";

        tvToday.setText(tdMonth+"월" + " " + tdDays + "일" +  "  " + sDayOfWeek);
        tvTomorrow.setText(tmMonth+"월" + " " + tmDays + "일" +  "  " + dDayOfWeek);



        //음식 (임시로 그냥 setText로 함)
        tvTdMainFood.setText("치킨마요덮밥");
        tvTdSubFood.setText("쿨피스");
        tvTmMainFood.setText("티본 스테이크");
        tvTmSubFood.setText("크림 파스타");

        //btn
        btnInParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent InIntent = new Intent(MainMenuActivity.this, WherePartyActivity.class);
                InIntent.putExtra("whereparty","학식 파티 목록");
                InIntent.putExtra("place1","코너 1");
                InIntent.putExtra("place2","코너 2");
                InIntent.putExtra("P",1);
                startActivity(InIntent);
            }
        });

        btnOutParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OutIntent = new Intent(MainMenuActivity.this, WherePartyActivity.class);
                OutIntent.putExtra("whereparty","일번가 파티 목록");
                OutIntent.putExtra("place1","햄버거");
                OutIntent.putExtra("place2","일식");
                OutIntent.putExtra("P",2);
                startActivity(OutIntent);
            }
        });







    }
    //(메인 끝)


    //리스트뷰 클레스(어뎁터)
    class lvAdapter extends BaseAdapter  {
        ArrayList<lvitem> items = new ArrayList<lvitem>();

        @Override
        public int getCount(){
            return items.size();
        }

        public void addItem(lvitem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position){
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            lvItemView lvItemView = null;
            if(convertView == null){
                lvItemView = new lvItemView(getApplicationContext());
            }else{
                lvItemView = (lvItemView)convertView;
            }
            lvitem item = items.get(position);
            lvItemView.setTvLPName(item.getName());
            lvItemView.setTvLPPeople(item.getPeople());
            lvItemView.setTvLPComment(item.getComment());
            return lvItemView;
        }



    }

}