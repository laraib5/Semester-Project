package com.example.mrappointa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "signup.db";
    public static final String TABLE_NAME = "signup_table";
    public static final String COL_FIRSTNAME = "firstname";
    public static final String COL_LASTNAME = "lastname";
    public static final String COL_EMAIL = "email";
    public static final String COL_MOBILE = "mobile";
    public static final String COL_PASSWORD = "password";
    public static final String COL_CPASSWORD = "cpassword";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,firstname TEXT,lastname TEXT,email TEXT,mobile INTEGER,password TEXT,cpassword TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insert(String firstname, String lastname, String email, String mobile, String password, String cpassword){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstname", firstname);
        contentValues.put("lastname", lastname);
        contentValues.put("email", email);
        contentValues.put("mobile", mobile);
        contentValues.put("password", password);
        contentValues.put("cpassword", cpassword);
        long ins = db.insert(TABLE_NAME, null, contentValues);
        if(ins == -1) return false;
        else return true;
    }

    public boolean insertData(String firstname, String lastname, String email, String mobile, String password, String cpassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_FIRSTNAME, firstname);
        contentValues.put(COL_LASTNAME, lastname);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_MOBILE, mobile);
        contentValues.put(COL_PASSWORD, password);
        contentValues.put(COL_CPASSWORD, cpassword);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Boolean chkmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from signup_table where email =?",new String[] {email});
        if(cursor.getCount() > 0) return false;
        else return true;
    }

    public Boolean emailpassword(String email,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from signup_table where email =? and password =?",new String[] {email,password});
        if(cursor.getCount()>0) return true;
        else return false;
    }
}



