package com.swish.eduin;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "loginDB.db";
    private static final String TABLE_NAME = "loginDB";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_PHONE_NO = "phone_no";
    private static final String COLUMN_PASSWORD = "password";
    SQLiteDatabase db;
  //  private static  final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + "("
       //   + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT," + COLUMN_PHONE_NO + " TEXT," + COLUMN_PASSWORD + " TEXT," + ")";


    private static  final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT," + COLUMN_PHONE_NO + " TEXT," + COLUMN_PASSWORD + " TEXT" + ")";


    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }


    public void insertLoginDB(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PHONE_NO, c.getPhone_no());
        values.put(COLUMN_USER_NAME, c.getName());
        values.put(COLUMN_PASSWORD,c.getPassword());
        Log.e("UserName",c.getName());
        Log.e("Password",c.getPassword());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public int searchPass(String userName , String password){
        Log.e("UserName",userName);
        Log.e("Password",password);
        db = this.getReadableDatabase();
        String query3 = "SELECT user_name, password FROM loginDB WHERE "+COLUMN_USER_NAME+" = '" + userName + "' AND "+COLUMN_PASSWORD+" = '"+password+"'";
        Cursor cursor = db.rawQuery(query3,null);
        String a ,b;
        b=" not found";
        if(cursor.getCount()>0){
            return cursor.getCount();
        }
        return  0;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qurey1 = " DROP TABLE IF EXISTS " +TABLE_NAME;
        db.execSQL(qurey1);
        this.onCreate(db);
    }
}

