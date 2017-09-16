package sample.kingja.morsehelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {
    private String morse;
    private EditText et_morse;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, "发送完毕，耗时" + (System.currentTimeMillis() - startTime) + "ms", Toast
                    .LENGTH_SHORT).show();
        }
    };
    private ProgressDialog progressDialog;
    private long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FlashSir.getInstance().createCamera(MainActivity.this, handler);
        et_morse = (EditText) findViewById(R.id.et_morse);
        SeekBar  sb_count = (SeekBar) findViewById(R.id.sb_count);
        final TextView tv_count = (TextView) findViewById(R.id.tv_count);
        sb_count.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_count.setText("发送次数："+(progress+1));
                count=progress+1;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        long t = App.getSp().getLong("T", 0);
        Log.e(TAG, "t: " + t);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("发送中");
        if (t == 0) {
            showTestDialog();
        }

    }

    private void showTestDialog() {
        new AlertDialog.Builder(this)
                .setMessage("需要先进行闪光灯测试")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FlashSir.getInstance().testFlashlight();
                    }
                }).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FlashSir.getInstance().closeCamera();
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    private int count=3;
    public void send(View view) {
        morse = et_morse.getText().toString().trim().toUpperCase();
        morse = "{" + morse + "}";
        startTime = System.currentTimeMillis();
        progressDialog.show();
        FlashSir.getInstance().sendWordTimes(morse, count, 1000);
    }

}
