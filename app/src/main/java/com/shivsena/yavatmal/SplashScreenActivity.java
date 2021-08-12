package com.shivsena.yavatmal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    public static final int  SPALSH_SCREEN =5000;
    //variable
    Animation topAnim,bottomAnim;
    ImageView image;
    TextView slogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //hooks
        image = findViewById(R.id.iv_splash);
        slogan = findViewById(R.id.tv_slogan);

        //Setting Animation
        image.setAnimation(topAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                checkConnection();

            }
        },SPALSH_SCREEN);
    }

    private void checkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();

        SharedPreferences preferences = getSharedPreferences(LoginActivity.FILE_NAME,MODE_PRIVATE);
        String myEmail = preferences.getString(LoginActivity.MY_NAME,"");

        if(null != activeNetwork){
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
                if (myEmail != ""){
                    startActivity(new Intent(SplashScreenActivity.this,HomeActivity.class));
                    SplashScreenActivity.this.finish();
                }
                else {
                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    SplashScreenActivity.this.finish();
                }
            }
            else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                if (myEmail != ""){
                    startActivity(new Intent(SplashScreenActivity.this,HomeActivity.class));
                    SplashScreenActivity.this.finish();
                }
                else {
                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    SplashScreenActivity.this.finish();
                }
            }
        }
        else{
            Intent intent= new Intent(SplashScreenActivity.this,NoInternetConnection.class);
            startActivity(intent);
            SplashScreenActivity.this.finish();
        }
    }
}