package pk.pklovestar.baitaptonghop.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import pk.pklovestar.baitaptonghop.API.ApiUtils;
import pk.pklovestar.baitaptonghop.API.OnAPICilent;
import pk.pklovestar.baitaptonghop.Adapter.EndlessRecyclerViewScrollListener;
import pk.pklovestar.baitaptonghop.Adapter.ThongTinKhachHangAdapter;
import pk.pklovestar.baitaptonghop.Model.LstUser;
import pk.pklovestar.baitaptonghop.Model.TTKhachHangInput;
import pk.pklovestar.baitaptonghop.Model.ThongTinKhachHang;
import pk.pklovestar.baitaptonghop.R;
import pk.pklovestar.baitaptonghop.TruyenData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HotroFragment extends Fragment {
    TruyenData truyenData;
    View view;
    RecyclerView recyclerView;
    ThongTinKhachHangAdapter thongTinKhachHangAdapter;
    private OnAPICilent onAPICilent;
    SwipeRefreshLayout mSwipeRefreshLayout;
    String token;
    List<LstUser> listUser = new ArrayList<>();
    ProgressBar progressBar;
    Boolean loading = false;
    EditText edtsearch;
    SearchView searchView;
   String token2;// = this.getArguments().getString("token");



    public HotroFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fr_hotro,container, false);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(getArguments()!=null){
            token2 = getArguments().getString("token");
            Log.d("TOOOO",token2);
        }

        recyclerView = view.findViewById(R.id.fr_recyclerview_ttkh);
        mSwipeRefreshLayout = view.findViewById(R.id.refresh);
        progressBar = view.findViewById(R.id.progress);
        listUser = new ArrayList<>();
        searchView = view.findViewById(R.id.searchview);
        Log.d("check", "token hotro: "+token2);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);
        SharedPreferences myPrefs = this.getActivity().getSharedPreferences("mysample",Context.MODE_PRIVATE);
        token = myPrefs.getString("token",null);
        onAPICilent = ApiUtils.getAPIService();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadrecyclerview(1);
        thongTinKhachHangAdapter = new ThongTinKhachHangAdapter(getContext(),listUser);
        thongTinKhachHangAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(thongTinKhachHangAdapter);
        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener((LinearLayoutManager)
                recyclerView.getLayoutManager()) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {


                loadrecyclerview(page);


            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listUser.clear();
                thongTinKhachHangAdapter.notifyDataSetChanged();
                loadrecyclerview(1);
                mSwipeRefreshLayout.setRefreshing(false);

            }
        });
    }

    void loadrecyclerview(final int page){
        progressBar.setVisibility(View.VISIBLE);

        TTKhachHangInput ttKhachHangInput = new TTKhachHangInput(token2, "", page);
        onAPICilent.getThongTinKhachHang(ttKhachHangInput).enqueue(new Callback<ThongTinKhachHang>() {
            @Override
            public void onResponse(Call<ThongTinKhachHang> call, Response<ThongTinKhachHang> response) {


                if (response.isSuccessful()) {
                    if(response.body()!=null){
                        if(page ==0) {
                            listUser.clear();
                        }
                        listUser.addAll(response.body().listUsers.lstUsers);
                        Log.d("check", "" + listUser.get(1).getUserName());
                        thongTinKhachHangAdapter.notifyDataSetChanged();

                    }

                }
            }

            @Override
            public void onFailure(Call<ThongTinKhachHang> call, Throwable t) {
                Toast.makeText(getContext(), "error",Toast.LENGTH_SHORT).show();

            }
        });
        progressBar.setVisibility(View.GONE);

    }

}
