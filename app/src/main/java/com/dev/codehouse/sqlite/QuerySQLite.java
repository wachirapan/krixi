package com.dev.codehouse.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wachirapan on 21/1/2018 AD.
 */

public class QuerySQLite extends SQLiteConnect{
    SQLiteDatabase db ;
    Cursor cursor ;
    public QuerySQLite(Context context) {
        super(context);
    }
    public Cursor getData()
    {
        db = this.getWritableDatabase();
        cursor = db.rawQuery("select * from dataaddress ", null);
        return cursor ;
    }
}
