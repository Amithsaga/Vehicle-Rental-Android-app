/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  androidx.appcompat.app.AppCompatActivity
 *  java.lang.Object
 */
package com.example.interphase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.interphase.MainActivity2;
import com.example.interphase.R;

public class MainActivity
extends AppCompatActivity {
    private Button button;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_main);
        this.button = (Button)this.findViewById(R.id.button2);
        this.button.setOnClickListener(new View.OnClickListener(this){
            final MainActivity this$0;
            {
                this.this$0 = mainActivity;
            }

            public void onClick(View view) {
                this.this$0.startActivity(new Intent(this.this$0.getApplicationContext(), MainActivity2.class));
            }
        });
    }
}

