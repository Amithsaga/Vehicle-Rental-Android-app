/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.database.Cursor
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  androidx.appcompat.app.AppCompatActivity
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.example.interphase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.interphase.Adminmain2;
import com.example.interphase.R;
import com.example.loginsqlite.DBHelper;

public class MainAdmin
extends AppCompatActivity {
    DBHelper DB;
    TextView mtextview;
    TextView mtextview2;
    TextView userDetailsTextView;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_main_admin);
        this.userDetailsTextView = (TextView)this.findViewById(R.id.userDetailsTextView);
        this.mtextview = (TextView)this.findViewById(R.id.textView8);
        this.mtextview2 = (TextView)this.findViewById(R.id.textView6);
        this.DB = new DBHelper((Context)this);
        this.mtextview.setOnClickListener(new View.OnClickListener(this){
            final MainAdmin this$0;
            {
                this.this$0 = mainAdmin;
            }

            public void onClick(View view) {
                this.this$0.startActivity(new Intent(this.this$0.getApplicationContext(), Activity.class));
            }
        });
        this.mtextview2.setOnClickListener(new View.OnClickListener(this){
            final MainAdmin this$0;
            {
                this.this$0 = mainAdmin;
            }

            public void onClick(View view) {
                this.this$0.startActivity(new Intent(this.this$0.getApplicationContext(), Adminmain2.class));
            }
        });
        bundle = new StringBuilder();
        Cursor cursor = this.DB.getAllUsers();
        if (cursor.moveToFirst()) {
            do {
                String string2 = cursor.getString(cursor.getColumnIndex("username"));
                bundle.append("Username: ").append(string2).append("\n");
            } while (cursor.moveToNext());
        }
        cursor.close();
        this.userDetailsTextView.setText((CharSequence)bundle.toString());
    }
}

