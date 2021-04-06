package com.example.pitchme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.pitchme.word.DataSingleton;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });

        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        DataSingleton.getInstance().readMovies(this);
        ((Button)findViewById(R.id.buttonPlay)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beforePlay = new Intent(MainActivity.this, SelectPlayerActivity.class);
                startActivity(beforePlay);
            }
        });
        (findViewById(R.id.buttonAddMovie)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMovie = new Intent(MainActivity.this, MovieGestionActivity.class);
                startActivity(addMovie);
            }
        });
        (findViewById(R.id.buttonInformation)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent information = new Intent(MainActivity.this, InformationActivity.class);
                startActivity(information);

            }
        });
    }
}
