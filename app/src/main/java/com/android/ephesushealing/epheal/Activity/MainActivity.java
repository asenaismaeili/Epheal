package com.android.ephesushealing.epheal.Activity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.Toast;

import com.android.ephesushealing.epheal.R;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    GridLayout mainGrid;
    private CardView hastaAraCard,yeniMuayeneCard,raporlarCard,formlarCard,KDScard, KadinAsiCard, AsiKontrolCard, IzlemCard, TakipCard, TakvimCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



fındbyId();

hastaAraCard.setOnClickListener(this);
yeniMuayeneCard.setOnClickListener(this);
KDScard.setOnClickListener(this);
IzlemCard.setOnClickListener(this);


    }



    public void fındbyId() {
    mainGrid = (GridLayout) findViewById(R.id.mainGrid);
    hastaAraCard = (CardView) findViewById(R.id.hasta_ara);
    yeniMuayeneCard = (CardView) findViewById(R.id.crd_Yeni_Muayene);
    raporlarCard = (CardView) findViewById(R.id.crd_Raporlar);
    formlarCard = (CardView) findViewById(R.id.crd_Formlar);
    KDScard = (CardView) findViewById(R.id.crd_KDS);
    //KadinAsiCard = (CardView) findViewById(R.id.crd_KadinAsi);
    AsiKontrolCard = (CardView) findViewById(R.id.crd_Asi_Kontrol);
    IzlemCard = (CardView) findViewById(R.id.crd_Izlem);
    TakipCard = (CardView) findViewById(R.id.crd_Takip);
    TakvimCard = (CardView) findViewById(R.id.crd_Takvim);
}


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.crd_Yeni_Muayene:
                Intent myIntent = new Intent(MainActivity.this, BeforeMuayene.class);
                MainActivity.this.startActivity(myIntent);
                break;
            case R.id.hasta_ara:
                Intent myIntent1 = new Intent(MainActivity.this, SearchPage.class);
                MainActivity.this.startActivity(myIntent1);
                break;
            case R.id.crd_KDS:
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                Toast.makeText(this, "Locale in English !", Toast.LENGTH_LONG).show();
                break;
            case R.id.crd_Izlem:
                Locale locale1 = new Locale("tr");
                Locale.setDefault(locale1);
                Configuration config1 = new Configuration();
                config1.locale = locale1;
                getBaseContext().getResources().updateConfiguration(config1, getBaseContext().getResources().getDisplayMetrics());
                Toast.makeText(this, "Locale in turkıs !", Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(this, MainActivity.class);
                startActivity(refresh);
                finish();
                break;


        }
    }

}
