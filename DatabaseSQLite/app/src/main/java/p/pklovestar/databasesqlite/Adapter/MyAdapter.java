package p.pklovestar.databasesqlite.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import p.pklovestar.databasesqlite.R;
import p.pklovestar.databasesqlite.Sinhvien;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private List<Sinhvien> mSinhvien;
    private OnItemClickEdit onItemClickEdit;
    private OnItemClickDelete onItemClickDelete;
    public interface OnItemClickEdit {
        void onItemClick(View itemView, int position);
    }
    public interface OnItemClickDelete {
        void onItemClick(View itemView, int position);
    }

    public MyAdapter(Context context, List<Sinhvien> sinhvien){
        this.mContext = context;
        this.mSinhvien = sinhvien;
    }
    public void setEditClick(OnItemClickEdit onItemClickListener){
        this.onItemClickEdit = onItemClickListener;
    }
    public void setDeleteClick(OnItemClickDelete onItemClickListener){
        this.onItemClickDelete = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_sv,viewGroup,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.id.setText(String.valueOf(mSinhvien.get(i).getId()));
        viewHolder.name.setText(mSinhvien.get(i).getName().toString());
        viewHolder.address.setText(mSinhvien.get(i).getAddress().toString());
        viewHolder.phone.setText(mSinhvien.get(i).getPhone().toString());

    }

    @Override
    public int getItemCount() {
        return mSinhvien.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id,name,address,phone;
        ImageView btnEdit,btnDelate;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            id =itemView.findViewById(R.id.txt_it_id);
            name =itemView.findViewById(R.id.txt_it_name);
            address=itemView.findViewById(R.id.txt_it_address);
            phone=itemView.findViewById(R.id.txt_it_phone);
            btnEdit = itemView.findViewById(R.id.btn_it_Edit);
            btnDelate = itemView.findViewById(R.id.btn_it_Delete);

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickEdit.onItemClick(itemView, getAdapterPosition());
                }
            });
            btnDelate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickDelete.onItemClick(itemView,getAdapterPosition());
                }
            });
            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    btnEdit.setAlpha((float) 1.0);
                    btnDelate.setAlpha((float) 1.0);

                    return false;
                }
            });



        }
    }


}

