package psk.com.swipeicongame;

import android.app.Application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import psk.com.swipeicongame.global.PreferenceManager;

import static psk.com.swipeicongame.global.AppConstants.CURRENT_DATES;
import static psk.com.swipeicongame.global.AppConstants.PREFERENCE_MUSIC;

/**
 * Created by OM on 1/17/2017.
 */

public class SwipeArrowApplication extends Application {

    private PreferenceManager pref;
    String dailyPreference;

    boolean musicPreference;
    @Override
    public void onCreate() {
        super.onCreate();
        getPrefManager();
        checkPreference();
    }

    private void checkPreference() {
        dailyPreference=pref.getString(CURRENT_DATES);

        if (dailyPreference==null){
            pref.putString(CURRENT_DATES,"");
        }

    }

    public PreferenceManager getPrefManager() {
        if (pref == null) {
            pref = new PreferenceManager(this);
        }
        return pref;
    }

}
