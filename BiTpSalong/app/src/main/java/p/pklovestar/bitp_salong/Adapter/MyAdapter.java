package p.pklovestar.bitp_salong.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import p.pklovestar.bitp_salong.R;
import p.pklovestar.bitp_salong.Salon.ListSalon;
import p.pklovestar.bitp_salong.Salon.TTSalon;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private Context mContext;
    List<TTSalon> myList;
    public MyAdapter(Context context, List<TTSalon> listSalon){
        this.mContext = context;
        this.myList = listSalon;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_view,viewGroup,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(myList.get(i).getNameSalon());
        viewHolder.address.setText(myList.get(i).getAddress());
        Picasso.get().load(myList.get(i).getImageSalon().get(0)).into(viewHolder.imPhoto);

    }

    @Override
    public int getItemCount() {
        if(myList==null)
            return 0;
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, address;
        ImageView imPhoto;
        Button btnBook;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.it_txt_title);
            address = itemView.findViewById(R.id.it_txt_address);
            imPhoto = itemView.findViewById(R.id.it_image);
            btnBook = itemView.findViewById(R.id.it_btn_book);
        }
    }
}
