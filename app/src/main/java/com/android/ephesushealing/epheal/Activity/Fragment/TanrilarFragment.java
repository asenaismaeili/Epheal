package com.android.ephesushealing.epheal.Activity.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.android.ephesushealing.epheal.Activity.MainActivity;
import com.android.ephesushealing.epheal.R;

public class TanrilarFragment extends Fragment implements View.OnClickListener {
    View view;
    Integer height,width;
    RelativeLayout rldate;
    TextView btnsave,tvdate;
    ToggleButton toggele;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_muayene, container, false);
        findbyid();
        rldate.setLayoutParams(new RelativeLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT));

        return view;
    }
    public void findbyid() {
        rldate=view.findViewById(R.id.rldate);
        btnsave=view.findViewById(R.id.btnsave);
        toggele=view.findViewById(R.id.toggele);
        tvdate=view.findViewById(R.id.tvdate);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnsave:
                Intent myIntent = new Intent(getActivity(), MainActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                this.startActivity(myIntent);
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
                tvdate.setText(i+"."+i1+"."+i2);

            }
        });




        dl.show();
    }

}
