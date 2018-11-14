package vn.edu.linuxteamvietnam.phamkhiem.test1khiempx;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class AddActivity extends AppCompatActivity {
    EditText suaTen, suaGia;
    Intent intent;
    Button save;
    DrinkInfo dr0;
    Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        suaTen = findViewById(R.id.txtName1);
        suaGia = findViewById(R.id.txtPrice1);
        save = findViewById(R.id.btnSave);
        intent = getIntent();

        if(getIntent()!=null){
            setResult(2, intent);
            Bundle bundle = intent.getBundleExtra("Send");
            dr0 = (DrinkInfo) bundle.getSerializable("Send");


        }
        suaTen.setText(dr0.getName());
        suaGia.setText(String.valueOf(dr0.getPrice()));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(2, intent);
                String sn = suaGia.getText().toString();
                dr0.setPrice((long) Double.parseDouble(sn));
                dr0.setName(suaTen.getText().toString());
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("Send1", (Serializable) dr0);
                intent.putExtra("Send1", bundle1);
                finish();

            }
        });

    }
}