package com.android.ephesushealing.epheal.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.ephesushealing.epheal.R;

public class Search_details extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout imgpersonalinfo;
    TextView tvpersonalinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_profile_details);

        fındbyId();
        imgpersonalinfo.setOnClickListener(this);
        tvpersonalinfo.setOnClickListener(this);


    }
    public void fındbyId() {
        imgpersonalinfo=findViewById(R.id.imgpersonalinfo);
        tvpersonalinfo=findViewById(R.id.tvpersonalinfo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgpersonalinfo:
                Intent myIntent = new Intent(Search_details.this, Personalinfo.class);
                Search_details.this.startActivity(myIntent);
                break;
            case R.id.tvpersonalinfo:
                Intent myIntent1 = new Intent(Search_details.this, Personalinfo.class);
                Search_details.this.startActivity(myIntent1);
                break;



        }
    }
}
