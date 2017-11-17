package psk.com.swipeicongame.customicon;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by OM on 1/13/2017.
 */

public class cButton extends Button {
    Context context;
    public cButton(Context context) {
        super(context);
        this.context=context;
        Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/neuropol.ttf");
        setTypeface(face);
    }

    public cButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/neuropol.ttf");
        setTypeface(face);
    }

    public cButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/neuropol.ttf");
        setTypeface(face);
    }
}
