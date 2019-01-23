package pk.pklovestar.baitaptonghop.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import pk.pklovestar.baitaptonghop.Model.MdBanHang;
import pk.pklovestar.baitaptonghop.R;

public class BanHangAdapter extends RecyclerView.Adapter<BanHangAdapter.viewHoder> {
    Context context;
    List<MdBanHang> mdBanHangList;
    OnClick onClick;
    public void OnCLickItem(OnClick onClick){
        this.onClick = onClick;
    }

    public BanHangAdapter(Context context, List<MdBanHang> mdBanHangList) {
        this.context = context;
        this.mdBanHangList = mdBanHangList;
    }

    @NonNull
    @Override
    public viewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_banhang, viewGroup, false);
        return new viewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHoder viewHoder, int i) {
        viewHoder.img.setImageResource(mdBanHangList.get(i).getImg());
        viewHoder.tt.setText(mdBanHangList.get(i).getTitle());

    }

    @Override
    public int getItemCount() {
        return mdBanHangList.size();
    }

    class viewHoder extends ViewHolder {
        ImageView img;
        TextView tt;
        public viewHoder(@NonNull final View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.it_icon);
            tt = itemView.findViewById(R.id.it_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.clickItemt(itemView, getAdapterPosition());
                }
            });
        }
    }
    public interface OnClick{
        void clickItemt(View view, int i);

    }
}
