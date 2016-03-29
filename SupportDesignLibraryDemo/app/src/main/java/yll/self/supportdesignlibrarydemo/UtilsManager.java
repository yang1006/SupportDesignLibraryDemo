package yll.self.supportdesignlibrarydemo;

import android.content.Context;
import android.util.Log;

/**
 * Created by yll on 2016/1/19.
 */
public class UtilsManager {

    public static void log(String s){
        Log.e("yll", s);
    }

    /**dp 转 px*/
    public static int dip2px(Context context, float dp){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
