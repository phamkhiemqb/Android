package vn.edu.linuxteamvietnam.phamkhiem.test1khiempx;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import vn.edu.linuxteamvietnam.phamkhiem.test1khiempx.Adapter.myAdapter;

public class MainActivity extends AppCompatActivity implements myAdapter.OnIntent, Serializable {
    RecyclerView mRecyclerView;
    myAdapter mRcvAdapter;
    List<DrinkInfo> listdata;
    EditText addTen, addGia;
    Button add;
    DrinkInfo dr4;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        addTen =findViewById(R.id.txtName);
        addGia =findViewById(R.id.txtPrice);
        add = findViewById(R.id.btnAdd);


        listdata = new ArrayList<DrinkInfo>();
        DrinkInfo drink1 =new DrinkInfo("Coffee",10000);
        DrinkInfo drink2 =new DrinkInfo("Pepsi",20000);
        DrinkInfo drink3 =new DrinkInfo("Coca",30000);
        listdata.add(drink1);
        listdata.add(drink2);
        listdata.add(drink3);
        mRcvAdapter = new myAdapter(MainActivity.this,listdata, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRcvAdapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = addGia.getText().toString();
                DrinkInfo dr = new DrinkInfo(addTen.getText().toString(),Double.parseDouble(t));
                listdata.add(dr);
                mRcvAdapter.notifyDataSetChanged();

            }
        });




    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2){
            Bundle bundle1 = data.getBundleExtra("Send1");
            dr4 = (DrinkInfo) bundle1.getSerializable("Send1");
            listdata.set(pos,dr4);
            mRcvAdapter.notifyDataSetChanged();

        }


    }

    @Override
    public void dataInTent(Intent intent, int i) {
        pos =i;

        DrinkInfo dr0 = listdata.get(i);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Send", dr0);
        intent.putExtra("Send", bundle);
        startActivityForResult(intent,2);
    }

    @Override
    public void dataDelete(int p1) {
        listdata.remove(p1);
        mRcvAdapter.notifyDataSetChanged();
    }

}
