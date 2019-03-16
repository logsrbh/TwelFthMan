package com.example.saurabh.twelfthman;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Saurabh on 22-03-2018.
 */

public class Dbhelper extends SQLiteOpenHelper {
    public Dbhelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase _db) {_db.execSQL(LoginDatabaseAdapter.DATABASE_CREATE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase _db, int i, int i1) {
        _db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
        onCreate(_db);

    }
}
