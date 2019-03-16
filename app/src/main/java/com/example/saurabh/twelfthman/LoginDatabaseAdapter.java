package com.example.saurabh.twelfthman;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Saurabh on 22-03-2018.
 */

public class LoginDatabaseAdapter {
    static final String DATABSE_NAME ="login.db";
    static final int DATABSE_VERSION =1;

    static final String DATABASE_CREATE = "create table "+ "LOGIN"+ "( "
            +"ID"+" integer primary key autoincrement,"+ "USERNAME text," + "PASSWORD text); ";
    public SQLiteDatabase db;
    private final Context context;
    private Dbhelper dbhelper;
    public LoginDatabaseAdapter (Context _context)
    {
        context = _context;
        dbhelper = new Dbhelper(context, DATABSE_NAME,null,DATABSE_VERSION);
    }
    public LoginDatabaseAdapter open() throws SQLException
    {
        db = dbhelper.getWritableDatabase();
        return this;
    }
    public void close()

    {
        db.close();
    }

    public void insertEntry(String username, String password)
    {
        ContentValues newValues = new ContentValues();
        newValues.put("USERNAME", username);
        newValues.put("PASSWORD",password);

        db.insert("LOGNIN",null, newValues);
    }

    public String getSingleEntry (String username)
    {
        Cursor cursor =db.query("LOGIN",null,"USERNAME=?",new String[]
                {username},null,null,null);
        if (cursor.getCount()<1)
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }



}

