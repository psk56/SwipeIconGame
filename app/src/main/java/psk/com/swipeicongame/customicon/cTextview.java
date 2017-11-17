package psk.com.swipeicongame.customicon;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by OM on 1/13/2017.
 */

public class cTextview extends TextView {

    Context context;
    public cTextview(Context context) {
        super(context);
        this.context=context;
        Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/neuropol.ttf");
        setTypeface(face);
    }

    public cTextview(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/neuropol.ttf");
        setTypeface(face);
    }

    public cTextview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/neuropol.ttf");
        setTypeface(face);
    }
}
