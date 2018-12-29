package p.pklovestar.bitp_salong.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import p.pklovestar.bitp_salong.R;
import p.pklovestar.bitp_salong.Salon.Service;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder>{
    Context mContext;
    List<Service> mListService;

    public Adapter2(Context mContext, List<Service> mListService) {
        this.mContext = mContext;
        this.mListService = mListService;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_view2,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.nameService.setText(mListService.get(i).getName());

    }

    @Override
    public int getItemCount() {
        if(mListService==null)
            return 0;
        return mListService.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameService;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameService =itemView.findViewById(R.id.it_txt_service);

        }
    }
}
