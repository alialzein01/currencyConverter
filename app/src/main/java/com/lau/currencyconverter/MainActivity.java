package com.lau.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText usv;
    EditText llv;
    Button conv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usv = (EditText) findViewById(R.id.usdValue);
        llv = (EditText) findViewById(R.id.llValue);

        conv = findViewById(R.id.convert);

    }

    public void convert(View v) {
        String usd_val = usv.getText().toString();
        String ll_val = llv.getText().toString();
        closeKeyboard();
        if (usd_val.isEmpty()) {
            double newl = Double.parseDouble(ll_val) / 22000;
            Toast.makeText(getApplicationContext(), formatNum(String.valueOf(newl)) + "$", Toast.LENGTH_LONG).show();
        } else if (ll_val.isEmpty()) {
            double newu = Double.parseDouble(usd_val) * 22000;
            Toast.makeText(getApplicationContext(), formatNum(String.valueOf(newu)) + "LL", Toast.LENGTH_LONG).show();
        }
    }

    private String formatNum(String n) {
        DecimalFormat form = new DecimalFormat("###,###,##0.0");
        return form.format(Double.parseDouble(n));
    }

    private void closeKeyboard() {
        View v = this.getCurrentFocus();
        if (v != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

}