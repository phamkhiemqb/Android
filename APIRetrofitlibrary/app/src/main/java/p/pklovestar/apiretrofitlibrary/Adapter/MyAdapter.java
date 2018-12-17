package p.pklovestar.apiretrofitlibrary.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import p.pklovestar.apiretrofitlibrary.R;
import p.pklovestar.apiretrofitlibrary.Produce;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private List<Produce> listProduce;
    private OnItemClickEdit onItemClickEdit;
    private OnItemClickDelete onItemClickDelete;
    public interface OnItemClickEdit {
        void onItemClick(View itemView, int position);
    }
    public interface OnItemClickDelete {
        void onItemClick(View itemView, int position);
    }

    public MyAdapter(Context context, List<Produce> listProduce){
        this.mContext = context;
        this.listProduce = listProduce;
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
        viewHolder.name.setText(listProduce.get(i).getProduce().toString());
        viewHolder.price.setText(String.valueOf(listProduce.get(i).getPrice()));

    }

    @Override
    public int getItemCount() {
        if(listProduce!=null)
            return this.listProduce.size();
        else return 0;


    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        ImageView btnEdit,btnDelate;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.txt_it_name);
            price=itemView.findViewById(R.id.txt_it_price);
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

