package com.example.hcgologin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ConerItemView extends LinearLayout {
    TextView tvName, tvPlace, tvPeople, tvTime;
    //ImageView imageView;

    public ConerItemView(Context context){
        super(context);
        init(context);
    }

    public ConerItemView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.coner,this, true);

        tvName = findViewById(R.id.tv_WhereParty);
        tvPlace = findViewById(R.id.tv_Place1);
        tvPeople = findViewById(R.id.tvPeople);
        tvTime = findViewById(R.id.tvTime);
        //imageView = findViewById(R.id.imageView);
    }

    public void setName(String name){
        tvName.setText(name);
    }
    public void setPlace(String place){
        tvPlace.setText(place);
    }
    public void setPeople(String people){
        tvPeople.setText(people);
    }
    public void setTime(String time){
        tvTime.setText(time);
    }

//    public void setImage(int resld){
//        imageView.setImageResource(resld);
//    }
}
