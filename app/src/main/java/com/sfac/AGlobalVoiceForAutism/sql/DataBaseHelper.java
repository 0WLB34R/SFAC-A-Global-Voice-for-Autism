package com.sfac.AGlobalVoiceForAutism.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DataBaseName = "login.DataBase";

    public DataBaseHelper(Context context) {
        super(context, "login.DataBase", null,1 );
    }


    @Override
    public void onCreate(SQLiteDatabase MyDataBase) {
        MyDataBase.execSQL("create Table users(username TEXT primary key, password TEXT,fullname TEXT, age TEXT, country Text, email Text ) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDataBase, int i, int i1) {
        MyDataBase.execSQL("drop Table if exists users");

    }
    public Boolean insertData (String username, String password, String fullname, String age, String country, String email){
        SQLiteDatabase MyDataBase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("fullname", fullname);
        contentValues.put("age", age);
        contentValues.put("country", country);
        contentValues.put("email", email);
        long result =  MyDataBase.insert("users", null, contentValues);
        if(result == -1)return false; //failure
        else
            return true;




    }
    public Boolean checkusername (String username){
        SQLiteDatabase MyDataBase = this.getWritableDatabase();
        Cursor cursor = MyDataBase.rawQuery("Select * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkusernameresgistration(String username, String password, String fullname, String age, String country, String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where username = ? and password = ? and fullname = ? and age = ? and country = ? and email = ?"
                , new String[]{username, password, fullname, age, country,email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where username = ? and password = ?"
                , new String[]{username, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
