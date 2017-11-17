package psk.com.swipeicongame.view;

import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Random;

import psk.com.swipeicongame.R;
import psk.com.swipeicongame.dialog.GameOverDialog;
import psk.com.swipeicongame.dialog.PauseDialog;
import psk.com.swipeicongame.dialog.SettingsDialog;

public class PlayGameActivity extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener {

    TextView btnPause, playGameIcon, tvScoreCounter;
    GestureLibrary mLibrary;
    String iconName;
    int countScore = 0;
    ArrayList<String> arrayListIcons;
    final Random randomCurrentIcon = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        getIntentData();
        initializeUI();
        setupPlayGame();
    }


    private void getIntentData() {
        Intent intentIcon = getIntent();
        if (intentIcon != null) {
            iconName = intentIcon.getStringExtra("level_icon");
        }
    }


    private void initializeUI() {
        btnPause = (TextView) findViewById(R.id.btnPause);
        playGameIcon = (TextView) findViewById(R.id.playGameIcon);
        tvScoreCounter = (TextView) findViewById(R.id.tvScoreCounter);

        arrayListIcons=new ArrayList<>();

    }

    private void setupPlayGame() {
        playGameIcon.setText(iconName);

        mLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures);
        if (!mLibrary.load()) {
            finish();
        }

        GestureOverlayView gestures = (GestureOverlayView) findViewById(R.id.gestures);
        gestures.addOnGesturePerformedListener(this);

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openPauseDialog();
            }
        });
    }

    public void openPauseDialog(){
        FragmentManager fm = getSupportFragmentManager();
        PauseDialog settingsDialog = new PauseDialog().newInstance(PlayGameActivity.this,iconName);
        settingsDialog.show(fm, "pause");
    }


    @Override
    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
        ArrayList<Prediction> predictions = mLibrary.recognize(gesture);


        for (Prediction prediction : predictions) {
            if (prediction.score > 1.0) {
                String result = predictions.get(0).name;

                if ("8".equalsIgnoreCase(result)) {
                    Toast.makeText(this, "8", Toast.LENGTH_LONG).show();
                    changeRandomIcon();
                    return;
                } else if ("b".equalsIgnoreCase(result)) {
                    Toast.makeText(this, "b", Toast.LENGTH_LONG).show();
                    changeRandomIcon();
                    return;
                } else if ("c".equalsIgnoreCase(result)) {
                    Toast.makeText(this, "Reverce c", Toast.LENGTH_LONG).show();
                    changeRandomIcon();
                    return;
                }
            }else {
                gameOver();
                return;
            }
        }
    }

    public int countScore(int count) {
        count = count + 1;
        tvScoreCounter.setText("" + count);
        return count;
    }

    public void setLevelDifferentIcons(String level){

    }

    private void changeRandomIcon() {
        countScore = countScore(countScore);
        setListOfIcons("ok");
        changeCurrentIcon();
        //imageAnimation();

    }

    private void changeCurrentIcon() {
        int randomName;
        String iconName;
        randomName=randomCurrentIcon.nextInt(arrayListIcons.size());
        iconName=arrayListIcons.get(randomName);
        if (iconName.contains("red")) {
            playGameIcon.setTextColor(Color.RED);
            playGameIcon.setText("" + arrayListIcons.get(randomName));
        }else {
            playGameIcon.setText("" + arrayListIcons.get(randomName));
        }
    }


    public void imageAnimation() {
        Animation rotate = AnimationUtils.loadAnimation(PlayGameActivity.this, R.anim.scale_down);
        playGameIcon.startAnimation(rotate);
    }


    public void gameOver() {
        playGameIcon.setTextColor(Color.RED);
        Animation rotate = AnimationUtils.loadAnimation(PlayGameActivity.this, R.anim.vibrate_image);
        playGameIcon.startAnimation(rotate);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                openGameOverDialog();
            }
        }, 1000);

    }

    public void openGameOverDialog(){
        FragmentManager fm = getSupportFragmentManager();
        GameOverDialog settingsDialog = new GameOverDialog().newInstance(Integer.parseInt(tvScoreCounter.getText().toString()),iconName);
        settingsDialog.show(fm, "game_over");
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        openPauseDialog();
    }

    public void setListOfIcons(String levelName){

        arrayListIcons.add(getString(R.string.icon_normal_level1));
        arrayListIcons.add(getString(R.string.icon_normal_level3));
        arrayListIcons.add(getString(R.string.icon_normal_level2));
        arrayListIcons.add(getString(R.string.icon_normal_level1));
    }
}
