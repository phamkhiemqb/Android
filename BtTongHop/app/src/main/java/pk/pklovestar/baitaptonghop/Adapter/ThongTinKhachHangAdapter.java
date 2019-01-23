package pk.pklovestar.baitaptonghop.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pk.pklovestar.baitaptonghop.Model.LstUser;
import pk.pklovestar.baitaptonghop.R;

public class ThongTinKhachHangAdapter extends RecyclerView.Adapter<ThongTinKhachHangAdapter.ViewHoder> {
    Context context;
    List<LstUser> listUser;

    public ThongTinKhachHangAdapter(Context context, List<LstUser> listUser) {
        this.context = context;
        this.listUser = listUser;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View v = layoutInflater.inflate(R.layout.item_ttkhachhang,viewGroup,false);
        return new ViewHoder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, int i) {
        viewHoder.user.setText(listUser.get(i).getUserName().trim());
        viewHoder.email.setText(listUser.get(i).getEmail().trim());

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView user, email;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            user = itemView.findViewById(R.id.it_user);
            email = itemView.findViewById(R.id.it_email);
        }
    }
}
