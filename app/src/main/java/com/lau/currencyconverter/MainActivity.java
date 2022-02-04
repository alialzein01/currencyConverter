package com.lau.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usv;
    EditText llv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usv = (EditText) findViewById(R.id.usdValue);
        llv = (EditText) findViewById(R.id.llValue);

    }

    public void convert(View v) {
        String usd_val = usv.getText().toString();
        String ll_val = llv.getText().toString();
        if (usd_val.isEmpty()) {
            double newl = Double.parseDouble(ll_val) / 22000;
            Toast.makeText(getApplicationContext(), String.valueOf(newl) + "$", Toast.LENGTH_LONG).show();
        }

        if (ll_val.isEmpty()) {
            double newu = Double.parseDouble(usd_val) * 22000;
            Toast.makeText(getApplicationContext(), String.valueOf(newu) + "LL", Toast.LENGTH_LONG).show();
        }


    }


}