package com.dev.codehouse.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wachirapan on 22/1/2018 AD.
 */

public class DeleteSQlite extends SQLiteConnect {
    SQLiteDatabase db ;
    public DeleteSQlite(Context context) {
        super(context);
    }
    public void deletedata(String id)
    {
        db = this.getWritableDatabase();
        db.delete("dataaddress","data_id = ?",new String[]{String.valueOf(id)});
        db.close();
    }
}
