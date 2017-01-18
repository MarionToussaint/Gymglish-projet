package com.example.mmtou.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

/**
 * Created by mmtou on 17/01/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    public static final String TAG = DbHelper.class.getSimpleName();
    public static final String DB_NAME = "myapplication.db";
    public static final int DB_VERSION = 1;
    public static final String USER_TABLE = "user";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASS = "password";

    public static final String CREATE_TABLE_USER = "CREATE TABLE " + USER_TABLE +
            "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_EMAIL + " TEXT UNIQUE," + COLUMN_USERNAME + " TEXT UNIQUE,"
            + COLUMN_PASS + " TEXT);";

    public DbHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);
    }

    public void addUser(String email,String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL,email);
        values.put(COLUMN_USERNAME,username);
        values.put(COLUMN_PASS,password);
        long id = db.insert(USER_TABLE,null,values);
        db.close();
        Log.d(TAG,"user inserted" + id);
    }

    public boolean getUser(String username,String password){
        String selectQuery = "select * from " + USER_TABLE + " where " +
                COLUMN_USERNAME + " = " + "'"+username+"'" + " and " +
                COLUMN_PASS + " = " + "'"+password+"';";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0){
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }
}

