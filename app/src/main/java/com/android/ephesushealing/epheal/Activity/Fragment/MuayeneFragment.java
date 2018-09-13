package com.android.ephesushealing.epheal.Activity.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.android.ephesushealing.epheal.Activity.MainActivity;
import com.android.ephesushealing.epheal.R;

public class MuayeneFragment extends Fragment implements View.OnClickListener {
    View view;
    Integer height, width;
    RelativeLayout rldate,rlcd_sikayet,rlcd_hikaye,rlcd_bulgu,rlcd_sonuc;
    AppCompatImageView imgcd_sikayet,imgcd_hikaye,imgcd_bulgu,imgcd_sonuc;
    TextView btnsave, tvdate;
    ToggleButton toggele;
    CardView crd_sikayet, crd_hikaye, crd_bulgu, crd_sonuç;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_muayene, container, false);
        findbyid();

        rldate.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0));
        btnsave.setOnClickListener(this);
        toggele.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    toggele.setBackgroundDrawable(getResources().getDrawable(R.drawable.toggled_on));
                    adddate();

                } else {
                    toggele.setBackgroundDrawable(getResources().getDrawable(R.drawable.toggled_off));
                    rldate.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0));
                }
            }
        });
        crd_sikayet.setOnClickListener(this);
        crd_hikaye.setOnClickListener(this);
        crd_bulgu.setOnClickListener(this);
        crd_sonuç.setOnClickListener(this);
        return view;
    }

    public void getDisplay() {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        height = display.getHeight();
        width = display.getWidth();
    }

    public void findbyid() {
        rldate = view.findViewById(R.id.rldate);
        btnsave = view.findViewById(R.id.btnsave);
        toggele = view.findViewById(R.id.toggele);
        tvdate = view.findViewById(R.id.tvdate);
        crd_sikayet = view.findViewById(R.id.crd_sikayet);
        crd_hikaye = view.findViewById(R.id.crd_hikaye);
        crd_bulgu = view.findViewById(R.id.crd_bulgu);
        crd_sonuç = view.findViewById(R.id.crd_sonuç);
        rlcd_sikayet=view.findViewById(R.id.rlcd_sikayet);
        imgcd_sikayet=view.findViewById(R.id.ımgcd_sikayet);
        rlcd_hikaye=view.findViewById(R.id.rlcd_hikaye);
        imgcd_hikaye=view.findViewById(R.id.imgcd_hikaye);
        rlcd_bulgu=view.findViewById(R.id.rlcd_bulgu);
        imgcd_bulgu=view.findViewById(R.id.imgcd_bulgu);
        rlcd_sonuc=view.findViewById(R.id.rlcd_sonuc);
        imgcd_sonuc=view.findViewById(R.id.imgcd_sonuc);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnsave:
                Intent myIntent = new Intent(getActivity(), MainActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                this.startActivity(myIntent);
                break;
            case R.id.crd_sikayet:
                setdiscription("Şikayet");


                break;
            case R.id.crd_hikaye:
                setdiscription("Hikaye");

                break;
            case R.id.crd_bulgu:
                setdiscription("Bulgu");

                break;
            case R.id.crd_sonuç:
                setdiscription("Sonuç");

                break;
            default:
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void adddate() {
        final Dialog dl = new Dialog(getActivity());
        dl.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dl.setContentView(R.layout.dialogsetdate);

        dl.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        WindowManager.LayoutParams lp1 = new WindowManager.LayoutParams();
        lp1.copyFrom(dl.getWindow().getAttributes());
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int height1 = display.getHeight();
        int width1 = display.getWidth();

        lp1.width = width1;
        lp1.height = WindowManager.LayoutParams.WRAP_CONTENT;


        dl.getWindow().setAttributes(lp1);
        final DatePicker datepiker = dl.findViewById(R.id.datepiker);


        datepiker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                rldate.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                tvdate.setText(i + "." + i1 + "." + i2);
                dl.dismiss();

            }
        });


        dl.show();
    }

    public void setdiscription(final String string) {
        final Dialog dl = new Dialog(getActivity());
        dl.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dl.setContentView(R.layout.dialog_dis);

        dl.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        WindowManager.LayoutParams lp1 = new WindowManager.LayoutParams();
        lp1.copyFrom(dl.getWindow().getAttributes());
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int height1 = display.getHeight();
        int width1 = display.getWidth();

        lp1.width = width1;
        lp1.height = WindowManager.LayoutParams.WRAP_CONTENT;


        dl.getWindow().setAttributes(lp1);
        TextView tvdis = dl.findViewById(R.id.tvdis);
        TextView tvok = dl.findViewById(R.id.tvok);
        final EditText tverorDis = dl.findViewById(R.id.tverorDis);
        tvdis.setText(string);
        tvok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tverorDis.getText().length() > 1) {
                    switch (string) {
                        case "Şikayet":
                            imgcd_sikayet.setImageResource(R.drawable.ic_tick);
                            rlcd_sikayet.setBackgroundResource(R.drawable.boarder_bg);
                            break;
                        case "Hikaye":
                            imgcd_hikaye.setImageResource(R.drawable.ic_tick);
                            rlcd_hikaye.setBackgroundResource(R.drawable.boarder_bg);
                            break;
                        case "Bulgu":
                            imgcd_bulgu.setImageResource(R.drawable.ic_tick);
                            rlcd_bulgu.setBackgroundResource(R.drawable.boarder_bg);
                            break;
                        case "Sonuç":
                            imgcd_sonuc.setImageResource(R.drawable.ic_tick);
                            rlcd_sonuc.setBackgroundResource(R.drawable.boarder_bg);
                            break;
                        default:
                            break;
                    }
                }
                dl.dismiss();
            }
        });


        dl.show();
    }

}
