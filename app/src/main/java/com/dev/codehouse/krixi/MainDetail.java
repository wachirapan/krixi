package com.dev.codehouse.krixi;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.codehouse.sqlite.QuerySQLite;

public class MainDetail extends AppCompatActivity {
    QuerySQLite mquery ;
    String mid, mhead, mdetail,id ;
    byte[] image ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);
        id = getIntent().getStringExtra("ID");

        mquery = new QuerySQLite(this);
        Cursor mcursor = mquery.getoneData(id);
        while (mcursor.moveToNext()){
            mid = mcursor.getString(0);
            image = mcursor.getBlob(1);
            mhead = mcursor.getString(2);
            mdetail = mcursor.getString(3);
        }
        ImageView mimage = (ImageView)findViewById(R.id.imageview);
        TextView mtexthead = (TextView)findViewById(R.id.txthead);
        TextView mtextdetail = (TextView)findViewById(R.id.txtdetail);
        mtexthead.setText(mhead);
        mtextdetail.setText(mdetail);
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0 ,image.length);
        mimage.setImageBitmap(bitmap);

        Button btneditform = (Button)findViewById(R.id.btnedit);
        btneditform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(MainDetail.this,MainFormEdit.class);
                mintent.putExtra("ID",id);
                startActivity(mintent);
            }
        });


    }
}
