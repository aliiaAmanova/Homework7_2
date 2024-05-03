package com.geeks.homework7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    private Integer firstNum, secondNum, result;
    private String operation;
    private boolean isOperationClick;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view){
        View view1 = view;
        String text = ((MaterialButton) view1).getText().toString();
        if (text.equals("AC")) {
            textView.setText("0");
            firstNum=0;
            secondNum=0;
        }else if (textView.getText().toString().equals("0") || isOperationClick){
            textView.setText(text);
        }else{
            textView.append(text);
        }
        isOperationClick=false;

    }
    public void onOperationClick(View view){
        if (view.getId() == R.id.btn_plus|| view.getId() == R.id.btn_minus ||
                view.getId() == R.id.btn_multiplication || view.getId() == R.id.btn_division){
firstNum= Integer.valueOf(textView.getText().toString());
        }if(view.getId() == R.id.btn_equal) {
secondNum = Integer.valueOf(textView.getText().toString());
result= firstNum+secondNum;
textView.setText(result.toString());
        }
        isOperationClick = true;
    }

    public void calculateResult(){
        switch(operation){
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "/":
                if (secondNum == 0 ) Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                else result = firstNum / secondNum;
                break;

        }
        textView.setText(result.toString());
    }


}
