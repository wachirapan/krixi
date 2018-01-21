package com.dev.codehouse.krixi;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.dev.codehouse.data.DataOffline;
import com.dev.codehouse.sqlite.QuerySQLite;

import java.util.ArrayList;
import java.util.List;

public class MainDataOffline extends AppCompatActivity {
    Button btnadddata, btnonline ;
    ListView mlistview ;
    List<DataOffline> mlist ;
    SubMainDataOffline msub ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_data_offline);

        mlistview = (ListView)findViewById(R.id.listdata) ;

        mlist = new ArrayList<>();
        msub = new SubMainDataOffline(this,mlist);

        mlistview.setAdapter(msub);


        btnadddata = (Button)findViewById(R.id.btnadddata);
        btnadddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(MainDataOffline.this,MainInsertData.class);
                startActivity(mintent);
            }
        });

        QuerySQLite mquery = new QuerySQLite(this);
        Cursor mcursor = mquery.getData();
        while(mcursor.moveToNext()){
            String id = mcursor.getString(0);
            byte[] image = mcursor.getBlob(1);
            String head = mcursor.getString(2);
            String detail = mcursor.getString(3);
            mlist.add(new DataOffline(id, image, head, detail));

        }

    }
}
