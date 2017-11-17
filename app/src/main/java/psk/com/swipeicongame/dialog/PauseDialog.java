package psk.com.swipeicongame.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import psk.com.swipeicongame.R;
import psk.com.swipeicongame.global.AppMethod;
import psk.com.swipeicongame.view.MainActivity;
import psk.com.swipeicongame.view.PlayGameActivity;

/**
 * Created by OM on 1/16/2017.
 */

public class PauseDialog extends DialogFragment {


    TextView iconMusic;
    Button btnPauseResume,btnPauseRestart,btnPauseMainMenu;
    public  static Activity mContext;
    public static String iconnName;

    public static PauseDialog newInstance(Activity context,String iconName){
        PauseDialog dialog = new PauseDialog();
        mContext=context;
        iconnName=iconName;
        return dialog;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        final View pauseDialog = inflater.inflate(R.layout.dialog_pause, container, false);


        AppMethod.dialogAnimate(pauseDialog);



        initializeUI(pauseDialog);
        setupPauseDialog();
        return pauseDialog;
    }

    private void initializeUI(View pauseDialog) {
        btnPauseResume=(Button) pauseDialog.findViewById(R.id.btnPauseResume);
        btnPauseRestart=(Button) pauseDialog.findViewById(R.id.btnPauseRestart);
        btnPauseMainMenu=(Button) pauseDialog.findViewById(R.id.btnPauseMainMenu);
    }

    private void setupPauseDialog() {
        btnPauseResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });


        btnPauseRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentRestart=new Intent(getContext(), PlayGameActivity.class);
                intentRestart.putExtra("level_icon",iconnName);
                startActivity(intentRestart);
                getActivity().finish();
            }
        });

        btnPauseMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMainMenu=new Intent(getContext(),MainActivity.class);
                intentMainMenu.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentMainMenu);
                getActivity().finish();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        setCancelable(false);
    }
}