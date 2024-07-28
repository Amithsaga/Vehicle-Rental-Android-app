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
import com.example.interphase.MainAdmin;
import com.example.interphase.R;

public class Adminlogin
extends AppCompatActivity {
    Button mLogin;
    EditText memail;
    EditText mpassword;
    TextView mtext;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_adminlogin);
        this.memail = (EditText)this.findViewById(R.id.email);
        this.mpassword = (EditText)this.findViewById(R.id.password);
        this.mtext = (TextView)this.findViewById(R.id.textView5);
        this.mLogin = (Button)this.findViewById(R.id.loginBtn);
        this.mtext.setOnClickListener(new View.OnClickListener(this){
            final Adminlogin this$0;
            {
                this.this$0 = adminlogin;
            }

            public void onClick(View view) {
                this.this$0.startActivity(new Intent(this.this$0.getApplicationContext(), MainActivity2.class));
            }
        });
        this.mLogin.setOnClickListener(new View.OnClickListener(this){
            final Adminlogin this$0;
            {
                this.this$0 = adminlogin;
            }

            public void onClick(View object) {
                object = this.this$0.memail.getText().toString().trim();
                String string2 = this.this$0.mpassword.getText().toString().trim();
                if (object.equals((Object)"admin") && string2.equals((Object)"admin123")) {
                    object = new Intent((Context)this.this$0, MainAdmin.class);
                    this.this$0.startActivity((Intent)object);
                    this.this$0.finish();
                } else {
                    Toast.makeText((Context)this.this$0, (CharSequence)"Invalid Credentials", (int)0).show();
                }
            }
        });
    }
}

