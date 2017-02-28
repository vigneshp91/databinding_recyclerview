package com.example.vignesh.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
       // mRecyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerview.setAdapter(new RecyclerViewAdapter(this,getData()));
    }

    private ArrayList<SportViewModel> getData(){
        ArrayList<SportViewModel> data=new ArrayList<>();
        SportViewModel model =new SportViewModel();
        model.content="Football";
        model.resid.set(R.mipmap.ic_launcher);
        data.add(model);

        model =new SportViewModel();
        model.content="Football1";
        model.resid.set(R.mipmap.ic_launcher);
        data.add(model);

        model =new SportViewModel();
        model.content="Football2";
        model.resid.set(R.mipmap.ic_launcher);
        data.add(model);

        return data;
    }
}
