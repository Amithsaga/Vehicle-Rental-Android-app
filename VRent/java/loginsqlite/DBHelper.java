/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteOpenHelper
 *  java.lang.Object
 *  java.lang.String
 */
package com.example.loginsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper
extends SQLiteOpenHelper {
    public static final String BOOKING_COLUMN_DATE = "date";
    public static final String BOOKING_COLUMN_EMAIL = "email";
    public static final String BOOKING_COLUMN_ID = "_id";
    public static final String BOOKING_COLUMN_NAME = "name";
    public static final String BOOKING_COLUMN_VEHICLE = "vehicle";
    private static final String BOOKING_DB_NAME = "BookingDB7";
    private static final int BOOKING_DB_VERSION = 1;
    public static final String BOOKING_TABLE_NAME = "bookings";
    private static final String CREATE_BOOKING_TABLE_QUERY = "CREATE TABLE bookings (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, date TEXT, vehicle TEXT)";
    private static final String LOGIN_COLUMN_PASSWORD = "password";
    private static final String LOGIN_COLUMN_USERNAME = "username";
    private static final String LOGIN_DB_NAME = "Login.db2";
    private static final int LOGIN_DB_VERSION = 1;
    private static final String LOGIN_TABLE_NAME = "users";

    public DBHelper(Context context) {
        super(context, BOOKING_DB_NAME, null, 1);
    }

    public boolean checkUsername(String string2) {
        string2 = this.getReadableDatabase().rawQuery("SELECT * FROM users WHERE username = ?", new String[]{string2});
        boolean bl = string2.getCount() > 0;
        string2.close();
        return bl;
    }

    public boolean checkUsernamePassword(String string2, String string3) {
        string2 = this.getReadableDatabase().rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", new String[]{string2, string3});
        boolean bl = string2.getCount() > 0;
        string2.close();
        return bl;
    }

    public Cursor getAllBookings() {
        return this.getReadableDatabase().rawQuery("SELECT * FROM bookings", null);
    }

    public Cursor getAllBookingsByEmail(String string2) {
        return this.getReadableDatabase().query(BOOKING_TABLE_NAME, new String[]{BOOKING_COLUMN_NAME, BOOKING_COLUMN_DATE, BOOKING_COLUMN_VEHICLE}, "email = ?", new String[]{string2}, null, null, null);
    }

    public Cursor getAllUsers() {
        return this.getReadableDatabase().rawQuery("SELECT * FROM users", null);
    }

    public long insertBooking(String string2, String string3, String string4, String string5) {
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        boolean bl = false;
        Cursor cursor = sQLiteDatabase.rawQuery("SELECT * FROM bookings WHERE date = ? AND vehicle = ?", new String[]{string4, string5});
        if (cursor.getCount() > 0) {
            bl = true;
        }
        cursor.close();
        if (bl) {
            sQLiteDatabase.close();
            return -1L;
        }
        cursor = new ContentValues();
        cursor.put(BOOKING_COLUMN_NAME, string2);
        cursor.put(BOOKING_COLUMN_EMAIL, string3);
        cursor.put(BOOKING_COLUMN_DATE, string4);
        cursor.put(BOOKING_COLUMN_VEHICLE, string5);
        long l = sQLiteDatabase.insert(BOOKING_TABLE_NAME, null, (ContentValues)cursor);
        sQLiteDatabase.close();
        return l;
    }

    public boolean insertData(String string2, String string3) {
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LOGIN_COLUMN_USERNAME, string2);
        contentValues.put(LOGIN_COLUMN_PASSWORD, string3);
        long l = sQLiteDatabase.insert(LOGIN_TABLE_NAME, null, contentValues);
        sQLiteDatabase.close();
        boolean bl = l != -1L;
        return bl;
    }

    public boolean isDateBooked(String string2, String string3) {
        string2 = this.getReadableDatabase().query(BOOKING_TABLE_NAME, null, "date = ? AND vehicle = ?", new String[]{string2, string3}, null, null, null);
        boolean bl = string2.getCount() > 0;
        string2.close();
        return bl;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE users (username TEXT PRIMARY KEY, password TEXT)");
        sQLiteDatabase.execSQL(CREATE_BOOKING_TABLE_QUERY);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bookings");
        this.onCreate(sQLiteDatabase);
    }
}

