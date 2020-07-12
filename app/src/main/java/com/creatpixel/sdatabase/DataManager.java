package com.creatpixel.sdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataManager extends SQLiteOpenHelper {
    //1. Creating a new class and adding extending from SQLiteOpenHelper
    //With this class we can create database,

    //2. We are creating 2 static final variables for database name and version.
    private static final String dbname = "mydb";
    private static final int version = 1;
    //3. Here we are setting version and name in the constructor of superclass means, DataManager class
    //that and we extended this from SQLiteOpenHelper so we are setting version and database name in the constructor
    //of SQLiteOpenHelper, Why? Because we are creating a new database so name and version is important.
    public DataManager(Context context) {
        super(context, dbname,null, version);
    }
    //4. In onCreate method we are creating a table and inserting values of table.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE GOALS(_id INTEGER PRIMARY KEY AUTOINCREMENT, GOALSNAME TEXT, NEEDS TEXT)";
        sqLiteDatabase.execSQL(sql);

        insertData("AndroidDevelopment", "PC and Internet", sqLiteDatabase);
        insertData("Meditation", "SilentPlace", sqLiteDatabase);
        insertData("Rich", "Don't Stop Working", sqLiteDatabase);
    }

    //5. Method for inserting values easily in the table we are using this in no.4
    private void insertData(String goalsName, String needs, SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put("GOALSNAME", goalsName);
        values.put("NEEDS", needs);
        database.insert("GOALS", null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
