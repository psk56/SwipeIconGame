package psk.com.swipeicongame.customicon;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by OM on 1/12/2017.
 */

public class cIcon extends TextView {
    Context context;
    public cIcon(Context context) {
        super(context);
        this.context=context;
        Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/fontawesome-webfont.ttf");
        setTypeface(face);
    }

    public cIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/fontawesome-webfont.ttf");
        setTypeface(face);
    }

    public cIcon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/fontawesome-webfont.ttf");
        setTypeface(face);
    }
}
