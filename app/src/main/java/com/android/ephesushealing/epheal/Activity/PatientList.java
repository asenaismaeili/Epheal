package com.android.ephesushealing.epheal.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.ephesushealing.epheal.Activity.Adapter.PatientAdapter;
import com.android.ephesushealing.epheal.Activity.Model.ItemClickSupport;
import com.android.ephesushealing.epheal.Activity.Model.PatientCardModel;
import com.android.ephesushealing.epheal.R;

import java.util.ArrayList;

public class PatientList extends AppCompatActivity {
    ArrayList<PatientCardModel> patientCardModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_patient);
        RecyclerView recyclerView = findViewById(R.id.rllıst);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        patientCardModels=new ArrayList<>();
        PatientAdapter adapter = new PatientAdapter( patientCardModels,0);
        recyclerView.setAdapter(adapter);



    }
}
