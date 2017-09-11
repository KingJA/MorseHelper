package sample.kingja.morsehelper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private String morse;
    private EditText et_morse;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this,"发送完毕，耗时"+ (System.currentTimeMillis() - startTime) +"ms",Toast.LENGTH_SHORT).show();
        }
    };
    private ProgressDialog progressDialog;
    private long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_morse = (EditText) findViewById(R.id.et_morse);
        FlashSir.getInstance().createCamera(this,handler);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("发送中");
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        FlashSir.getInstance().closeCamera();
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog=null;
        }
    }

    public void send(View view) {
        morse = et_morse.getText().toString().trim().toUpperCase();
        morse="{"+morse+"}";
        startTime = System.currentTimeMillis();
        progressDialog.show();

        FlashSir.getInstance().sendWordTimes(morse, 3, 600);
    }

}
