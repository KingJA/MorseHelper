package sample.kingja.morsehelper;

import android.content.Context;
import android.hardware.Camera;
import android.widget.Toast;

/**
 * Description:TODO
 * Create Time:2017/9/15 11:14
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class CameraFlashlight implements FlashlightService {

    private Camera camera;
    private Camera.Parameters parameter;

    public CameraFlashlight(Context context) {
        try {
            if (camera == null) {
                camera = Camera.open();
                parameter = camera.getParameters();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context.getApplicationContext(), "Camera被占用，请先关闭", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void openFlashlight() {
        if (camera != null) {
            parameter.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(parameter);
            camera.startPreview();
        }
    }

    @Override
    public void closeFlashlight() {
        if (camera != null) {
            parameter.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(parameter);
            camera.stopPreview();
        }
    }

    @Override
    public void releaseFlashlight() {
        if (camera != null) {
            camera.setPreviewCallback(null);
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }


}
