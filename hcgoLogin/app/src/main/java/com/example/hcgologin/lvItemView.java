package com.example.hcgologin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class lvItemView extends LinearLayout {

    TextView tvLPName,tvLPPeople, tvLPComment;

    public lvItemView(Context context) {
        super(context);
        init(context);
    }

    public lvItemView(Context context, @Nullable AttributeSet attrs){
        super(context,attrs);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.main_memu_ltem_list,this,true);

        tvLPName = findViewById(R.id.tv_LPName);
        tvLPPeople = findViewById(R.id.tv_LPPeople);
        tvLPComment = findViewById(R.id.tv_LPComment);
    }

    public void setTvLPName(String name){
        tvLPName.setText(name);
    }

    public void setTvLPPeople(String people){
        tvLPPeople.setText(people);
    }

    public void setTvLPComment(String comment){
        tvLPComment.setText(comment);
    }

}
