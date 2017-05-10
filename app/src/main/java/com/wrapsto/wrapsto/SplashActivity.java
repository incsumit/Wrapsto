package com.wrapsto.wrapsto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        Thread t = new Thread()
        {
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                    Intent i = new Intent(SplashActivity.this, Login_Activity.class);
                    startActivity(i);
                    finish();
                }
                catch (InterruptedException e)
                {

                }
            }// End of run
        }
                ;

        t.start();
    }

}