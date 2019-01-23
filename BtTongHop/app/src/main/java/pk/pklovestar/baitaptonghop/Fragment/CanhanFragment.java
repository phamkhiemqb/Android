package pk.pklovestar.baitaptonghop.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import pk.pklovestar.baitaptonghop.LocaleHelper;
import pk.pklovestar.baitaptonghop.LoginActivity;
import pk.pklovestar.baitaptonghop.Model.UserInfo;
import pk.pklovestar.baitaptonghop.Model.UserKhachHangOutput;
import pk.pklovestar.baitaptonghop.R;

public class CanhanFragment extends Fragment {
    View view;
    List<String> listlanguge;
    Spinner spinner1;
    private TextView oneword, username1, phone, username2, email;
    ImageButton logout;

    public static final String Locale_KeyValue = "Locale";
    private SharedPreferences myPrefs;
    SharedPreferences.Editor editor;

    private Intent intent;
    AdapterView.OnItemSelectedListener listener;
    UserInfo userInfo;
    int i =0;
    String lang;
    boolean isDefaultSelection = false;


    public CanhanFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fr_canhan,container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anhxa();
        String data_user = myPrefs.getString("datauser",null);
        if(data_user!=null){
            Gson gson = new Gson();
            userInfo = gson.fromJson(data_user, UserInfo.class);
        }
        settext();
        spinerlisenner();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(R.string.xac_nhan_mess)
                        .setTitle(R.string.xac_nhan)
                        .create();
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editor.clear();
                        editor.commit();
                        Intent intent1 = new Intent(getActivity(), LoginActivity.class);
                        getActivity().startActivity(intent1);
                        getActivity().finish();
                        Toast.makeText(getContext(),getResources().getText(R.string.dang_xuat_thang_cong),Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton(R.string.cancle, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();



            }
        });




    }

    private void settext() {

        String[] ary = userInfo.getUsername().trim().split("");
        oneword.setText(ary[1]);
        username1.setText(userInfo.getUsername());
        phone.setText(userInfo.getUserPhoneNumber());
        username2.setText(userInfo.getFullname());
        email.setText(userInfo.getEmail());
    }

    private void anhxa() {
        myPrefs = getActivity().getSharedPreferences("mysample",getContext().MODE_PRIVATE);
        editor = myPrefs.edit();
        lang = LocaleHelper.getLanguage(getContext());
        oneword = view.findViewById(R.id.txt_chucai);
        username1 = view.findViewById(R.id.txt_username1);
        phone = view.findViewById(R.id.phone);
        username2 = view.findViewById(R.id.txt_username2);
        email = view.findViewById(R.id.txt_email1);
        intent = getActivity().getIntent();
        spinner1 = view.findViewById(R.id.spn_language);
        logout= view.findViewById(R.id.logout);
        listlanguge = new ArrayList<>();
        listlanguge.add((String) getResources().getText(R.string.tieng_anh));
        listlanguge.add((String) getResources().getText(R.string.tieng_viet));
        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item,listlanguge);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
        spinner1.setAdapter(adapter);
        if(lang.equals("vi")) spinner1.setSelection(0, true);
        if(lang.equals("en")) spinner1.setSelection(1, true);
    }
    private void spinerlisenner(){
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:

                        if(lang.equals("vi"));
                        else {
                            LocaleHelper.setLocale(getActivity(), "vi");
                            getActivity().finish();
                            getActivity().startActivity(intent);
                        }
                        break;
                    case 1:
                        lang = LocaleHelper.getLanguage(getContext());
                        if(lang.equals("en"));
                        else {
                            LocaleHelper.setLocale(getActivity(), "en");
                            getActivity().finish();
                            getActivity().startActivity(intent);
                        }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
