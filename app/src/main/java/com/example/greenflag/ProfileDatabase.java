package com.example.greenflag;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProfileDatabase extends SQLiteOpenHelper{


    public ProfileDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DatabaseUtil.databaseName, null, DatabaseUtil.databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "CREATE TABLE " +
                        DatabaseUtil.ProfileTable.tablename + " (" +
                        DatabaseUtil.ProfileTable._ID + " INTEGER PRIMARY KEY, " +
                        DatabaseUtil.ProfileTable.nameColumn + " VARCHAR(255), " +
                        DatabaseUtil.ProfileTable.usernameColumn + " VARCHAR(255), " +
                        DatabaseUtil.ProfileTable.passwordColumn + " VARCHAR(255), " +
                        DatabaseUtil.ProfileTable.ageColumn + " INTEGER, " +
                        DatabaseUtil.ProfileTable.birthdateColumn + " VARCHAR(255), " +
                        DatabaseUtil.ProfileTable.genderColumn + " VARCHAR(255), " +
                        DatabaseUtil.ProfileTable.countryColumn + " VARCHAR(255))"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
