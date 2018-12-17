package p.pklovestar.apiretrofitlibrary;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import p.pklovestar.apiretrofitlibrary.Adapter.MyAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Produce> listProduce;
    private MyAdapter myAdapter;
    private Button btnAdd;
    private final int INTENT01 = 99;
    private Produce pr1;
    int pos;
    private EditText edName,edPrice;
    private Intent intent1;
    final String BASE_URL = "http://45.77.27.89:8088/api/";

    Retrofit retrofit;

    APIClass myAPIclass;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==INTENT01){
            Bundle bundle1 = data.getBundleExtra("pr1");
            Produce pr3 = (Produce) bundle1.getSerializable("pr1");
            listProduce.set(pos,pr3);
            myAdapter.notifyDataSetChanged();


        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        khoitao();
        myAdapter = new MyAdapter(MainActivity.this, listProduce);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myAPIclass= retrofit.create(APIClass.class);
        myAPIclass.getListProducer().enqueue(new Callback<ListProduce>() {
            @Override
            public void onResponse(Call<ListProduce> call, Response<ListProduce> response) {
                if(response.isSuccessful()) {
                    ListProduce list = response.body();
                    list = (ListProduce) listProduce;
                    myAdapter.notifyDataSetChanged();

                }else{
                    Toast.makeText(MainActivity.this, "error",Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<ListProduce> call, Throwable t) {

            }
        });



        recycle();
        clickAdd();
        myAdapter.setEditClick(new MyAdapter.OnItemClickEdit() {
            @Override
            public void onItemClick(View itemView, int position) {
                pos = position;
                Bundle bundle = new Bundle();
                bundle.putSerializable("pr",listProduce.get(position));
                intent1.putExtra("pr",bundle);
                startActivityForResult(intent1,INTENT01);

            }
        });


    }
    public Produce getText(){
        Produce pr2 = new Produce();
        pr2.setId(null);
        pr2.setProduce(edName.getText().toString());
        pr2.setPrice(Integer.parseInt(edPrice.getText().toString()));
        return pr2;

    }
    public void khoitao(){
        edName = findViewById(R.id.txt_name);
        edPrice = findViewById(R.id.txt_price);
        recyclerView = findViewById(R.id.list_sv);
        btnAdd = findViewById(R.id.btn_add);
        listProduce = new ArrayList<Produce>();
        intent1 = new Intent(MainActivity.this,UpdateSvActivity.class);


    }
    public void recycle(){

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(myAdapter);
    }
    public void clickAdd(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produce pr3 = getText();
                if(pr3 != null)
                    listProduce.add(pr3);
                myAdapter.notifyDataSetChanged();




            }
        });
    }

}
