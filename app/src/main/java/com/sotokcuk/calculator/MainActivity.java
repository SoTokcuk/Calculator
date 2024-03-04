package com.sotokcuk.calculator;

import androidx.appcompat.app.AppCompatActivity;
import net.objecthunter.exp4j.ExpressionBuilder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private TextView operation;
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_back;
    private Button btn_plusminus;
    private Button btn_clear;
    private Button btn_point;
    private Button btn_result;
    private Button btn_mc;
    private Button btn_mr;
    private Button btn_ms;
    private Button btn_mplus;
    private Button btn_mminus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        operation = findViewById(R.id.operation);
        btn_0 = findViewById(R.id.button_0);
        btn_1 = findViewById(R.id.button_1);
        btn_2 = findViewById(R.id.button_2);
        btn_3 = findViewById(R.id.button_3);
        btn_4 = findViewById(R.id.button_4);
        btn_5 = findViewById(R.id.button_5);
        btn_6 = findViewById(R.id.button_6);
        btn_7 = findViewById(R.id.button_7);
        btn_8 = findViewById(R.id.button_8);
        btn_9 = findViewById(R.id.button_9);
        btn_back = findViewById(R.id.button_back);
        btn_plusminus = findViewById(R.id.button_plusminus);
        btn_clear = findViewById(R.id.button_c);
        btn_point = findViewById(R.id.button_point);
        btn_result = findViewById(R.id.button_result);
        btn_mc = findViewById(R.id.button_mc);
        btn_mr = findViewById(R.id.button_mr);
        btn_ms = findViewById(R.id.button_ms);
        btn_mplus = findViewById(R.id.button_mplus);
        btn_mminus = findViewById(R.id.button_mminus);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append("0");
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append("1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append("2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append("3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append("4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append("5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append("6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append("7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append("8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append("9");
            }
        });

    }
}