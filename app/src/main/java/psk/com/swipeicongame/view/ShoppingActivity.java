package psk.com.swipeicongame.view;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import psk.com.swipeicongame.R;
import psk.com.swipeicongame.adapter.ViewPagerAdapter;
import psk.com.swipeicongame.global.PreferenceManager;

import static psk.com.swipeicongame.global.AppConstants.TOTAL_COINS;

public class ShoppingActivity extends AppCompatActivity {

    TextView tvTotalIcons;
    ViewPager viewPager;
    PagerAdapter adapter;
    String[] rank;
    String[] iconName;
    String[] iconPrice;
    int[] icon;
    PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        // Generate sample data

        initializeUI();

        iconName=getResources().getStringArray(R.array.icon_name);

        iconPrice = getResources().getStringArray(R.array.icon_price);

        icon = new int[]{R.string.icon_challenge_level2, R.string.icon_challenge_level1,
                R.string.icon_challenge_level1, R.string.icon_challenge_level3,
                R.string.icon_challenge_level1};

        //icon = getResources().getIntArray(R.array.icon);

        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(ShoppingActivity.this, icon, iconName, iconPrice);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);


    }

    private void initializeUI() {
        preferenceManager=new PreferenceManager(getApplicationContext());
        tvTotalIcons=(TextView) findViewById(R.id.tvTotalIcons);
        tvTotalIcons.setText("$ "+preferenceManager.getInt(TOTAL_COINS));
    }
}
