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
 *  android.widget.TextView
 *  androidx.appcompat.app.AppCompatActivity
 *  java.lang.Object
 *  java.lang.String
 */
package com.example.interphase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.interphase.Booking;
import com.example.interphase.Contact;
import com.example.interphase.MainActivity2;
import com.example.interphase.R;
import com.example.interphase.User;

public class vehicle
extends AppCompatActivity {
    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    TextView textView;
    TextView textview2;

    private void navigateToBooking(String string2) {
        Intent intent = new Intent((Context)this, Booking.class);
        intent.putExtra("vehicle_name", string2);
        this.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_vehicle);
        this.button = (Button)this.findViewById(R.id.rentButton);
        this.button2 = (Button)this.findViewById(R.id.rentButton2);
        this.button3 = (Button)this.findViewById(R.id.rentButton3);
        this.button4 = (Button)this.findViewById(R.id.rentButton4);
        this.button5 = (Button)this.findViewById(R.id.button5);
        this.textView = (TextView)this.findViewById(R.id.textView5);
        this.textview2 = (TextView)this.findViewById(R.id.textView14);
        this.textView.setOnClickListener(new View.OnClickListener(this){
            final vehicle this$0;
            {
                this.this$0 = vehicle2;
            }

            public void onClick(View view) {
                this.this$0.startActivity(new Intent(this.this$0.getApplicationContext(), MainActivity2.class));
            }
        });
        this.textview2.setOnClickListener(new View.OnClickListener(this){
            final vehicle this$0;
            {
                this.this$0 = vehicle2;
            }

            public void onClick(View view) {
                this.this$0.startActivity(new Intent(this.this$0.getApplicationContext(), Contact.class));
            }
        });
        this.button5.setOnClickListener(new View.OnClickListener(this){
            final vehicle this$0;
            {
                this.this$0 = vehicle2;
            }

            public void onClick(View view) {
                this.this$0.startActivity(new Intent(this.this$0.getApplicationContext(), User.class));
            }
        });
        this.button.setOnClickListener(new View.OnClickListener(this){
            final vehicle this$0;
            {
                this.this$0 = vehicle2;
            }

            public void onClick(View view) {
                this.this$0.navigateToBooking("TATA Nexon");
            }
        });
        this.button2.setOnClickListener(new View.OnClickListener(this){
            final vehicle this$0;
            {
                this.this$0 = vehicle2;
            }

            public void onClick(View view) {
                this.this$0.navigateToBooking("Pulsar Ns");
            }
        });
        this.button3.setOnClickListener(new View.OnClickListener(this){
            final vehicle this$0;
            {
                this.this$0 = vehicle2;
            }

            public void onClick(View view) {
                this.this$0.navigateToBooking("KTM Duke");
            }
        });
        this.button4.setOnClickListener(new View.OnClickListener(this){
            final vehicle this$0;
            {
                this.this$0 = vehicle2;
            }

            public void onClick(View view) {
                this.this$0.navigateToBooking("Maruthi Suzuki");
            }
        });
    }
}

