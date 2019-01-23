package tk.pklovestar.btth;

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
import pk.pklovestar.baitaptonghop.Fragment.CanhanFragment;
import pk.pklovestar.baitaptonghop.Fragment.DaotaoFragment;
import pk.pklovestar.baitaptonghop.Fragment.HotroFragment;
import tk.pklovestar.btth.Adapter.ViewPageAdapter;


public class BanHangActivity extends AppCompatActivity {
    ViewPager viewPager;
    ViewPageAdapter viewPageAdapter;
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banhang);
        viewPager = findViewById(R.id.viewpage_banhang);
        bottomNavigationView = findViewById(R.id.navibotom);

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
        viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPageAdapter.AddFragment(new BanHangFragment(), "");
        viewPageAdapter.AddFragment(new HotroFragment(), "");
        viewPageAdapter.AddFragment(new DaotaoFragment(), "");
        viewPageAdapter.AddFragment(new CanhanFragment(),"");
        viewPager.setAdapter(viewPageAdapter);
    }
}
