package com.example.admin.recyclerview;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.nio.file.Path;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnDeleteListener
{

    RecyclerView mRecyclerView;
    MyAdapter mAdapter;

    TextView txtName;
    SwipeRefreshLayout swipeRefresh;

    ArrayList<String> arrayList = new ArrayList<>();
    int page=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefresh = (SwipeRefreshLayout)findViewById(R.id.swipelayout);

        txtName = (TextView)findViewById(R.id.activity_main_name);

        mRecyclerView = (RecyclerView)findViewById(R.id.activity_man_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList.addAll(setData(0));

        mAdapter = new MyAdapter(this, arrayList, this);
        mRecyclerView.setAdapter(mAdapter);

       loadmore();

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                page = 0;
                arrayList.clear();
                arrayList.addAll(setData(0));
                mAdapter.notifyDataSetChanged();
                loadmore();
                swipeRefresh.setRefreshing(false);
            }
        });

    }

    private ArrayList<String> setData(int page){
         ArrayList<String> a= new ArrayList<>();
         for(int i=0;i<10;i++){
             a.add("ABC"+page+i);
         }
        return a;
    }

    @Override
    public void onDelete(String data) {
        txtName.setText(data);
    }

    private void loadmore(){
        mRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener((LinearLayoutManager)
                mRecyclerView.getLayoutManager()){
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                arrayList.addAll(setData(page));
                mAdapter.notifyDataSetChanged();
            }

        });
    }
}
