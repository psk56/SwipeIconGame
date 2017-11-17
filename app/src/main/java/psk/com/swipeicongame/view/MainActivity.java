package psk.com.swipeicongame.view;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.Image;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import psk.com.swipeicongame.R;
import psk.com.swipeicongame.dialog.DailyBonusDialog;
import psk.com.swipeicongame.dialog.SettingsDialog;
import psk.com.swipeicongame.fragment.SelectLevelFragment;
import psk.com.swipeicongame.global.AppMethod;
import psk.com.swipeicongame.global.PreferenceManager;
import psk.com.swipeicongame.interfaces.PreferenceInterface;

import static psk.com.swipeicongame.global.AppConstants.CURRENT_DATES;
import static psk.com.swipeicongame.global.AppConstants.DAILY_BONUS_DAY;
import static psk.com.swipeicongame.global.AppConstants.REDEEM_BONUS;
import static psk.com.swipeicongame.global.AppConstants.TOTAL_COINS;
import static psk.com.swipeicongame.global.AppConstants.YESTERDAY_BONUS_DAY;

public class MainActivity extends AppCompatActivity implements PreferenceInterface {

    Button btnPlayGame, btnHowToPlay;
    TextView iconDailyBonus, iconSettings, btnShareFb, btnShareTwitter, tvTotalCoins;
    ImageView btnShopIcon;
    PreferenceManager preferenceManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
        checkDailyBonusDialog();
        setupHomeScreen();
    }


    private void initializeUI() {
        preferenceManager = new PreferenceManager(getApplicationContext());
        btnPlayGame = (Button) findViewById(R.id.btnPlayGame);
        btnHowToPlay = (Button) findViewById(R.id.btnHowToPlay);
        btnShopIcon = (ImageView) findViewById(R.id.btnShopIcon);
        iconDailyBonus = (TextView) findViewById(R.id.iconDailyBonus);
        iconSettings = (TextView) findViewById(R.id.iconSettings);
        tvTotalCoins = (TextView) findViewById(R.id.tvTotalCoins);

        btnShareFb = (TextView) findViewById(R.id.btnShareFb);
        btnShareTwitter = (TextView) findViewById(R.id.btnShareTwitter);
    }


    private void setupHomeScreen() {
        tvTotalCoins.setText("" + preferenceManager.getInt(TOTAL_COINS));

        btnPlayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSelectLevel = new Intent(MainActivity.this, SelectLevelActivity.class);
                startActivity(intentSelectLevel);


                /*SelectLevelFragment myf = new SelectLevelFragment();

                android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.gameContainer, myf);
                transaction.commit();*/

            }
        });

        iconDailyBonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getSupportFragmentManager();
                DailyBonusDialog commentPopupDialog = new DailyBonusDialog();
                commentPopupDialog.show(fm, "ok");
            }
        });

        btnShopIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentShopIcon = new Intent(MainActivity.this, ShoppingActivity.class);
                startActivity(intentShopIcon);
            }
        });

        btnHowToPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.playSoundEffect(android.view.SoundEffectConstants.CLICK);
            }
        });

        iconSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                SettingsDialog settingsDialog = new SettingsDialog();
                settingsDialog.show(fm, "settings");
            }
        });

        btnShareFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareToFacebook(view);
            }
        });

        btnShareTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareToTwitter(view);
            }
        });
    }

    public void shareToFacebook(View v) {
        AppMethod.shareToFacebook(v,"https://play.google.com/store/apps/details?id=com.doctor_app.activity/");
    }


    public void shareToTwitter(View v) {
        AppMethod.shareToTwitter(v,"Swipe Arrow Game\nhttps://play.google.com/store/apps/details?id=com.doctor_app.activity/");
    }


    private void checkDailyBonusDialog() {

        if (preferenceManager.getString(CURRENT_DATES).equals(new SimpleDateFormat("dd/MM/yyyy", Locale.US).format(new Date()))) {
            preferenceManager.putString(YESTERDAY_BONUS_DAY, new SimpleDateFormat("dd/MM/yyyy", Locale.US).format(new Date()));
        } else {
            FragmentManager fm = getSupportFragmentManager();
            DailyBonusDialog commentPopupDialog = new DailyBonusDialog();
            commentPopupDialog.show(fm, "ok");
            preferenceManager.putBoolean(REDEEM_BONUS, false);
        }
    }


    @Override
    public void notifyPreference() {
        tvTotalCoins.setText("" + preferenceManager.getInt(TOTAL_COINS));

    }
}
