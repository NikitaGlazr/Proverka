package com.example.ekzamen;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "users.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "_id";
    public static final String COLUMN_LOGIN = "login";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_LOGIN + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(dropTableQuery);
        onCreate(db);
    }

    public void insertLogin(String login) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LOGIN, login);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}
