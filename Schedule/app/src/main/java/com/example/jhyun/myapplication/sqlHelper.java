package com.example.jhyun.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class sqlHelper extends SQLiteOpenHelper {

    private  static final String dbNM="mydb.db";
    private static final String tblNM="test";

    public sqlHelper(Context context) {
        super(context,dbNM,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createtb(){
        SQLiteDatabase database =getWritableDatabase();
        String query="create table if not exists "+ tblNM + " (id integer primary key AUTOINCREMENT,name text,date text,time text)";
        database.execSQL(query);
        Log.d("TBLCreate", query);

    }
    public void delete(String name, String date, String time){
        SQLiteDatabase database =getWritableDatabase();
        String query="delete FROM "+ tblNM + " WHERE name='" +name + "';";
        database.execSQL(query);



        Log.d("TBLDreate", query);

    }


    //drop table method.
    public void droptb() {
        //drop table query
        SQLiteDatabase database = getWritableDatabase();//get database write reference because we need to write something in database.
        //basic sql create table query.
        String query = "drop table " + tblNM;
        //execute sql query.
        database.execSQL(query);
        Log.d("TBLdrop", query);
    }

    //insert query method.
    public void insert(String name, String date, String time) {
        SQLiteDatabase database = getWritableDatabase();
        //insert query.
        String query = "insert into " + tblNM + " (name,date,time) values ('" + name + "','" + date + "','" + time + "')";
        database.execSQL(query);
        Log.d("TBLdrop", query);
    }

    //get rows values.
    //do remember we use cursor for getting current pointing values from result set(retrieved rows set).
    public Cursor getRow(String id) {
        SQLiteDatabase database = getReadableDatabase();//get database read reference because we need to read something from database.
        Cursor cursor = database.rawQuery("select name,date,time from " + tblNM + " where id = '" + id + "'", null);
        return cursor;
    }


}
