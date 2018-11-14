package vn.edu.linuxteamvietnam.phamkhiem.test1khiempx.Adapter;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.linuxteamvietnam.phamkhiem.test1khiempx.AddActivity;
import vn.edu.linuxteamvietnam.phamkhiem.test1khiempx.DrinkInfo;
import vn.edu.linuxteamvietnam.phamkhiem.test1khiempx.R;

public class myAdapter extends RecyclerView.Adapter<myAdapter.RecyclerViewHolder>{
    Context context;
    Intent intent;
    private OnIntent mIntent;


    private List<DrinkInfo> data = new ArrayList<DrinkInfo>();

    public myAdapter(Context context, List<DrinkInfo> data,OnIntent mInt) {
        this.data = data;
        this.context = context;
        mIntent = mInt ;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.txtUserName.setText(data.get(position).getName());
        holder.txtTuoi.setText(String.valueOf(data.get(position).getPrice()));
        holder.btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, AddActivity.class);
                mIntent.dataInTent(intent, position);

            }
        });
        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent.dataDelete(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtUserName, txtTuoi, txtGioiTinh;
        ImageView imgAvatar;
        Button btnXoa, btnSua;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtUserName = (TextView) itemView.findViewById(R.id.txtTen);
            txtTuoi = (TextView) itemView.findViewById(R.id.txtGia);
            btnSua = (Button) itemView.findViewById(R.id.btnSua);
            btnXoa = (Button) itemView.findViewById(R.id.btnXoa);
        }
    }
    public interface OnIntent{
        void dataInTent(Intent intent, int p);
        void dataDelete(int p1);
    }
}