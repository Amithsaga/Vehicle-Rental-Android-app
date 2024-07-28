/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.DatePickerDialog
 *  android.app.DatePickerDialog$OnDateSetListener
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ArrayAdapter
 *  android.widget.Button
 *  android.widget.DatePicker
 *  android.widget.EditText
 *  android.widget.Spinner
 *  android.widget.SpinnerAdapter
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.app.AppCompatActivity
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Calendar
 */
package com.example.interphase;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.interphase.R;
import com.example.loginsqlite.DBHelper;
import java.util.Calendar;

public class Booking
extends AppCompatActivity {
    private Button buttonBookNow;
    private Button buttonSelectDate;
    private DBHelper dbHelper;
    private EditText editTextEmail;
    private EditText editTextName;
    private Spinner spinner;
    private TextView textSelectedDate;

    private void bookNow() {
        String string2 = this.editTextName.getText().toString().trim();
        String string3 = this.editTextEmail.getText().toString().trim();
        String string4 = this.textSelectedDate.getText().toString().trim();
        String string5 = this.spinner.getSelectedItem().toString();
        if (!(string2.isEmpty() || string3.isEmpty() || string4.isEmpty())) {
            if (this.dbHelper.isDateBooked(string4, string5)) {
                Toast.makeText((Context)this, (CharSequence)"Vehicle is already booked for this date", (int)0).show();
            } else if (this.dbHelper.insertBooking(string2, string3, string4, string5) != -1L) {
                Toast.makeText((Context)this, (CharSequence)("Booking confirmed for " + string2), (int)0).show();
                this.finish();
            } else {
                Toast.makeText((Context)this, (CharSequence)"Failed to insert booking", (int)0).show();
            }
        } else {
            Toast.makeText((Context)this, (CharSequence)"Please fill in all fields", (int)0).show();
        }
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int n = calendar.get(1);
        int n2 = calendar.get(2);
        int n3 = calendar.get(5);
        DatePickerDialog datePickerDialog = new DatePickerDialog((Context)this, new DatePickerDialog.OnDateSetListener(this){
            final Booking this$0;
            {
                this.this$0 = booking;
            }

            public void onDateSet(DatePicker object, int n, int n2, int n3) {
                object = n3 + "/" + (n2 + 1) + "/" + n;
                this.this$0.textSelectedDate.setText((CharSequence)("Selected Date: " + (String)object));
            }
        }, n, n2, n3);
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
        datePickerDialog.show();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_booking);
        this.editTextName = (EditText)this.findViewById(R.id.email);
        this.editTextEmail = (EditText)this.findViewById(R.id.editTextEmail);
        this.textSelectedDate = (TextView)this.findViewById(R.id.textSelectedDate);
        this.buttonSelectDate = (Button)this.findViewById(R.id.buttonSelectDate);
        this.buttonBookNow = (Button)this.findViewById(R.id.buttonBookNow);
        this.spinner = (Spinner)this.findViewById(R.id.spinner);
        this.dbHelper = new DBHelper((Context)this);
        bundle = new ArrayAdapter((Context)this, 17367048, (Object[])new String[]{this.getIntent().getStringExtra("vehicle_name")});
        bundle.setDropDownViewResource(0x1090009);
        this.spinner.setAdapter((SpinnerAdapter)bundle);
        this.buttonSelectDate.setOnClickListener(new View.OnClickListener(this){
            final Booking this$0;
            {
                this.this$0 = booking;
            }

            public void onClick(View view) {
                this.this$0.showDatePickerDialog();
            }
        });
        this.buttonBookNow.setOnClickListener(new View.OnClickListener(this){
            final Booking this$0;
            {
                this.this$0 = booking;
            }

            public void onClick(View view) {
                this.this$0.bookNow();
            }
        });
    }
}

