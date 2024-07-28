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
 *  java.lang.Boolean
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
import com.example.interphase.Adminlogin;
import com.example.interphase.R;
import com.example.interphase.Signup;
import com.example.interphase.vehicle;
import com.example.loginsqlite.DBHelper;

public class MainActivity2
extends AppCompatActivity {
    DBHelper DB;
    TextView mCreateBtn;
    TextView mCreateBtn3;
    Button mLogin;
    EditText memail;
    EditText mpassword;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_main2);
        this.memail = (EditText)this.findViewById(R.id.email);
        this.mpassword = (EditText)this.findViewById(R.id.password);
        this.mLogin = (Button)this.findViewById(R.id.loginBtn);
        this.mCreateBtn = (TextView)this.findViewById(R.id.createtext);
        this.mCreateBtn3 = (TextView)this.findViewById(R.id.textView4);
        this.DB = new DBHelper((Context)this);
        this.mCreateBtn.setOnClickListener(new View.OnClickListener(this){
            final MainActivity2 this$0;
            {
                this.this$0 = mainActivity2;
            }

            public void onClick(View view) {
                this.this$0.startActivity(new Intent(this.this$0.getApplicationContext(), Signup.class));
            }
        });
        this.mCreateBtn3.setOnClickListener(new View.OnClickListener(this){
            final MainActivity2 this$0;
            {
                this.this$0 = mainActivity2;
            }

            public void onClick(View view) {
                this.this$0.startActivity(new Intent(this.this$0.getApplicationContext(), Adminlogin.class));
            }
        });
        this.mLogin.setOnClickListener(new View.OnClickListener(this){
            final MainActivity2 this$0;
            {
                this.this$0 = mainActivity2;
            }

            public void onClick(View object) {
                object = this.this$0.memail.getText().toString().trim();
                String string2 = this.this$0.mpassword.getText().toString().trim();
                if (!object.equals((Object)"") && !string2.equals((Object)"")) {
                    if (Boolean.valueOf((boolean)this.this$0.DB.checkUsernamePassword((String)object, string2)).booleanValue()) {
                        Toast.makeText((Context)this.this$0, (CharSequence)"Sign in successful", (int)0).show();
                        object = new Intent(this.this$0.getApplicationContext(), vehicle.class);
                        this.this$0.startActivity((Intent)object);
                    } else {
                        Toast.makeText((Context)this.this$0, (CharSequence)"Invalid Credentials", (int)0).show();
                    }
                } else {
                    Toast.makeText((Context)this.this$0, (CharSequence)"Please enter all the fields", (int)0).show();
                }
            }
        });
    }
}

