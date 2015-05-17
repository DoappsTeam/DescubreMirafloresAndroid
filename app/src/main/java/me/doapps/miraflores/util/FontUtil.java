package me.doapps.miraflores.util;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by jonathan on 17/05/2015.
 */
public class FontUtil {
    public static Typeface setConconBold(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/coconbold.otf");
    }
}
