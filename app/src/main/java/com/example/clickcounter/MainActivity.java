package com.example.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

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
        TextViewOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextViewOut.setText("0");
                TextViewOut.setTextColor(Color.BLUE);
            }

        });
        TextViewOut.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (szam > 0) {
                    TextViewOut.setTextColor(Color.GREEN);

                } else if (szam < 0) {
                    TextViewOut.setTextColor(Color.RED);

                } else {
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
    private void init() {
        buttonPlussz = findViewById(R.id.buttonPlussz);
        buttonMinusz = findViewById(R.id.buttonMinusz);
        TextViewOut = findViewById(R.id.TextViewOut);
        szam = 0;

    }
}