package com.sfac.AGlobalVoiceForAutism.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBaseHelperVideos extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "videos_table";

    private static final String COL1 = "identifier";
    private static final String COL2 = "name";

    //aI.add(new ActivitiesItem(1,"KcBmrnBmdzM","Khokha",".jpg", "NOT", R.drawable.elmo_1));


    public DataBaseHelperVideos(Context context){
        super(context,TABLE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ("+COL1+" TEXT PRIMARY KEY, "+COL2+" TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void addData(String identifier, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL1, identifier);
        contentValues.put(COL2, name);     //Watch out for issues here
        Log.d(TAG,"addData: Adding " + identifier+", "+ name + " to "+ TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);
    }

    public boolean checkVid (String identifier){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from videos_table where identifier = ?", new String[] {identifier});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }
    public boolean isEmpty(){
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT count(*) FROM "+TABLE_NAME;
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int i = mcursor.getInt(0);
        if(i>0) {
            return false;
        }else{
            return true;
        }
    }



}
