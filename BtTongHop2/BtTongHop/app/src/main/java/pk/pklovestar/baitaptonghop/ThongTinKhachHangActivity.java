package pk.pklovestar.baitaptonghop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.session.MediaSession;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.google.gson.Gson;

import pk.pklovestar.baitaptonghop.API.ApiUtils;
import pk.pklovestar.baitaptonghop.API.OnAPICilent;
import pk.pklovestar.baitaptonghop.Adapter.ViewPageAdapter;
import pk.pklovestar.baitaptonghop.Fragment.BanHangFragment;
import pk.pklovestar.baitaptonghop.Fragment.CanhanFragment;
import pk.pklovestar.baitaptonghop.Fragment.DaotaoFragment;
import pk.pklovestar.baitaptonghop.Fragment.HotroFragment;
import pk.pklovestar.baitaptonghop.Fragment.RongFragment;
import pk.pklovestar.baitaptonghop.Model.TTKhachHangInput;
import pk.pklovestar.baitaptonghop.Model.ThongTinKhachHang;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThongTinKhachHangActivity extends AppCompatActivity {
    ViewPager viewPager;
    ViewPageAdapter viewPageAdapter;
    BottomNavigationView bottomNavigationView;
    MenuItem menuItem;
    String token;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinkhachhang);
        setupActionbar();

        viewPager = findViewById(R.id.viewpage_banhang);
        bottomNavigationView = findViewById(R.id.navibotom);
        setupbBotomnaviViewpage();





    }

    private void setupbBotomnaviViewpage() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.mn_banhang:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.mn_hotro:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.mn_daotao:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.mn_canhan:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page",""+i);
                bottomNavigationView.getMenu().getItem(i).setChecked(true);
                menuItem = bottomNavigationView.getMenu().getItem(i);


            }

            @Override
            public void onPageScrollStateChanged(int i) {


            }

        });
        setupviewpaper();
    }


    void setupviewpaper(){
        Intent intent = getIntent();
        token =intent.getStringExtra("token");
        Bundle bundle = new Bundle();
        bundle.putString("token", token);
        HotroFragment hotroFragment = new HotroFragment();
        hotroFragment.setArguments(bundle);

        viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPageAdapter.AddFragment(new RongFragment(), "");
        viewPageAdapter.AddFragment(hotroFragment, "");
        viewPageAdapter.AddFragment(new DaotaoFragment(), "");
        viewPageAdapter.AddFragment(new CanhanFragment(),"");
        viewPager.setAdapter(viewPageAdapter);
        viewPager.setCurrentItem(getIntent().getIntExtra("hotro",1));
    }

    private void setupActionbar() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }


}
