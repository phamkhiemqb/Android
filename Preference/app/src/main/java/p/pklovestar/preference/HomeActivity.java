package p.pklovestar.preference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends Activity {
    Button logout;
    TextView thongbao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        thongbao = findViewById(R.id.txt_welcome);
        logout = findViewById(R.id.btn_logout);
        final Intent intent = getIntent();
        thongbao.setText(intent.getStringExtra("user1"));
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences myPrefs = getSharedPreferences("mysample",MODE_PRIVATE);
                SharedPreferences.Editor editor =  myPrefs.edit();
                editor.remove("login");
                editor.commit();
                Intent intent1 = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent1);
                finish();
            }
        });
        
        
    }
}