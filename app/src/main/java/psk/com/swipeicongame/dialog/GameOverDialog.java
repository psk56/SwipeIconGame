package psk.com.swipeicongame.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import psk.com.swipeicongame.R;
import psk.com.swipeicongame.global.AppMethod;
import psk.com.swipeicongame.global.PreferenceManager;
import psk.com.swipeicongame.view.MainActivity;
import psk.com.swipeicongame.view.PlayGameActivity;

import static psk.com.swipeicongame.global.AppConstants.GAME_HIGHEST_SCORE;
import static psk.com.swipeicongame.global.AppConstants.GAME_OVER_SCORE;
import static psk.com.swipeicongame.global.AppConstants.TOTAL_COINS;

/**
 * Created by OM on 1/16/2017.
 */

public class GameOverDialog extends DialogFragment {

    int gameOverScore, gameHigestScore, oldCoins, newCoins;

    TextView sharefb, shareTwitter;
    String iconName;

    public static GameOverDialog newInstance(int gameScore, String iconName) {
        Bundle args = new Bundle();

        GameOverDialog dialog = new GameOverDialog();
        args.putInt(GAME_OVER_SCORE, gameScore);
        args.putString("level_icon", iconName);
        dialog.setArguments(args);
        return dialog;
    }


    TextView iconMusic, btnSettingOk, btnSettingCancel, tvHighestScore, tvGameScore, tvGameOverCoins;
    PreferenceManager preferenceManager;
    Button btnGameOverMainMenu, btnReplay;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View gameOverDialog = inflater.inflate(R.layout.dialog_game_over, container, false);
        Bundle args = getArguments();
        if (args != null) {
            gameOverScore = args.getInt(GAME_OVER_SCORE);
            iconName = args.getString("level_icon");
        }

        AppMethod.dialogAnimate(gameOverDialog);
        initializeUI(gameOverDialog);
        setupGameOverDialog();
        return gameOverDialog;
    }


    private void initializeUI(View gameOverDialog) {
        tvGameScore = (TextView) gameOverDialog.findViewById(R.id.tvGameScore);
        tvHighestScore = (TextView) gameOverDialog.findViewById(R.id.tvHighestScore);
        tvGameOverCoins = (TextView) gameOverDialog.findViewById(R.id.tvGameOverCoins);

        sharefb = (TextView) gameOverDialog.findViewById(R.id.sharefb);
        shareTwitter = (TextView) gameOverDialog.findViewById(R.id.shareTwitter);

        btnGameOverMainMenu = (Button) gameOverDialog.findViewById(R.id.btnGameOverMainMenu);
        btnReplay = (Button) gameOverDialog.findViewById(R.id.btnReplay);

    }


    private void setupGameOverDialog() {
        preferenceManager = new PreferenceManager(getContext());
        gameHigestScore = preferenceManager.getInt(GAME_HIGHEST_SCORE);
        if (gameHigestScore == 0) {
            preferenceManager.putInt(GAME_HIGHEST_SCORE, gameOverScore);
        } else if (gameOverScore > gameHigestScore) {
            preferenceManager.putInt(GAME_HIGHEST_SCORE, gameOverScore);
        }
        gameHigestScore = preferenceManager.getInt(GAME_HIGHEST_SCORE);
        tvHighestScore.setText("" + gameHigestScore);
        tvGameScore.setText("" + gameOverScore);
        tvGameOverCoins.setText("+" + gameOverScore);

        oldCoins = preferenceManager.getInt(TOTAL_COINS);
        newCoins = oldCoins + gameOverScore;
        preferenceManager.putInt(TOTAL_COINS, newCoins);


        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRestart = new Intent(getContext(), PlayGameActivity.class);
                intentRestart.putExtra("level_icon", iconName);
                startActivity(intentRestart);
                getActivity().finish();
            }
        });

        btnGameOverMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMainMenu = new Intent(getContext(), MainActivity.class);
                intentMainMenu.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentMainMenu);
                getActivity().finish();
            }
        });

        sharefb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppMethod.shareToFacebook(view, "Wow! I swiped " + gameOverScore + " icons in swipe arrow game \n\n https://play.google.com/store/apps/details?id=com.doctor_app.activity/");
            }
        });
        shareTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppMethod.shareToTwitter(view, "Wow! I swiped "+gameOverScore+ " icons in swipe arrow game \\n\\n https://play.google.com/store/apps/details?id=com.doctor_app.activity/\"");
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        setCancelable(false);
    }
}