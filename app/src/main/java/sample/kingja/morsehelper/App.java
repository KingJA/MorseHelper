package sample.kingja.morsehelper;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Description:TODO
 * Create Time:2017/9/16 10:24
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class App extends Application {

    private static SharedPreferences sp;

    @Override
    public void onCreate() {
        super.onCreate();
        sp = getSharedPreferences("Morse", Context.MODE_PRIVATE);
    }

    public static SharedPreferences getSp() {
        return sp;
    }
}
