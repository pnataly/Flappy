package com.example.flappybird;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class GameOverActivity extends AppCompatActivity {

    private Button restartButton, exitButton;
    private TextView scoreTv, personalBestTv, highLevelTv;
    private int score, level;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        restartButton = findViewById(R.id.restart);
        exitButton = findViewById(R.id.exit);
        scoreTv = findViewById(R.id.score);
        personalBestTv = findViewById(R.id.personalBest);
        highLevelTv = findViewById(R.id.highLevel);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        score = getIntent().getIntExtra("score", 0);
        level = getIntent().getIntExtra("level", 1);

        SharedPreferences sp = getSharedPreferences("MyPref", 0);
        int scoreSp = sp.getInt("score", 0);
        SharedPreferences.Editor editor = sp.edit();
        if(score > scoreSp){
            scoreSp = score;
            editor.putInt("score", scoreSp);
            editor.commit();
        }
        scoreTv.setText(String.valueOf(score));
        personalBestTv.setText(String.valueOf(scoreSp));

        int levelSp = sp.getInt("level", 1);
        if(level > levelSp){
            levelSp = level;
            editor.putInt("level", levelSp);
            editor.commit();
        }
        highLevelTv.setText(String.valueOf(levelSp));

        interstitialAd.setAdListener(new AdListener()
                                     {
                                         @Override
                                         public void onAdClosed() {
                                             interstitialAd.loadAd(new AdRequest.Builder().build());
                                             startActivity(new Intent(GameOverActivity.this, MainActivity.class));
                                             finish();
                                         }
                                     }

        );

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }
                else{
                    startActivity(new Intent(GameOverActivity.this, MainActivity.class));
                    finish();
                }
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
