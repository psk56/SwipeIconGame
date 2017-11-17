package psk.com.swipeicongame.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import psk.com.swipeicongame.R;
import psk.com.swipeicongame.global.AppMethod;
import psk.com.swipeicongame.global.PreferenceManager;

import static psk.com.swipeicongame.global.AppConstants.PREFERENCE_MUSIC;

/**
 * Created by OM on 1/16/2017.
 */

public class SettingsDialog extends DialogFragment {


    TextView iconMusic, btnSettingOk, btnSettingCancel;
    PreferenceManager preferenceManager;
    boolean isMusicOn = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View settingsDialog = inflater.inflate(R.layout.dialog_settings, container, false);
        AppMethod.dialogAnimate(settingsDialog);
        initializeUI(settingsDialog);
        setupSettingDialog();
        return settingsDialog;
    }


    private void initializeUI(View view) {
        iconMusic = (TextView) view.findViewById(R.id.iconSound);
        btnSettingOk = (TextView) view.findViewById(R.id.btnSettingOk);
        btnSettingCancel = (TextView) view.findViewById(R.id.btnSettingCancel);

        preferenceManager = new PreferenceManager(getContext());
    }

    private void setupSettingDialog() {

        isMusicOn = preferenceManager.getBoolean(PREFERENCE_MUSIC);
        if (isMusicOn) {
            iconMusic.setText(getString(R.string.icon_music_on));
            isMusicOn=true;
        } else {
            iconMusic.setText(getString(R.string.icon_music_off));
            isMusicOn=false;
        }

        iconMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMusicOn) {
                    iconMusic.setText(getString(R.string.icon_music_off));
                    isMusicOn=false;
                } else {
                    iconMusic.setText(getString(R.string.icon_music_on));
                    isMusicOn=true;
                }
            }
        });

        btnSettingOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isMusicOn){
                    preferenceManager.putBoolean(PREFERENCE_MUSIC, true);
                }else {
                    preferenceManager.putBoolean(PREFERENCE_MUSIC, false);
                }
                getDialog().dismiss();
            }
        });

        btnSettingCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            getDialog().setCancelable(false);

        }
    }
}
