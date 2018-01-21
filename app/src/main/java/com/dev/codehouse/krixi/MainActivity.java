package com.dev.codehouse.krixi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dev.codehouse.sqlite.SQLiteConnect;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteConnect msqlite = new SQLiteConnect(MainActivity.this);
        msqlite.getWritableDatabase();

        ImageView mimg = (ImageView) findViewById(R.id.imglogo);
        mimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(MainActivity.this,MainDataOffline.class);
                startActivity(mintent);

            }
        });
    }
}
