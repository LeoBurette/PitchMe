package com.example.pitchme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.pitchme.word.DataSingleton;

public class MovieGestionActivity extends AppCompatActivity {
    ListView listView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_gestion);
        listView = findViewById(R.id.mgestionList);
        editText = findViewById(R.id.mgestionEdit);
        button = findViewById(R.id.mgestionButton);
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, DataSingleton.getInstance().getMovies());
        listView.setAdapter(adapter);
        final Context c = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSingleton.getInstance().addMovie(c, editText.getText().toString());
                editText.getText().clear();
            }
        });
        findViewById(R.id.mgestionButtonSuppression).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSingleton.getInstance().deleteMovie(c, editText.getText().toString());
                editText.getText().clear();
            }
        });
    }
}
