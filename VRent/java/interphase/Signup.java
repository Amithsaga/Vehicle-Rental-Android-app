/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
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
 */
package com.example.interphase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.interphase.MainActivity2;
import com.example.interphase.R;
import com.example.loginsqlite.DBHelper;

public class Signup
extends AppCompatActivity {
    public static final String TAG = "TAG";
    DBHelper DB;
    EditText mConfirmPassword;
    TextView mLoginBtn;
    EditText mPassword;
    Button mRegisterBtn;
    EditText nEmail;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_signup);
        this.nEmail = (EditText)this.findViewById(R.id.email);
        this.mPassword = (EditText)this.findViewById(R.id.password);
        this.mConfirmPassword = (EditText)this.findViewById(R.id.confirmpwd);
        this.mRegisterBtn = (Button)this.findViewById(R.id.loginBtn);
        this.mLoginBtn = (TextView)this.findViewById(R.id.createtext);
        this.DB = new DBHelper((Context)this);
        this.mLoginBtn.setOnClickListener(new View.OnClickListener(this){
            final Signup this$0;
            {
                this.this$0 = signup;
            }

            public void onClick(View view) {
                this.this$0.startActivity(new Intent(this.this$0.getApplicationContext(), MainActivity2.class));
            }
        });
        this.mRegisterBtn.setOnClickListener(new View.OnClickListener(this){
            final Signup this$0;
            {
                this.this$0 = signup;
            }

            public void onClick(View object) {
                object = this.this$0.nEmail.getText().toString().trim();
                String string2 = this.this$0.mPassword.getText().toString().trim();
                String string3 = this.this$0.mConfirmPassword.getText().toString().trim();
                if (!(object.equals((Object)"") || string2.equals((Object)"") || string3.equals((Object)""))) {
                    if (string2.equals((Object)string3)) {
                        if (!this.this$0.DB.checkUsername((String)object)) {
                            if (this.this$0.DB.insertData((String)object, string2)) {
                                Toast.makeText((Context)this.this$0, (CharSequence)"Registered successfully", (int)0).show();
                                object = new Intent(this.this$0.getApplicationContext(), MainActivity2.class);
                                this.this$0.startActivity((Intent)object);
                            } else {
                                Toast.makeText((Context)this.this$0, (CharSequence)"Registration failed", (int)0).show();
                            }
                        } else {
                            Toast.makeText((Context)this.this$0, (CharSequence)"User already exists! Please sign in", (int)0).show();
                        }
                    } else {
                        Toast.makeText((Context)this.this$0, (CharSequence)"Passwords not matching", (int)0).show();
                    }
                } else {
                    Toast.makeText((Context)this.this$0, (CharSequence)"Please enter all the fields", (int)0).show();
                }
            }
        });
    }
}

