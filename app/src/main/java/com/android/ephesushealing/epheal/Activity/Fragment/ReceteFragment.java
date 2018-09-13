package com.android.ephesushealing.epheal.Activity.Fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.ephesushealing.epheal.Activity.Adapter.IlacAdapter;
import com.android.ephesushealing.epheal.Activity.Model.IlacList;
import com.android.ephesushealing.epheal.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;

public class ReceteFragment extends Fragment {
    View view;
    Integer height, width;
    LinearLayout layoutlist;
    TextView btnartir;
    ArrayList<String> kulanmasekli,perbars;
    ArrayAdapter<String> kulAdapter,perAdapter;
    SearchableSpinner kulspinner,perspinner;
    ArrayList<IlacList> ilacLists;
    RecyclerView rvilac;
    LinearLayout.LayoutParams layoutParams;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recete, container, false);
        findbyid();
        layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0);
        layoutParams.weight=0;
        layoutlist.setLayoutParams(layoutParams);
        kulanmasekli=new ArrayList<>();
        ilacLists=new ArrayList<>();
        kulanmasekli.add("Ağızdan");
        kulanmasekli.add("Enjeksiyon");
        kulanmasekli.add("Cilt Üzerinden");
        perbars=new ArrayList<>();
        perbars.add("Gün");
        perbars.add("2 Günde Bir");
        perbars.add("Haftada");
        perbars.add("Ayda");
        kulAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item_center_white, kulanmasekli);
        kulAdapter.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);
        perAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item_center_white, perbars);
        perAdapter.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);
        kulspinner.setAdapter(kulAdapter);
        perspinner.setAdapter(perAdapter);
        btnartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ilacLists.add(new IlacList());
                IlacAdapter adapter = new IlacAdapter(ilacLists);
                rvilac.setAdapter(adapter);
                layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0);
                layoutParams.weight=39;
                layoutlist.setLayoutParams(layoutParams);

            }
        });
        return view;
    }

    public void getDisplay() {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        height = display.getHeight();
        width = display.getWidth();
    }

    public void findbyid() {
        layoutlist=view.findViewById(R.id.layoutlist);
        btnartir=view.findViewById(R.id.btnartir);
        kulspinner=view.findViewById(R.id.kulspinner);
        perspinner=view.findViewById(R.id.perspinner);
        rvilac=view.findViewById(R.id.rvilac);

    }
    public void dialog(String error, String discription) {
        final Dialog dl = new Dialog(getActivity());
        dl.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dl.setContentView(R.layout.dialog_error);

        dl.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        WindowManager.LayoutParams lp1 = new WindowManager.LayoutParams();
        lp1.copyFrom(dl.getWindow().getAttributes());
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int height1 = display.getHeight();
        int width1 = display.getWidth();

        lp1.width = width1;
        lp1.height = WindowManager.LayoutParams.WRAP_CONTENT;


        dl.getWindow().setAttributes(lp1);
        TextView tveror = (TextView) dl.findViewById(R.id.tveror);
        TextView tvok = (TextView) dl.findViewById(R.id.tvok);
        TextView tverorDis = (TextView) dl.findViewById(R.id.tverorDis);
        tverorDis.setText(discription);
        tveror.setText(error);

        tvok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dl.dismiss();
            }
        });
//
        dl.show();


    }
}

