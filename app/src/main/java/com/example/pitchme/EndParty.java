package com.example.pitchme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.HashMap;
import java.util.Map;

public class EndParty extends AppCompatActivity {
    private InterstitialAd minterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_party);
        TextView txt = (TextView)findViewById(R.id.endName);
        Map<String, Integer> map = (HashMap<String,Integer>)getIntent().getSerializableExtra("winner");
        String s = "Fin de la partie ! Les scores sont :";
        for( String t : map.keySet()){
            s += "\n- " + t + " : " + map.get(t) + " points";
        }
        txt.setText(s);
        final Button button = (Button)findViewById(R.id.endButton);
        button.setVisibility(View.INVISIBLE);
        AdRequest adRequest = new AdRequest.Builder().build();

        minterstitialAd = new InterstitialAd(this);
        minterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded(){
                button.setVisibility(View.VISIBLE);
            }
        });
        minterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        minterstitialAd.loadAd(adRequest);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(minterstitialAd != null){
                    minterstitialAd.show();
                    minterstitialAd = null;
                }else{
                    Intent intent = new Intent(EndParty.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}
