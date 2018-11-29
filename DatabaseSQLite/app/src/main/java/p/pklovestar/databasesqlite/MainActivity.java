package p.pklovestar.databasesqlite;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import p.pklovestar.databasesqlite.Adapter.MyAdapter;
import p.pklovestar.databasesqlite.Database.TableSinhvien;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Sinhvien> listSV;
    MyAdapter myAdapter;
    Button btnAdd;
    public final int INTENT01 = 99;
    Sinhvien sv2;
    int pos;
    EditText edName,edAddress,edPhone;
    Intent intent1;
    TableSinhvien tableSinhvien;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==INTENT01){
            Bundle bundle1 = data.getBundleExtra("sv1");
            sv2 = (Sinhvien) bundle1.getSerializable("sv1");
            tableSinhvien.UpdateSV(sv2);
            listSV.clear();
            listSV.addAll(tableSinhvien.getDataTable());
            myAdapter.notifyDataSetChanged();


        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableSinhvien = new TableSinhvien(MainActivity.this);

        khoitao();
        listSV = tableSinhvien.getDataTable();
        myAdapter = new MyAdapter(MainActivity.this, listSV);

        recycle();
        editClickItem();
        clickAdd();

    }
    public Sinhvien getText(){
        Sinhvien sv2 = new Sinhvien();
        sv2.setName(edName.getText().toString());
        sv2.setAddress(edAddress.getText().toString());
        sv2.setPhone(edPhone.getText().toString());
        return sv2;

    }
    public void khoitao(){
        edName = findViewById(R.id.txt_name);
        edAddress = findViewById(R.id.txt_address);
        edPhone = findViewById(R.id.txt_phone);
        recyclerView = findViewById(R.id.list_sv);
        btnAdd = findViewById(R.id.btn_add);
        intent1 = new Intent(MainActivity.this,UpdateSvActivity.class);


    }
    public void editClickItem(){
        myAdapter.setEditClick(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                pos= position;
                Bundle bundle = new Bundle();
                bundle.putSerializable("sv1",listSV.get(position));
                intent1.putExtra("sv1",bundle);
                startActivityForResult(intent1,INTENT01);
            }
        });


    }
    public void deleteClickItem(){
        myAdapter.setDeleteClick(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                tableSinhvien.DeleteSV(position);
                listSV.clear();
                listSV.addAll(tableSinhvien.getDataTable());
                myAdapter.notifyDataSetChanged();

            }
        });


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
                tableSinhvien.addSinhVien(getText());
                listSV.clear();
                listSV.addAll(tableSinhvien.getDataTable());
                myAdapter.notifyDataSetChanged();


            }
        });
    }
}
