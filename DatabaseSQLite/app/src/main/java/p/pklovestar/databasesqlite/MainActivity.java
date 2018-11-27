package p.pklovestar.databasesqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import p.pklovestar.databasesqlite.Adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Sinhvien> listSV;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list_sv);
        listSV = new ArrayList<Sinhvien>();
        Sinhvien sv1 = new Sinhvien(1,"Nguyen Van A", "Da Nang", "Nam");
        listSV.add(sv1);
        listSV.add(sv1);
        listSV.add(sv1);
        listSV.add(sv1);
        myAdapter = new MyAdapter(MainActivity.this, listSV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(myAdapter);


    }

}
