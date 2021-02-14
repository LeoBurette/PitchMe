package com.example.pitchme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pitchme.word.Dictionnaire;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {
    TextView timer ;
    TextView name ;
    ListView listView;
    Button button ;
    TextView informations ;
    RecyclerView recyclerView;
    ArrayList<String> movies;
    ArrayList<String> names;
    final Handler timerHandler = new Handler();
    Runnable timerRunnable;
    long startTime = 0;
    Map<String, Integer> score;
    int scoreActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        scoreActual = 0;
        score = new HashMap<String, Integer>();
        timer = (TextView)findViewById(R.id.playTimer);
        name = (TextView)findViewById(R.id.playName);
        button = (Button)findViewById(R.id.playButton);
        informations = (TextView)findViewById(R.id.playInformation);
        listView = (ListView)findViewById(R.id.playListName);
        recyclerView = (RecyclerView)findViewById(R.id.playListPlayer);

        setVisibilityGame(false);

        names = getIntent().getStringArrayListExtra("Joueurs");

        for(String s : names){
            score.put(s,0);
        }
        movies = getIntent().getStringArrayListExtra("Films");

        startGame(0);
    }

    private void startGame(int nbJoueur){
        if(movies.size()<1){
            endPartie();
            return;
        }

        if(!(nbJoueur<names.size()))
            nbJoueur = 0;

        String s = "Le prochain joueur est " + names.get(nbJoueur) + ". Appuie sur Dévoiler quand tu est prêt.";
        name.setText(s);

        initTimer();

        generateInformation();

        final int finalNbJoueur = nbJoueur;
        final int finalNbJoueur1 = nbJoueur;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime = System.currentTimeMillis();
                timerHandler.postDelayed(timerRunnable, 0);
                setVisibilityGame(true);
                button.setText("Joueur suivant");
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopTimer();
                        button.setText("Dévoiller");
                        calculateScore(finalNbJoueur1);
                        setVisibilityGame(false);
                        startGame(finalNbJoueur + 1);
                    }
                });
            }
        });
    }

    private void calculateScore(int nbJoueur){
        score.put(names.get(nbJoueur), score.get(names.get(nbJoueur)) + scoreActual);
        scoreActual = 0;
    }

    private void initTimer(){
        timerRunnable = new Runnable() {

            @Override
            public void run() {
                long millis = System.currentTimeMillis() - startTime;
                int seconds = (int) (millis / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;

                timer.setText(String.format("%d:%02d", minutes, seconds));

                timerHandler.postDelayed(this, 500);
                if(minutes>1){
                    stopTimer();
                }
            }
        };
    }

    private void endPartie(){
        Intent intent = new Intent(PlayActivity.this, EndParty.class);
        intent.putExtra("winner", (Serializable) score);
        startActivity(intent);
    }

    private void stopTimer(){
        timerHandler.removeCallbacks(timerRunnable);
        CharSequence txt = "Fin du temps !";
        Toast toast = Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_SHORT);
        toast.show();
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateInformation(){
        int sizeMovie = movies.size();
        Random r = new Random();
        int nbMovie = r.nextInt(sizeMovie);
        String s = "Votre film est : " + movies.get(nbMovie);
        movies.remove(nbMovie);
        informations.setText(s);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                scoreActual++;
            }
        });
        String[] strings = new String[10];
         for(int i = 0; i < 10; i++){
             strings[i] = Dictionnaire.getInstance().getRandom();
         }
         listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, strings));

         recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
         final RecyclerListAdaptater adapter = new RecyclerListAdaptater(this, names);
         recyclerView.setAdapter(adapter);
         adapter.setClickListener(new RecyclerListAdaptater.ItemClickListener() {
             @Override
             public void onItemClick(View view, int position) {
                 score.put(adapter.getName(position), score.get(adapter.getName(position))-1);
             }
         });
    }

    private void setVisibilityGame(boolean val){
        int visibility = (val)?View.VISIBLE:View.INVISIBLE;
        listView.setVisibility(visibility);
        recyclerView.setVisibility(visibility);
        informations.setVisibility(visibility);
    }
}