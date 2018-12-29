package p.pklovestar.bitp_salong;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import p.pklovestar.bitp_salong.Adapter.Adapter2;
import p.pklovestar.bitp_salong.Adapter.MyAdapter;
import p.pklovestar.bitp_salong.Salon.ListSalon;
import p.pklovestar.bitp_salong.Salon.Relationships;
import p.pklovestar.bitp_salong.Salon.Service;
import p.pklovestar.bitp_salong.Salon.TTSalon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    private APIRequest mAPIRequest;
    private Adapter2 myAdapter;
    List<TTSalon> mylist;
    List<Service> mylist2;
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mAPIRequest = ApiUtils.getAPIService();
        mRecyclerView = findViewById(R.id.rcview2);
        mylist = new ArrayList<TTSalon>();
        mylist2= new ArrayList<Service>();
        myAdapter = new Adapter2(DetailActivity.this,mylist2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(myAdapter);
        loadAnswers();


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }
    public void loadAnswers() {
        mAPIRequest.getlistSalon().enqueue(new Callback<ListSalon>() {
            @Override
            public void onResponse(Call<ListSalon> call, Response<ListSalon> response) {
                if(response.isSuccessful()){
                    mylist.addAll(response.body().getData());

                    for(int i=0;i<response.body().getData().size();i++){
                        mylist.get(i).getRelationships();
                        Log.d("check",""+response.body().getData().get(i).getNameSalon());
                    }
                    myAdapter.notifyDataSetChanged();
                }
                else Log.d("check",""+response);



            }

            @Override
            public void onFailure(Call<ListSalon> call, Throwable t) {
                Log.d("check",""+t);

            }
        });

    }
}
