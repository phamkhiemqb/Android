package com.example.admin.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHoler> {
    private Context mContext;
    private ArrayList<String> data = new ArrayList<>();
    private OnDeleteListener mListener;

    public MyAdapter(Context context, ArrayList<String> d, OnDeleteListener l){
        mContext = context;
        data = d;
        mListener = l;
    }


    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, viewGroup, false);
        return new MyViewHoler(v);  //this is the major change here.
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler myViewHoler, final int position) {
            myViewHoler.txtName.setText(data.get(position));

            myViewHoler.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(mContext,"delete"+data.get(position),Toast.LENGTH_SHORT).show();
                    mListener.onDelete(data.get(position));
                }
            });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHoler extends RecyclerView.ViewHolder{
        TextView txtName;
        Button btnDelete;


        public MyViewHoler(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.item_recyclerview_txt_name);
            btnDelete = itemView.findViewById(R.id.item_delete);
        }
    }

    interface OnDeleteListener{
        void onDelete(String data);
    }
}
