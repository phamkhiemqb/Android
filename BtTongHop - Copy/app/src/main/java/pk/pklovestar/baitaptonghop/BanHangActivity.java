package pk.pklovestar.baitaptonghop;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import pk.pklovestar.baitaptonghop.Adapter.ViewPageAdapter;
import pk.pklovestar.baitaptonghop.Fragment.BanHangFragment;
import pk.pklovestar.baitaptonghop.Fragment.RongFragment;

public class BanHangActivity extends AppCompatActivity {
    ViewPager viewPager;
    ViewPageAdapter viewPageAdapter;
    BottomNavigationView bottomNavigationView;
    MenuItem menuItem;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banhang);

        viewPager = findViewById(R.id.viewpage_banhang);
        bottomNavigationView = findViewById(R.id.navibotom);
        Intent intent = getIntent();
        token =intent.getStringExtra("token");
        Log.d("check", "token ban hang: "+token);

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
        Bundle bundle = new Bundle();
        bundle.putString("token", token);
        BanHangFragment banHangFragment = new BanHangFragment();
        banHangFragment.setArguments(bundle);
        viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPageAdapter.AddFragment(banHangFragment, "");
        viewPageAdapter.AddFragment(new RongFragment(), "");
        viewPageAdapter.AddFragment(new RongFragment(), "");
        viewPageAdapter.AddFragment(new RongFragment(), "");
        viewPager.setAdapter(viewPageAdapter);
    }

}
