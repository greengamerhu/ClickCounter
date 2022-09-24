package com.example.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlussz;
    private Button buttonMinusz;
    private TextView TextViewOut;
    private int szam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        TextViewOut.setText("0");
        TextViewOut.setTextColor(Color.BLUE);

        TextViewOut.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                szam = 0;
                TextViewOut.setText(String.valueOf(szam));

                return true;

            }
        });

        TextViewOut.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (Prime(szam) && szam > 1) {
                    TextViewOut.setTextColor(Color.rgb(255,250,250));
                }else if (szam > 0) {
                    TextViewOut.setTextColor(getResources().getColor(R.color.zold));

                } else if (szam < 0) {
                    TextViewOut.setTextColor(Color.parseColor("#880808"));

                }
                else {
                    TextViewOut.setTextColor(Color.BLUE);

                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        buttonPlussz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               szam++;

                TextViewOut.setText(String.valueOf(szam));
            }
        });
        buttonMinusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                szam--;
                TextViewOut.setText(String.valueOf(szam));

            }
        });
    }
    public boolean Prime(int szam) {
        boolean prime_e = true;
        if (szam > 1) {
            for (int i = 2; i <= szam / 2; ++i) {
                if (szam % i == 0) {
                    return prime_e = false;
                }
            }
        }
        return  prime_e = true;
    }
    private void init() {
        buttonPlussz = findViewById(R.id.buttonPlussz);
        buttonMinusz = findViewById(R.id.buttonMinusz);
        TextViewOut = findViewById(R.id.TextViewOut);
        szam = 0;

    }
}