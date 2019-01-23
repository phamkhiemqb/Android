package pk.pklovestar.baitaptonghop.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HotroFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    ThongTinKhachHangAdapter thongTinKhachHangAdapter;
    private OnAPICilent onAPICilent;
    SwipeRefreshLayout mSwipeRefreshLayout;
    String token,username = "";
    List<LstUser> listUser = new ArrayList<>();
    ProgressBar progressBar;
    Boolean loading = false;
    SearchView searchView;




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


        SharedPreferences myPrefs = this.getActivity().getSharedPreferences("mysample",Context.MODE_PRIVATE);
        String token1 = myPrefs.getString("token",null);


        if(token1 != null) token = token1;
        else {
            if(getArguments()!=null){
                token = getArguments().getString("token");
            }
        }
        Log.d("check", "token ok: "+token);
        recyclerView = view.findViewById(R.id.fr_recyclerview_ttkh);
        mSwipeRefreshLayout = view.findViewById(R.id.refresh);
        progressBar = view.findViewById(R.id.progress);
        listUser = new ArrayList<>();
        searchView = view.findViewById(R.id.searchview);

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        onAPICilent = ApiUtils.getAPIService();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadrecyclerview(1);
        thongTinKhachHangAdapter = new ThongTinKhachHangAdapter(getContext(),listUser);
        thongTinKhachHangAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(thongTinKhachHangAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                username = query;
//                listUser.clear();
//                loadrecyclerview(1);
//                thongTinKhachHangAdapter.notifyDataSetChanged();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                username = newText;
                listUser.clear();
                loadrecyclerview(1);
                thongTinKhachHangAdapter.notifyDataSetChanged();
                return false;
            }
        });

        refresh();
        loadmore();
    }

    private void refresh(){

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
    private void loadmore( ){

        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener((LinearLayoutManager)
                recyclerView.getLayoutManager()) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                progressBar.setVisibility(View.VISIBLE);


                loadrecyclerview(page);


            }
        });

    }

    void loadrecyclerview(final int page){

        TTKhachHangInput ttKhachHangInput = new TTKhachHangInput(token, username, page);
        onAPICilent.getThongTinKhachHang(ttKhachHangInput).enqueue(new Callback<ThongTinKhachHang>() {
            @Override
            public void onResponse(Call<ThongTinKhachHang> call, Response<ThongTinKhachHang> response) {
                Log.d("check", "timkiem: "+username);

                if (response.isSuccessful()) {
                    if(response.body()!=null){
                        if(page ==0) {
                            listUser.clear();
                        }
                        if (response.body().listUsers.lstUsers !=null){
                            listUser.addAll(response.body().listUsers.lstUsers);

                            thongTinKhachHangAdapter.notifyDataSetChanged();
                        }
                    }
                }
                if(thongTinKhachHangAdapter.getItemCount()==0 && username != "") {
                    Toast.makeText(getContext(), "Không tìm thấy kết quả",Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<ThongTinKhachHang> call, Throwable t) {
                Toast.makeText(getContext(), "Lỗi",Toast.LENGTH_SHORT).show();

            }
        });


    }

}
