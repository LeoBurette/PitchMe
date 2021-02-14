package com.example.pitchme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class EndParty extends AppCompatActivity {

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
        Button button = (Button)findViewById(R.id.endButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndParty.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
