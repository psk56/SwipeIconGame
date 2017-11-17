package psk.com.swipeicongame.global;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

/**
 * Created by z0019cd on 3/12/16.
 */
public class PreferenceManager {

    private String TAG = PreferenceManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "psk.com.swipeicongame";

    // All Shared Preferences Keys
    private static final String KEY_NOTIFICATIONS = "notifications";

    // Constructor
    public PreferenceManager(Context context) {
        this.context = context;
        pref = this.context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key) {
        return pref.getString(key, null);
    }

    public int getInt(String key) {
        return pref.getInt(key, 0);
    }

    public float getFloat(String key) {
        return pref.getFloat(key, 0);
    }


    public void putFloat(String key, Float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    public void putBoolean(String key, Boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBoolean(String key) {
        return pref.getBoolean(key, false);
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public void putStringSet(String key, Set<String> value) {
        editor.putStringSet(key, value);
        editor.commit();
    }

    public void clearPrefs() {
        editor.clear();
        editor.commit();
    }

    public boolean contains(String key) {
        return pref.contains(key);
    }
}
