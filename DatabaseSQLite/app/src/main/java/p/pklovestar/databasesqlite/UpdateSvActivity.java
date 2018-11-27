package p.pklovestar.databasesqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UpdateSvActivity extends AppCompatActivity{
    Button btnSave;
    TextView tvID,tvName,tvAddress,tvSex;
    Sinhvien sv1;
    public final int INTENT01 = 99;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sv);
        findID();
        final Intent intent = getIntent();
        final Bundle bundle = intent.getBundleExtra("sv1");
        sv1= (Sinhvien) bundle.getSerializable("sv1");
        setText();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getText();
                bundle.putSerializable("sv1",sv1);
                intent.putExtra("sv1",bundle);
                setResult(INTENT01,intent);
                finish();
            }
        });
    }
    void getText(){
        sv1.setName(tvName.getText().toString());
        sv1.setAddress(tvAddress.getText().toString());
        sv1.setPhone(tvSex.getText().toString());
    }
    void setText(){
        tvID.setText(String.valueOf(sv1.getId()));
        tvName.setText(sv1.getName().toString());
        tvAddress.setText(sv1.getAddress().toString());
        tvSex.setText(sv1.getPhone().toString());
    }
    void findID(){
        btnSave = findViewById(R.id.btn_save);
        tvID = findViewById(R.id.txt_id);
        tvName = findViewById(R.id.txt_name);
        tvAddress = findViewById(R.id.txt_address);
        tvSex = findViewById(R.id.txt_phone);
    }
}
