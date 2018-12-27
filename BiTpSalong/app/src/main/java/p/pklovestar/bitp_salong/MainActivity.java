package p.pklovestar.bitp_salong;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import p.pklovestar.bitp_salong.Adapter.MyAdapter;
import p.pklovestar.bitp_salong.Salon.ListSalon;
import p.pklovestar.bitp_salong.Salon.TTSalon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private APIRequest mAPIRequest;
    private MyAdapter myAdapter;
    List<TTSalon> mylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#B45BD5")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.outline_dehaze_black_18dp);
        mRecyclerView = findViewById(R.id.rcview);
        mAPIRequest = ApiUtils.getAPIService();
        mylist= new ArrayList<TTSalon>();
        myAdapter = new MyAdapter(MainActivity.this,mylist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(myAdapter);
        loadAnswers();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuaction, menu);
        return true;
    }
    public void loadAnswers() {
        mAPIRequest.getlistSalon().enqueue(new Callback<ListSalon>() {
            @Override
            public void onResponse(Call<ListSalon> call, Response<ListSalon> response) {
                if(response.isSuccessful()){
                    mylist.addAll(response.body().getData());
                    for(int i=0;i<response.body().getData().size();i++){
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
