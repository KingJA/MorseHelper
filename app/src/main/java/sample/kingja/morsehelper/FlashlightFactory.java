package sample.kingja.morsehelper;

import android.content.Context;
import android.os.Build;
import android.util.Log;

/**
 * Description:TODO
 * Create Time:2017/9/15 11:21
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FlashlightFactory {
    public static FlashlightService getFlashlight(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.e("FlashlightFactory", "Build.VERSION.SDK_INT"+ Build.VERSION.SDK_INT+"，创建Camera2Flashlight" );
            return new Camera2Flashlight(context);
        } else {
            Log.e("FlashlightFactory", "Build.VERSION.SDK_INT"+ Build.VERSION.SDK_INT+"，创建CameraFlashlight" );
            return new CameraFlashlight(context);
        }
    }
}
