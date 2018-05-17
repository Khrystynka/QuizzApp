package com.example.android.quizzapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int results = 0;
    RadioGroup question1;
    RadioGroup question2;
    RadioGroup question3;
    RadioGroup question4;
    RadioGroup question5;
    RadioButton answer1;
    RadioButton answer2;
    RadioButton answer3;
    RadioButton answer4;
    RadioButton answer5;
    CheckBox answer6_1;
    CheckBox answer6_2;
    CheckBox answer6_3;
    CheckBox answer6_4;
    EditText answer7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question1 = (RadioGroup) findViewById(R.id.group1);
        question2 = (RadioGroup) findViewById(R.id.group2);
        question3 = (RadioGroup) findViewById(R.id.group3);
        question4 = (RadioGroup) findViewById(R.id.group4);
        question5 = (RadioGroup) findViewById(R.id.group5);
        answer1 = (RadioButton) findViewById(R.id.q1);
        answer2 = (RadioButton) findViewById(R.id.q2);
        answer3 = (RadioButton) findViewById(R.id.q3);
        answer4 = (RadioButton) findViewById(R.id.q4);
        answer5 = (RadioButton) findViewById(R.id.q5);
        answer6_1 = (CheckBox) findViewById(R.id.q6_1);
        answer6_2 = (CheckBox) findViewById(R.id.q6_2);
        answer6_3 = (CheckBox) findViewById(R.id.q6_3);
        answer6_4 = (CheckBox) findViewById(R.id.q6_4);
        answer7 = (EditText) findViewById(R.id.q7);

        answer7.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    Log.e("ggg", "focus");
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("question1", 5);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void submitResults(View view) {
        if (answer1.isChecked()) {
            results += 1;}
        if (answer2.isChecked()) {
            results += 1;}
        if (answer3.isChecked()) {
            results += 1;}
        if (answer4.isChecked()) {
            results += 1;}
        if (answer5.isChecked()) {
            results += 1;}
        if (answer6_1.isChecked() && answer6_3.isChecked() && answer6_4.isChecked() && !answer6_2.isChecked()) {
            results += 1;}
        String s = answer7.getText().toString();
        if (answer7.getText().toString().contentEquals("4") ){
            results += 1;}
        answer7.clearFocus();
        Toast toast = Toast.makeText(getApplicationContext(), "Your score is: " + results + " out of 7!", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
        results = 0;
    }

    public void clear(View view) {
        question1.clearCheck();
        question2.clearCheck();
        question3.clearCheck();
        question4.clearCheck();
        question5.clearCheck();
        answer6_1.setChecked(false);
        answer6_2.setChecked(false);
        answer6_3.setChecked(false);
        answer6_4.setChecked(false);
        answer7.setText("");
        answer7.clearFocus();
        results = 0;
    }
}
