package com.sotokcuk.calculator;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private Button btn_minus;
    private Button btn_plus;
    private Button btn_multiply;
    private Button btn_div;
    private Button btn_sqrt;
    private Button btn_invert;
    private String memory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
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
        btn_plus = findViewById(R.id.button_plus);
        btn_minus = findViewById(R.id.button_minus);
        btn_multiply = findViewById(R.id.button_multiply);
        btn_div = findViewById(R.id.button_div);
        btn_sqrt = findViewById(R.id.button_sqrt);
        btn_invert = findViewById(R.id.button_invert);

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
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append("-");
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append("+");
            }
        });
        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append("*");
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append("/");
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = operation.getText().toString();
                if (s != "") {
                    operation.setText(s.substring(0, s.length()-1));
                }
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.setText("");
                result.setText("");
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultText = result.getText().toString();
                if (resultText != resources.getString(R.string.error) && resultText != "") {
                    operation.setText(resultText);
                    result.setText("");
                }
            }
        });
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operationText = operation.getText().toString();
                if (operationText != "") {
                    try {
                        Expression exp = new ExpressionBuilder(operation.getText().toString()).build();
                        double res = exp.evaluate();
                        long longRes = (long) res;
                        if ((double) longRes == res) {
                            result.setText(Long.toString(longRes));
                        } else {
                            result.setText(Double.toString(res));
                        }
                    } catch (Exception e) {
                        result.setText(resources.getString(R.string.error));
                    }
                }
            }
        });
        btn_plusminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String invertedNumber;
                String exp = operation.getText().toString();
                String pattern = "(-|\\+)?\\d+(\\.\\d+)?";
                Pattern regexPattern = Pattern.compile(pattern);
                Matcher matcher = regexPattern.matcher(exp);
                String lastNumber = "";
                while (matcher.find()) {
                    lastNumber = matcher.group();
                }
                if (!lastNumber.isEmpty()) {
                    if (lastNumber.charAt(0) == '-') {
                        invertedNumber = "+" + lastNumber.substring(1);
                    } else if (lastNumber.charAt(0) == '+') {
                        invertedNumber = "-" + lastNumber.substring(1);
                    } else {
                        invertedNumber = "-" + lastNumber;
                    }
                    exp = exp.substring(0, exp.lastIndexOf(lastNumber)) + invertedNumber + exp.substring(exp.lastIndexOf(lastNumber) + lastNumber.length());
                    operation.setText(exp);
                }
            }
        });
        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exp = operation.getText().toString();
                String pattern = "(-|\\+)?\\d+(\\.\\d+)?";
                Pattern regexPattern = Pattern.compile(pattern);
                Matcher matcher = regexPattern.matcher(exp);
                String lastNumber = "";
                while (matcher.find()) {
                    lastNumber = matcher.group();
                }
                if (!lastNumber.contains(".") && exp.length() > 0 && exp.charAt(exp.length() - 1) != '.') {
                    exp = exp.substring(0, exp.lastIndexOf(lastNumber)) + lastNumber + "." + exp.substring(exp.lastIndexOf(lastNumber) + lastNumber.length());
                    operation.setText(exp);
                }
            }
        });
        btn_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operationText = operation.getText().toString();
                if (operationText != "") {
                    try {
                        Expression exp = new ExpressionBuilder(operation.getText().toString()).build();
                        double res = exp.evaluate();
                        res = Math.sqrt(res);
                        long longRes = (long) res;
                        if ((double) longRes == res) {
                            result.setText(Long.toString(longRes));
                        } else {
                            result.setText(Double.toString(res));
                        }
                    } catch (Exception e) {
                        result.setText(resources.getString(R.string.error));
                    }
                }
            }
        });
        btn_invert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operationText = operation.getText().toString();
                if (operationText != "") {
                    try {
                        Expression exp = new ExpressionBuilder(operation.getText().toString()).build();
                        double res = exp.evaluate();
                        res = 1 / res;
                        long longRes = (long) res;
                        if ((double) longRes == res) {
                            result.setText(Long.toString(longRes));
                        } else {
                            result.setText(Double.toString(res));
                        }
                    } catch (Exception e) {
                        result.setText(resources.getString(R.string.error));
                    }
                }
            }
        });
        btn_mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memory = "";
            }
        });
        btn_ms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memory = result.getText().toString();
            }
        });
        btn_mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exp = operation.getText().toString();
                if(memory != "") {
                    operation.setText(exp + "+" + memory);
                }
            }
        });
        btn_mplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result.getText().toString() != "") {
                    if (memory != "") {
                        try {
                            String expr = result.getText().toString() + "+" + memory;
                            Expression exp = new ExpressionBuilder(expr).build();
                            double res = exp.evaluate();
                            long longRes = (long) res;
                            if ((double) longRes == res) {
                                result.setText(Long.toString(longRes));
                            } else {
                                result.setText(Double.toString(res));
                            }
                        } catch (Exception e) {
                            result.setText(resources.getString(R.string.error));
                        }
                    }
                }
            }
        });
        btn_mminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result.getText().toString() != "") {
                    if (memory != "") {
                        try {
                            String expr = result.getText().toString() + "-" + memory;
                            Expression exp = new ExpressionBuilder(expr).build();
                            double res = exp.evaluate();
                            long longRes = (long) res;
                            if ((double) longRes == res) {
                                result.setText(Long.toString(longRes));
                            } else {
                                result.setText(Double.toString(res));
                            }
                        } catch (Exception e) {
                            result.setText(resources.getString(R.string.error));
                        }
                    }
                }
            }
        });

    }
}