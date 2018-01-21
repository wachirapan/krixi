package com.dev.codehouse.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by wachirapan on 21/1/2018 AD.
 */

public class InsertSQLite extends SQLiteConnect
{
    long rows ;
    SQLiteDatabase db ;
    ContentValues mcontent ;
    public InsertSQLite(Context context) {
        super(context);
    }

  public void insertdata(String head, String detail, byte[] image)
  {
        db = this.getWritableDatabase();
        String sql = "INSERT INTO dataaddress VALUES (NULL, ?, ?, ?)";
      SQLiteStatement mstatement = db.compileStatement(sql);
      mstatement.bindBlob(1,image);
      mstatement.bindString(2,head);
      mstatement.bindString(3,detail);
      mstatement.executeInsert();
  }
}
