package com.shivsena.yavatmal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoInternetConnection extends AppCompatActivity {

    private Button tryAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet_connection);
        tryAgain =findViewById(R.id.btnTryAgain);
        this.tryAgain.setOnClickListener(this::tryNext);

    }

    private void tryNext(View view) {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();

        SharedPreferences preferences = getSharedPreferences(LoginActivity.FILE_NAME,MODE_PRIVATE);
        String myEmail = preferences.getString(LoginActivity.MY_NAME,"");

        if(null != activeNetwork){
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
                if (myEmail != ""){
                    startActivity(new Intent(NoInternetConnection.this,HomeActivity.class));
                    NoInternetConnection.this.finish();
                }
                else {
                    Intent intent = new Intent(NoInternetConnection.this, LoginActivity.class);
                    startActivity(intent);
                    NoInternetConnection.this.finish();
                }
            }
            else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                if (myEmail != ""){
                    startActivity(new Intent(NoInternetConnection.this,HomeActivity.class));
                    NoInternetConnection.this.finish();
                }
                else {
                    Intent intent = new Intent(NoInternetConnection.this, LoginActivity.class);
                    startActivity(intent);
                    NoInternetConnection.this.finish();
                }
            }
        }
        else{
            Intent intent= new Intent(NoInternetConnection.this,NoInternetConnection.class);
            startActivity(intent);
            NoInternetConnection.this.finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        /*NoInternetConnection.this.finish();
        startActivity(new Intent(NoInternetConnection.this,SplashScreenActivity.class));
*/
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();

        SharedPreferences preferences = getSharedPreferences(LoginActivity.FILE_NAME,MODE_PRIVATE);
        String myEmail = preferences.getString(LoginActivity.MY_NAME,"");

        if(null != activeNetwork){
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
                if (myEmail != ""){
                    startActivity(new Intent(NoInternetConnection.this,HomeActivity.class));
                    NoInternetConnection.this.finish();
                }
                else {
                    Intent intent = new Intent(NoInternetConnection.this, LoginActivity.class);
                    startActivity(intent);
                    NoInternetConnection.this.finish();
                }
            }
            else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                if (myEmail != ""){
                    startActivity(new Intent(NoInternetConnection.this,HomeActivity.class));
                    NoInternetConnection.this.finish();
                }
                else {
                    Intent intent = new Intent(NoInternetConnection.this, LoginActivity.class);
                    startActivity(intent);
                    NoInternetConnection.this.finish();
                }
            }
        }
        else{
            Intent intent= new Intent(NoInternetConnection.this,NoInternetConnection.class);
            startActivity(intent);
            NoInternetConnection.this.finish();
        }
    }
}