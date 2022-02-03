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
        int usd_val = Integer.parseInt(usv.getText().toString());
        int ll_val = Integer.parseInt(llv.getText().toString());
        int newl = ll_val / 22000;
        int newu = usd_val * 22000;
        if (TextUtils.isEmpty(usv.getText().toString())) {
            Toast.makeText(getApplicationContext(), newl, Toast.LENGTH_LONG).show();
        }

        if (TextUtils.isEmpty(llv.getText().toString())) {
            Toast.makeText(getApplicationContext(), newu, Toast.LENGTH_LONG).show();
        }
    }


}