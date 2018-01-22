package com.dev.codehouse.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wachirapan on 22/1/2018 AD.
 */

public class UpdateSQLite extends SQLiteConnect {
    SQLiteDatabase db ;
    ContentValues mcontent ;

    public UpdateSQLite(Context context) {
        super(context);
    }
    public void updatedata(String id, byte[] image, String head, String detail )
    {
        db = this.getWritableDatabase();
        mcontent = new ContentValues();
        mcontent.put("data_img",image);
        mcontent.put("data_head",head);
        mcontent.put("data_detail", detail);
        db.update("dataaddress",mcontent," data_id = ?", new String[] {String.valueOf(id)});
        db.close();
    }
}
