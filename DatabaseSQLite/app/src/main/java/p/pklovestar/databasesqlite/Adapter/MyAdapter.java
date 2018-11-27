package p.pklovestar.databasesqlite.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import p.pklovestar.databasesqlite.R;
import p.pklovestar.databasesqlite.Sinhvien;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context mContext;
    List<Sinhvien> mSinhvien;
    public MyAdapter(Context context, List<Sinhvien> sinhvien){
        this.mContext = context;
        this.mSinhvien = sinhvien;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_sv,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.id.setText(String.valueOf(mSinhvien.get(i).getId()));
        viewHolder.name.setText(mSinhvien.get(i).getName().toString());
        viewHolder.address.setText(mSinhvien.get(i).getAddress().toString());
        viewHolder.sex.setText(mSinhvien.get(i).getSex().toString());

    }

    @Override
    public int getItemCount() {
        return mSinhvien.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id,name,address,sex;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id =itemView.findViewById(R.id.txt_it_id);
            name =itemView.findViewById(R.id.txt_it_name);
            address=itemView.findViewById(R.id.txt_it_address);
            sex=itemView.findViewById(R.id.txt_it_sex);
        }
    }

}

