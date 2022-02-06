package com.wimonsiri.assign03_01_6206021621147;
// วิมลศิริ คำแดงใส 6206021621147

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText numberText;
    private RadioButton radioBinary, radioOctal, radioHexa;
    private Button btnChange;
    private TextView resultSum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberText = (EditText) findViewById(R.id.numberText);

        radioBinary = (RadioButton) findViewById(R.id.radioBinary);
        radioOctal = (RadioButton) findViewById(R.id.radioOctal);
        radioHexa = (RadioButton) findViewById(R.id.radioHexa);

        btnChange = (Button) findViewById(R.id.btnChange);
        btnChange.setOnClickListener(this);

        resultSum = (TextView) findViewById(R.id.resultSum);
    }

    @Override
    public void onClick(View view) {

        String message = "";

        if (numberText.getText().toString().equals("")) {
            Toast.makeText(this, "กรุณากรอกตัวเลข", Toast.LENGTH_SHORT).show();
            return;
        }
        int decimal = Integer.parseInt(numberText.getText().toString());

        if (!radioBinary.isChecked() && !radioOctal.isChecked() && !radioHexa.isChecked()) {
            Toast.makeText(this, "กรุณาเลือกรูปแบบการแปลงเลขฐาน", Toast.LENGTH_SHORT).show();
            return;
        }
        if (radioBinary.isChecked()) {
            int temp;
            while (decimal > 0) {
                temp = decimal % 2;
                decimal = decimal / 2;
                message = temp + message;
            }
            resultSum.setText("\nDecimal :  " + numberText.getText().toString() + "\nBinary : " + message);
            message = "";
        } else if (radioOctal.isChecked()) {
            int temp;
            while (decimal > 0) {
                temp = decimal % 8;
                decimal = decimal / 8;
                message = temp + message;
            }
            resultSum.setText("\nDecimal :  " + numberText.getText().toString() + "\nOcal : " + message);
            message = "";
        } else if (radioHexa.isChecked()) {
            int temp;
            char[] hexaChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            while (decimal > 0) {
                temp = decimal % 16;
                decimal = decimal / 16;
                message = hexaChar[temp] + message;
            }
            resultSum.setText("\nDecimal :  " + numberText.getText().toString() + "\nHexa : " + message);
            message = "";
        }

    }

}