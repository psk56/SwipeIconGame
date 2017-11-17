package psk.com.swipeicongame.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import psk.com.swipeicongame.R;

/**
 * Created by OM on 1/13/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {
    // Declare Variables
    Context context;
    String[] iconName;
    String[] price;
    int[] icon;
    LayoutInflater inflater;

    public ViewPagerAdapter(Context context, int[] icon, String[] iconName,
                            String[] price) {
        this.context = context;
        this.icon = icon;
        this.iconName = iconName;
        this.price = price;
    }

    @Override
    public int getCount() {
        return icon.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        TextView txtrank;
        TextView txtcountry;
        TextView txtpopulation;
        TextView imgflag;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item, container,
                false);

        // Locate the TextViews in viewpager_item.xml
        txtcountry = (TextView) itemView.findViewById(R.id.tvIconName);
        txtpopulation = (TextView) itemView.findViewById(R.id.tvIconPrice);

        // Capture position and set to the TextViews
        txtcountry.setText(iconName[position]);
        txtpopulation.setText(price[position]);

        // Locate the ImageView in viewpager_item.xml
        imgflag = (TextView) itemView.findViewById(R.id.shopIcon);
        // Capture position and set to the ImageView
        imgflag.setText(icon[position]);

        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((LinearLayout) object);

    }
}