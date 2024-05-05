package com.geeks.homework7;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    private Integer firstNum, secondNum, result;
    private String operation;
    private boolean isOperationClick;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")) {
            textView.setText("0");
            firstNum = 0;
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(text);
        } else {
            textView.append(text);
        }
        isOperationClick = true;
    }
    //changed
    public void onOperationClick(View view) {
        if (view.getId() == R.id.btn_plus) {
            firstNum = Integer.valueOf(textView.getText().toString());
            operation = "+";
        } else if (view.getId() == R.id.btn_minus) {
            firstNum = Integer.valueOf(textView.getText().toString());
            operation = "-";
        } else if (view.getId() == R.id.btn_multiplication) {
            firstNum = Integer.valueOf(textView.getText().toString());
            operation = "x";
        } else if (view.getId() == R.id.btn_division) {
            firstNum = Integer.valueOf(textView.getText().toString());
            operation = "/";
        } else if (view.getId() == R.id.btn_equal) {
            secondNum = Integer.valueOf(textView.getText().toString());
            if (operation.equals("+")) {
                result = firstNum + secondNum;
                textView.setText(result.toString());
            } else if (operation.equals("-")) {
                result = firstNum - secondNum;
                textView.setText(result.toString());
            } else if (operation.equals("x")) {
                result = firstNum * secondNum;
                textView.setText(result.toString());
            } else if (operation.equals("/")) {
                if (secondNum == 0) {
                    textView.setText("Error");
                } else {
                    result = firstNum / secondNum;

                }
            }
            textView.setText(result.toString());
            isOperationClick = true;
        }

    }
}





