/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.os.Bundle
 *  android.widget.TextView
 *  androidx.appcompat.app.AppCompatActivity
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.example.interphase;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.interphase.R;
import com.example.loginsqlite.DBHelper;

public class Adminmain2
extends AppCompatActivity {
    private DBHelper dbHelper;
    TextView textView;

    protected void onCreate(Bundle object) {
        super.onCreate(object);
        this.setContentView(R.layout.activity_adminmain2);
        this.dbHelper = new DBHelper((Context)this);
        TextView textView = (TextView)this.findViewById(R.id.textViewBookingDetails);
        StringBuilder stringBuilder = new StringBuilder();
        Cursor cursor = this.dbHelper.getAllBookings();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                object = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String string2 = cursor.getString(cursor.getColumnIndexOrThrow("email"));
                String string3 = cursor.getString(cursor.getColumnIndexOrThrow("date"));
                String string4 = cursor.getString(cursor.getColumnIndexOrThrow("vehicle"));
                stringBuilder.append("Vehicle: ").append(string4).append("\n").append("Name: ").append((String)object).append("\n").append("Contact No: ").append(string2).append("\n").append("").append(string3).append("\n\n");
            } while (cursor.moveToNext());
        } else {
            stringBuilder.append("No bookings found");
        }
        if (cursor != null) {
            cursor.close();
        }
        textView.setText((CharSequence)stringBuilder.toString());
    }
}

