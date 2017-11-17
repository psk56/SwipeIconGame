package psk.com.swipeicongame.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import psk.com.swipeicongame.R;
import psk.com.swipeicongame.global.AppMethod;
import psk.com.swipeicongame.global.PreferenceManager;
import psk.com.swipeicongame.interfaces.PreferenceInterface;

import static psk.com.swipeicongame.global.AppConstants.CURRENT_DATES;
import static psk.com.swipeicongame.global.AppConstants.DAILY_BONUS_DAY;
import static psk.com.swipeicongame.global.AppConstants.REDEEM_BONUS;
import static psk.com.swipeicongame.global.AppConstants.TOTAL_COINS;
import static psk.com.swipeicongame.global.AppConstants.YESTERDAY_BONUS_DAY;

/**
 * Created by OM on 1/13/2017.
 */

public class DailyBonusDialog extends DialogFragment implements View.OnClickListener {


    RelativeLayout day1, day2, day3, day4, day5, day6, day7;
    PreferenceManager preferenceManager;
    String dailyBonusDay, yesterdayDate;
    PreferenceInterface preferenceInterface;
    boolean isReedemTodayBonus = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        preferenceInterface = (PreferenceInterface) getContext();
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View dailyBonusDialog = inflater.inflate(R.layout.dialog_daily_bonus, container, false);
        initializeUI(dailyBonusDialog);
        checkDailyBonusDay();
        return dailyBonusDialog;
    }


    private void initializeUI(View v) {
        preferenceManager = new PreferenceManager(getContext());
        day1 = (RelativeLayout) v.findViewById(R.id.day1);
        day2 = (RelativeLayout) v.findViewById(R.id.day2);
        day3 = (RelativeLayout) v.findViewById(R.id.day3);
        day4 = (RelativeLayout) v.findViewById(R.id.day4);
        day5 = (RelativeLayout) v.findViewById(R.id.day5);
        day6 = (RelativeLayout) v.findViewById(R.id.day6);
        day7 = (RelativeLayout) v.findViewById(R.id.day7);

        day1.setOnClickListener(null);
        day2.setOnClickListener(null);
        day3.setOnClickListener(null);
        day4.setOnClickListener(null);
        day5.setOnClickListener(null);
        day6.setOnClickListener(null);
        day7.setOnClickListener(null);
    }


    private void checkDailyBonusDay() {

        isReedemTodayBonus = preferenceManager.getBoolean(REDEEM_BONUS);

        if (isReedemTodayBonus == false) {
            yesterdayDate = preferenceManager.getString(YESTERDAY_BONUS_DAY);


            String currentDates = preferenceManager.getString(CURRENT_DATES);
            int dailyBonusDay = preferenceManager.getInt(DAILY_BONUS_DAY);
/*        if (dailyBonusDay==0){
            dailyBonusDay=1;
        }*/
            if (dailyBonusDay == 7) {
                dailyBonusDay = 0;
            }
            if (currentDates.equals(yesterdayDate)) {
                dailyBonusDay = dailyBonusDay + 1;
            } else {
                dailyBonusDay = 1;
            }

            preferenceManager.putInt(DAILY_BONUS_DAY, dailyBonusDay);

            if (dailyBonusDay == 1) {
                setViewEnabled(day1);
            /*day1.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.radius_back));
            day1.setClickable(true);*/
            } else if (dailyBonusDay == 2) {
                setViewEnabled(day2);
            /*day2.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.radius_back));
            day2.setClickable(true);*/
            } else if (dailyBonusDay == 3) {
                setViewEnabled(day3);
            /*day3.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.radius_back));
            day3.setClickable(true);*/
            } else if (dailyBonusDay == 4) {
                setViewEnabled(day4);
            /*day4.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.radius_back));
            day4.setClickable(true);*/
            } else if (dailyBonusDay == 5) {
                setViewEnabled(day5);
            /*day5.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.radius_back));
            day5.setClickable(true);*/
            } else if (dailyBonusDay == 6) {
                setViewEnabled(day6);
           /* day6.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.radius_back));
            day6.setClickable(true);*/
            } else if (dailyBonusDay == 7) {
                setViewEnabled(day7);
            /*day7.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.radius_back));
            day7.setClickable(true);*/
            }
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.day1:
                setViewDisabled(day1, 100);
                Toast.makeText(getContext(), "Day 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.day2:
                setViewDisabled(day2, 125);
                Toast.makeText(getContext(), "Day 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.day3:
                setViewDisabled(day3, 150);
                Toast.makeText(getContext(), "Day 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.day4:
                setViewDisabled(day4, 175);
                Toast.makeText(getContext(), "Day 4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.day5:
                setViewDisabled(day5, 200);
                Toast.makeText(getContext(), "Day 5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.day6:
                setViewDisabled(day6, 250);
                Toast.makeText(getContext(), "Day 6", Toast.LENGTH_SHORT).show();
                break;
            case R.id.day7:
                setViewDisabled(day7, 300);
                Toast.makeText(getContext(), "Day 7", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void setViewEnabled(View view) {
        view.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.radius_back));
        view.setOnClickListener(this);
    }

    private void setViewDisabled(View view, int bonusPoint) {
        preferenceManager.putString(CURRENT_DATES, new SimpleDateFormat("dd/MM/yyyy", Locale.US).format(new Date()));
        int oldBonus = preferenceManager.getInt(TOTAL_COINS);
        int newBonusPoints = oldBonus + bonusPoint;
        preferenceManager.putInt(TOTAL_COINS, newBonusPoints);
        view.setBackground(ContextCompat.getDrawable(getContext(), R.color.secondary_text));
        view.setOnClickListener(null);
        preferenceInterface.notifyPreference();
        preferenceManager.putString(CURRENT_DATES, new SimpleDateFormat("dd/MM/yyyy", Locale.US).format(new Date()));
        preferenceManager.putString(YESTERDAY_BONUS_DAY, new SimpleDateFormat("dd/MM/yyyy", Locale.US).format(new Date()));
        preferenceManager.putBoolean(REDEEM_BONUS, true);
    }
}
