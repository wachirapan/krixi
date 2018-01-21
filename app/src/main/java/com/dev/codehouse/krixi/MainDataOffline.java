package com.dev.codehouse.krixi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainDataOffline extends AppCompatActivity {
    Button btnadddata, btnonline ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_data_offline);

        btnadddata = (Button)findViewById(R.id.btnadddata);
        btnadddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(MainDataOffline.this,MainInsertData.class);
                startActivity(mintent);
            }
        });

    }
}
