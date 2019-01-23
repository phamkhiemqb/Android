package com.example.user.salon;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class Info extends Activity{
    TextView txtnameks, txtoph,txtsdtks,txtdcks,txtabout, txtnameservice, txtprice, txtdescription, txttimeservice;
    ImageView img;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);
        String l = getIntent().getStringExtra("abc");
        Gson gson = new Gson();
        Datum ab = gson.fromJson(l,Datum.class);
        anhxa();
        txtnameks.setText(ab.getName_salon());
        txtoph.setText(ab.getOpening_hours());
        txtsdtks.setText(ab.getPhone());
        txtdcks.setText(ab.getAddress());
        txtabout.setText(ab.getDescription());
        Picasso.with(this)
                .load(ab.getImage_salon().get(0))
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(img);

        if(ab.getRelationships()!=null && ab.getRelationships().getServices()!=null && ab.getRelationships().getServices().size()>0) {
            txtnameservice.setText(ab.getRelationships().getServices().get(0).getName());
        }
    }

    private void anhxa() {
        img = (ImageView)findViewById(R.id.imgvas);
        txttimeservice = (TextView)findViewById(R.id.servicetime);
        txtnameservice = (TextView)findViewById(R.id.nameservice);
        txtdescription = (TextView)findViewById(R.id.gioithieu);
        txtprice = (TextView)findViewById(R.id.priceservice);
        txtnameks = (TextView)findViewById(R.id.txtnamesalon);
        txtoph = (TextView)findViewById(R.id.oph);
        txtsdtks = (TextView)findViewById(R.id.txtsdt);
        txtdcks = (TextView)findViewById(R.id.txtdcsalon);
        txtabout = (TextView)findViewById(R.id.info);


    }
}
