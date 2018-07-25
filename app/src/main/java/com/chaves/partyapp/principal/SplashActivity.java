package com.chaves.partyapp.principal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chaves.partyapp.R;
import com.chaves.partyapp.sqlite.BancoPessoas;

public class SplashActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        db = BancoPessoas.getDB(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(SplashActivity.this, PrincipalActivity.class);
                startActivity(it);
            }
        },3000);

    }
}
