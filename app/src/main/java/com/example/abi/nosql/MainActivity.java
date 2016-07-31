package com.example.abi.nosql;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread bg = new Thread(){
            public void run(){
                try{
                    sleep(8*1000);
                    Intent intent = new Intent(getBaseContext(),Home.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

        };

        bg.start();

    }


}
