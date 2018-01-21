package com.dev.codehouse.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wachirapan on 21/1/2018 AD.
 */

public class SQLiteConnect extends SQLiteOpenHelper {
    public SQLiteConnect(Context context) {
        super(context, "krixiapp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE dataaddress" +
                "(data_id INTEGER PRIMARY KEY," +
                " data_img BLOG," +
                " data_head TEXT(100)," +
                " data_detail TEXT(100));");
//        sqLiteDatabase.execSQL("CREATE TABLE table2" +
//                "(MemberID INTEGER PRIMARY KEY," +
//                " Name TEXT(100)," +
//                " Tel TEXT(100));");
 }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
