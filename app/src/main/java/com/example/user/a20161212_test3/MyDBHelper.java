package com.example.user.a20161212_test3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 2016/12/16.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
/*_id 為固定KEY*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE  TABLE main.exp" +
                "(_id INTEGER PRIMARY KEY NOT NULL, " +
                "cdate DATETIME NOT NULL," +
                "info VERCHAR," +
                "amount INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
