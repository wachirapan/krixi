package com.dev.codehouse.krixi;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.dev.codehouse.sqlite.QuerySQLite;
import com.dev.codehouse.sqlite.UpdateSQLite;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainFormEdit extends AppCompatActivity {
    String id, head, detail ;
    byte[] image ;
    ImageView imageView ;
    final int REQUEST_CODE_GARARRY = 999 ;
    EditText mhead, mdetail ;
    Button btninsert, btnsearch ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form_edit);

        id = getIntent().getStringExtra("ID");

        QuerySQLite mquery = new QuerySQLite(this);
        Cursor mcursor = mquery.getoneData(id);
        while (mcursor.moveToNext()){
            image = mcursor.getBlob(1);
            head = mcursor.getString(2);
            detail = mcursor.getString(3);
        }
        init();
        mhead.setText(head);
        mdetail.setText(detail);
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0 ,image.length);
        imageView.setImageBitmap(bitmap);
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        MainFormEdit.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GARARRY
                );
            }
        });
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    UpdateSQLite minsert = new UpdateSQLite(MainFormEdit.this);
                    minsert.updatedata(id,imageViewToByte(imageView), mhead.getText().toString().trim(),
                            mdetail.getText().toString().trim()
                    );
                    Toast.makeText(getApplicationContext(),"Complete Full",Toast.LENGTH_LONG).show();
                    mhead.setText("");
                    mdetail.setText("");
                    imageView.setImageResource(R.mipmap.ic_launcher);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray ;

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODE_GARARRY){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent mintent = new Intent(Intent.ACTION_PICK);
                mintent.setType("image/*");
                startActivityForResult(mintent, REQUEST_CODE_GARARRY);
            }
            else{
                Toast.makeText(getApplicationContext(),"You can don't have permision",Toast.LENGTH_LONG).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE_GARARRY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void init()
    {
        imageView = (ImageView)findViewById(R.id.imageview);

        mhead = (EditText)findViewById(R.id.headdata);
        mdetail = (EditText)findViewById(R.id.detaildata);

        btnsearch = (Button)findViewById(R.id.searchimg);
        btninsert = (Button)findViewById(R.id.btninsert);
    }
}
