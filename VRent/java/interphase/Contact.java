/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  androidx.appcompat.app.AppCompatActivity
 *  java.lang.Object
 */
package com.example.interphase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.interphase.R;
import com.example.interphase.User;

public class Contact
extends AppCompatActivity {
    TextView textView;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_contact);
        this.textView = (TextView)this.findViewById(R.id.textView13);
        this.textView.setOnClickListener(new View.OnClickListener(this){
            final Contact this$0;
            {
                this.this$0 = contact;
            }

            public void onClick(View view) {
                this.this$0.startActivity(new Intent(this.this$0.getApplicationContext(), User.class));
            }
        });
    }
}

