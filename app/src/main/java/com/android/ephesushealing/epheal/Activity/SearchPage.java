package com.android.ephesushealing.epheal.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ephesushealing.epheal.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;

public class SearchPage extends AppCompatActivity implements View.OnClickListener {
    TextView btnsil, btnara;
    EditText etname, etfamily, etid, etdate;
    ImageView imgerkek, imgkadin, imggroupa, imggroupb, imggroupab, imggroupo;
    SearchableSpinner searchspinner;
    ArrayAdapter<String> medeniAdapter;
    ArrayList<String> medeni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);
        fındbyId();
        medeni=new ArrayList<>();
        medeni.add("Bekar");
        medeni.add("Evli");
        medeni.add("Dul");
        medeni.add("Boşanmış");
        medeniAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item_center_white, medeni);
        medeniAdapter.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);
        searchspinner.setAdapter(medeniAdapter);
        btnara.setOnClickListener(this);
        btnsil.setOnClickListener(this);
        imggroupa.setOnClickListener(this);
        imggroupb.setOnClickListener(this);
        imggroupab.setOnClickListener(this);
        imggroupo.setOnClickListener(this);
        imgerkek.setOnClickListener(this);
        imgkadin.setOnClickListener(this);


    }

    public void fındbyId() {
        btnsil = findViewById(R.id.btnsil);
        btnara = findViewById(R.id.btnara);
        etname = findViewById(R.id.etname);
        etfamily = findViewById(R.id.etfamily);
        etid = findViewById(R.id.etid);
        imgerkek = findViewById(R.id.imgerkek);
        imgkadin = findViewById(R.id.imgkadin);
        etdate = findViewById(R.id.etdate);
        imggroupa = findViewById(R.id.imggroupa);
        imggroupb = findViewById(R.id.imggroupb);
        imggroupab = findViewById(R.id.imggroupab);
        imggroupo = findViewById(R.id.imggroupo);
        searchspinner=findViewById(R.id.searchspinner);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnara:
                Intent myIntent = new Intent(SearchPage.this, PatientList.class);
                SearchPage.this.startActivity(myIntent);
                break;
            case R.id.btnsil:
                etname.setText("");
                etfamily.setText("");
                etid.setText("");
                imgerkek.setBackgroundResource(R.drawable.checkbox);
                imgkadin.setBackgroundResource(R.drawable.deselectcheckbox);
                etdate.setText("");
                imggroupa.setBackgroundResource(R.drawable.checkbox);
                imggroupb.setBackgroundResource(R.drawable.deselectcheckbox);
                imggroupab.setBackgroundResource(R.drawable.deselectcheckbox);
                imggroupo.setBackgroundResource(R.drawable.deselectcheckbox);
                searchspinner.setSelection(0);

                break;
            case R.id.imggroupa:
                imggroupa.setBackgroundResource(R.drawable.checkbox);
                imggroupb.setBackgroundResource(R.drawable.deselectcheckbox);
                imggroupab.setBackgroundResource(R.drawable.deselectcheckbox);
                imggroupo.setBackgroundResource(R.drawable.deselectcheckbox);
                break;
            case R.id.imggroupb:
                imggroupb.setBackgroundResource(R.drawable.checkbox);
                imggroupa.setBackgroundResource(R.drawable.deselectcheckbox);
                imggroupab.setBackgroundResource(R.drawable.deselectcheckbox);
                imggroupo.setBackgroundResource(R.drawable.deselectcheckbox);
                break;
            case R.id.imgkadin:
                imgerkek.setBackgroundResource(R.drawable.deselectcheckbox);
                imgkadin.setBackgroundResource(R.drawable.checkbox);
                break;
            case R.id.imgerkek:
                imgerkek.setBackgroundResource(R.drawable.checkbox);
                imgkadin.setBackgroundResource(R.drawable.deselectcheckbox);

                break;

            case R.id.imggroupab:
                imggroupab.setBackgroundResource(R.drawable.checkbox);
                imggroupb.setBackgroundResource(R.drawable.deselectcheckbox);
                imggroupa.setBackgroundResource(R.drawable.deselectcheckbox);
                imggroupo.setBackgroundResource(R.drawable.deselectcheckbox);
                break;

            case R.id.imggroupo:
                imggroupo.setBackgroundResource(R.drawable.checkbox);
                imggroupb.setBackgroundResource(R.drawable.deselectcheckbox);
                imggroupab.setBackgroundResource(R.drawable.deselectcheckbox);
                imggroupa.setBackgroundResource(R.drawable.deselectcheckbox);
                break;



        }
    }
}
