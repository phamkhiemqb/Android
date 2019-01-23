package pk.pklovestar.baitaptonghop.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import pk.pklovestar.baitaptonghop.Adapter.BanHangAdapter;
import pk.pklovestar.baitaptonghop.BanHangActivity;
import pk.pklovestar.baitaptonghop.Model.MdBanHang;
import pk.pklovestar.baitaptonghop.R;
import pk.pklovestar.baitaptonghop.ThongTinKhachHangActivity;

public class BanHangFragment extends Fragment {
    View v;
    RecyclerView recyclerView;
    BanHangAdapter banHangAdapter;
    List<MdBanHang> banHangList;
    String token2;


    public BanHangFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fr_banhang,container, false);
        recyclerView = v.findViewById(R.id.fr_recyclerview);
        banHangList = new ArrayList<MdBanHang>();
        MdBanHang mdBanHang1 = new MdBanHang(R.drawable.shape12, "Đấu nối thiết bị");
        MdBanHang mdBanHang2 = new MdBanHang(R.drawable.fuel, "Cabin nhiên liệu");
        MdBanHang mdBanHang3 = new MdBanHang(R.drawable.usbcable, "Đấu nối lại sim");
        MdBanHang mdBanHang4 = new MdBanHang(R.drawable.shape5, "Cập nhật thông tin \nkhách hàng");
        banHangList.add(mdBanHang1);
        banHangList.add(mdBanHang2);
        banHangList.add(mdBanHang3);
        banHangList.add(mdBanHang4);



        banHangAdapter = new BanHangAdapter(getContext(), banHangList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        banHangAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(banHangAdapter);


        return v;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()!=null){
            token2 = getArguments().getString("token");
            Log.d("check",token2);
        }
        banHangAdapter.OnCLickItem(new BanHangAdapter.OnClick() {
            @Override
            public void clickItemt(View view, int i) {
                if(i==3){
                    Intent intent = new Intent(v.getContext(), ThongTinKhachHangActivity.class);
                    intent.putExtra("token",token2);
                    startActivity(intent);
                }
            }
        });
    }
}
