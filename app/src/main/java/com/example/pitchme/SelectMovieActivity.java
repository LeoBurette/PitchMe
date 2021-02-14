package com.example.pitchme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectMovieActivity extends AppCompatActivity {
    ArrayList<String> movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        movie = new ArrayList<String>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_movie);
        ArrayList<String> array = (ArrayList<String>)this.getIntent().getStringArrayListExtra("array");

        final EditText edit1 = (EditText)findViewById(R.id.editFilm1);
        final EditText edit2 = (EditText)findViewById(R.id.editFilm2);
        final EditText edit3 = (EditText)findViewById(R.id.editFilm3);

        print(array, edit1, edit2, edit3, 0);
    }

    public void print(final ArrayList arrayList, final EditText edit1, final EditText edit2, final EditText edit3, final int i){
        if(i<arrayList.size()){
            String next = "C'est à " + arrayList.get(i) + " de choisir ses films. Veuillez en mettre au minimum 1, maximum 3. Tout le monde doit les connaitre";
            ((TextView)findViewById(R.id.selectText)).setText(next);
            ((Button)findViewById(R.id.selectButton)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!edit1.getText().toString().isEmpty()){
                        movie.add(edit1.getText().toString());
                        edit1.getText().clear();
                    }
                    if(!edit2.getText().toString().isEmpty()){
                        movie.add(edit2.getText().toString());
                        edit2.getText().clear();
                    }
                    if(!edit3.getText().toString().isEmpty()){
                        movie.add(edit3.getText().toString());
                        edit3.getText().clear();
                    }
                    print(arrayList, edit1, edit2, edit3, i+1);
                }
            });
        } else {
            Intent intent = new Intent(SelectMovieActivity.this, PlayActivity.class);
            intent.putExtra("Joueurs", arrayList);
            intent.putExtra("Films", movie);
            startActivity(intent);
        }
    }
}
