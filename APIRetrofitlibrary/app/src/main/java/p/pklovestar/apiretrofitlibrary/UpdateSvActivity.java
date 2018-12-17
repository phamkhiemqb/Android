package p.pklovestar.apiretrofitlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UpdateSvActivity extends AppCompatActivity{
    private Button btnSave;
    private TextView tvName,tvPrice;
    private Produce pr1;
    private final int INTENT01 = 99;
    private Bundle bundle;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sv);
        findID();
        final Intent intent = getIntent();
        bundle = intent.getBundleExtra("pr");
        pr1= (Produce) bundle.getSerializable("pr");
        setText();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putSerializable("pr1",getText());
                intent.putExtra("pr1",bundle);
                setResult(INTENT01,intent);
                finish();
            }
        });
    }
    Produce getText(){
        Produce pr2 = new Produce();
        pr2.setId(null);
        pr2.setProduce(tvName.getText().toString());
        pr2.setPrice(Integer.parseInt(tvPrice.getText().toString()));
        return pr2;

    }
    void setText() {
        tvName.setText(pr1.getProduce().toString());
        tvPrice.setText(pr1.getPrice().toString());
    }

    void findID(){
        btnSave = findViewById(R.id.btn_save);
        tvName = findViewById(R.id.txt_name1);
        tvPrice = findViewById(R.id.txt_price1);
    }
}

