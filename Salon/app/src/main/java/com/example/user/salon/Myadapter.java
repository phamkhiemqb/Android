package com.example.user.salon;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.Myviewholder>{
    private Context mcontext;
    ArrayList<Datum> data;
    private Ondata ondata;

    public Myadapter(Context context, ArrayList<Datum> arrayList, Ondata l){
        data = arrayList;
        mcontext = context;
        ondata = l;
    }
    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, viewGroup, false);
        return new Myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder myviewholder, final int i) {
             myviewholder.txtname.setText(data.get(i).getName_salon());
             myviewholder.txtdc.setText(data.get(i).getAddress());
        Picasso.with(mcontext)
                .load(data.get(i).getImage_salon().get(0))
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(myviewholder.imgv);
        myviewholder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ondata.dtb(data.get(i));

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Myviewholder extends RecyclerView.ViewHolder {
        TextView txtname,txtdc;
        ImageView imgv;
        Button btn;
        public Myviewholder(@NonNull View itemView) {

            super(itemView);
            txtname = (TextView)itemView.findViewById(R.id.txtname);
            txtdc = (TextView)itemView.findViewById(R.id.txtdc);
            imgv = (ImageView) itemView.findViewById(R.id.imgv);
            btn = (Button) itemView.findViewById(R.id.btnbook);
        }
    }
    interface Ondata{
        void dtb(Datum s);

    }
}
