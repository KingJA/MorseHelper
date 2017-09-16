package sample.kingja.morsehelper;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Description:TODO
 * Create Time:2017/9/15 11:14
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Camera2Flashlight implements FlashlightService {

    private final CameraManager manager;

    public Camera2Flashlight(Context context) {
        manager = (CameraManager) context.getApplicationContext().getSystemService(Context.CAMERA_SERVICE);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void openFlashlight() {
        try {
            manager.setTorchMode("0", true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void closeFlashlight() {
        try {
            manager.setTorchMode("0", false);
        } catch (CameraAccessException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void releaseFlashlight() {

    }


}
