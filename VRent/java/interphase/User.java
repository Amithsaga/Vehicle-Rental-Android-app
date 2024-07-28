/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.database.Cursor
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.app.AppCompatActivity
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.example.interphase;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.interphase.Contact;
import com.example.interphase.R;
import com.example.interphase.vehicle;
import com.example.loginsqlite.DBHelper;

public class User
extends AppCompatActivity {
    Button button;
    private Button buttonFetch;
    private DBHelper dbHelper;
    private EditText editTextEmail;
    private TextView textView16;
    private TextView textViewBookingDetails;

    private void fetchBookingDetails() {
        String string2 = this.editTextEmail.getText().toString().trim();
        if (string2.isEmpty()) {
            Toast.makeText((Context)this, (CharSequence)"Please enter an email", (int)0).show();
            return;
        }
        Cursor cursor = this.dbHelper.getAllBookingsByEmail(string2);
        if (cursor != null && cursor.moveToFirst()) {
            StringBuilder stringBuilder = new StringBuilder();
            do {
                String string3 = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String string4 = cursor.getString(cursor.getColumnIndexOrThrow("date"));
                string2 = cursor.getString(cursor.getColumnIndexOrThrow("vehicle"));
                stringBuilder.append("Name: ").append(string3).append("\n").append("").append(string4).append("\n").append("Vehicle: ").append(string2).append("\n\n");
            } while (cursor.moveToNext());
            this.textViewBookingDetails.setText((CharSequence)stringBuilder.toString());
        } else {
            this.textViewBookingDetails.setText((CharSequence)"No bookings found for this email");
        }
        if (cursor != null) {
            cursor.close();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_user);
        this.editTextEmail = (EditText)this.findViewById(R.id.editTextEmail);
        this.buttonFetch = (Button)this.findViewById(R.id.buttonFetch);
        this.textViewBookingDetails = (TextView)this.findViewById(R.id.textViewBookingDetails);
        this.textView16 = (TextView)this.findViewById(R.id.textView16);
        this.button = (Button)this.findViewById(R.id.button4);
        this.dbHelper = new DBHelper((Context)this);
        this.textView16.setOnClickListener(new View.OnClickListener(this){
            final User this$0;
            {
                this.this$0 = user;
            }

            public void onClick(View view) {
                this.this$0.startActivity(new Intent(this.this$0.getApplicationContext(), vehicle.class));
            }
        });
        this.button.setOnClickListener(new View.OnClickListener(this){
            final User this$0;
            {
                this.this$0 = user;
            }

            public void onClick(View view) {
                this.this$0.startActivity(new Intent(this.this$0.getApplicationContext(), Contact.class));
            }
        });
        this.buttonFetch.setOnClickListener(new View.OnClickListener(this){
            final User this$0;
            {
                this.this$0 = user;
            }

            public void onClick(View view) {
                this.this$0.fetchBookingDetails();
            }
        });
    }
}

