package pk.pklovestar.dangonnguv2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private static Button english, japan,vietnam, russian;
    private static TextView chooseText;
    private static Locale myLocale;

    private static final String Locale_Preference = "Locale Preference";
    private static final String Locale_KeyValue = "Saved Locale";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();

    }


    private void initViews() {
        sharedPreferences = getSharedPreferences(Locale_Preference, Activity.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        chooseText = (TextView) findViewById(R.id.choose_text);
        english = (Button) findViewById(R.id.english);
        japan = (Button) findViewById(R.id.japan);
        vietnam = (Button) findViewById(R.id.vietnam);
        russian = (Button) findViewById(R.id.russian);
    }

    private void setListeners() {
        english.setOnClickListener(this);
        japan.setOnClickListener(this);
        vietnam.setOnClickListener(this);
        russian.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String lang = "en";
        switch (view.getId()) {
            case R.id.english:
                lang = "en";
                break;
            case R.id.japan:
                lang = "ja";
                break;
            case R.id.vietnam:
                lang = "vi";
                break;
            case R.id.russian:
                lang = "ru";
                break;
        }

        changeLocale(lang);
        loadLocale();
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }


    //Change Locale
    public void changeLocale(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);
        saveLocale(lang);
        Locale.setDefault(myLocale);
        Configuration config = new Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());//Update the config
        updateTexts();
//        Intent refresh = new Intent(this, MainActivity.class);
//        refresh.putExtra("lang", lang);
//        startActivity(refresh);
    }

    public void saveLocale(String lang) {
        editor.putString(Locale_KeyValue, lang);
        editor.commit();
    }

    public void loadLocale() {
        String language = sharedPreferences.getString(Locale_KeyValue, "");
        changeLocale(language);
    }

    private void updateTexts() {
        chooseText.setText(R.string.tap_text);
        english.setText(R.string.btn_en);
        vietnam.setText(R.string.btn_vi);
        russian.setText(R.string.btn_ru);
        japan.setText(R.string.btn_ja);
    }

}
