package com.example.pitchme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class BeforePlayActivity extends AppCompatActivity {
    ListView list;
    private ArrayList<String> prenoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_play);
        prenoms = new ArrayList<String>();
        list = (ListView)findViewById(R.id.list);
        final EditText edit = ((EditText)findViewById(R.id.editname));
        ((Button)findViewById(R.id.addButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(edit.getText().toString().isEmpty())){
                    prenoms.add(edit.getText().toString());
                    edit.getText().clear();
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(BeforePlayActivity.this, android.R.layout.simple_list_item_1 ,  prenoms);
                    list.setAdapter(adapter);
                }
            }
        });
        ((Button)findViewById(R.id.launchButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeforePlayActivity.this, SelectMovieActivity.class);
                intent.putExtra("array", prenoms);
                startActivity(intent);
            }
        });
    }
}
