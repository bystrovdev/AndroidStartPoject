package ru.synergy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.calc);


//        // Context training
//        TextView textView = new TextView();
//        ListView adapter = new SimpleCursorAdapter(getApplicationContext());
//
//        // Доступ из класса Activity -- наследник Context
//        getSystemService(LAYOUT_INFLATER_SERVICE);
//
//        // Shared prefs доступ c использованием контекста приложения
//        SharedPreferences prefs = getApplicationContext().getSharedPreferences("PREFS", MODE_PRIVATE);


        ////


        //// intent - посылка


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAnswer();
                Intent i = new Intent(Calculator.this, MainActivity.class); // Написать письмо
                //startActivity(i);  // Отправить письмо
            }
        });
    }

    private void calculateAnswer() {
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);

        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton sub = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiply = (RadioButton) findViewById(R.id.multiple);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);

//        numOne.setText("1");
//        numTwo.setText("0");
//        add.setChecked(true);

        TextView answer = (TextView) findViewById(R.id.result);

        float numone = 0;
        float numtwo = 0;
        String num1 = numOne.getText().toString();
        String num2 = numTwo.getText().toString();

        if(!num1.equals("") && num1 != null) {
            numone = Integer.parseInt(numOne.getText().toString());
        }

        if(!num2.equals("") && num2 != null) {
            numtwo = Integer.parseInt(numTwo.getText().toString());
        }

        float solution = 0;

        if(add.isChecked()) {
            solution = numone + numtwo;
        }
        if(sub.isChecked()) {
            solution = numone - numtwo;
        }
        if(multiply.isChecked()) {
            solution = numone * numtwo;
        }
        if(divide.isChecked()) {
            if(numtwo == 0) {
                Toast.makeText(this, "Number two cannot be zero!", Toast.LENGTH_LONG).show();
                return;
            }
            solution = numone / numtwo;
        }

        answer.setText("The answer is " + solution);

    }
}