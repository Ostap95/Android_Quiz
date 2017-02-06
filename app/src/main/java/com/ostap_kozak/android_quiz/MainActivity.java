package com.ostap_kozak.android_quiz;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText question1_answer;
    private RadioGroup radio_group_question2, radio_group_question3, radio_group_question4, radio_group_question5
            , radio_group_question6, radio_group_question8, radio_group_question9, radio_group_question10;

    private CheckBox question7_A, question7_B, question7_C, question7_D;

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;

        question1_answer = (EditText) findViewById(R.id.question_1_edit_text);
        radio_group_question2 = (RadioGroup) findViewById(R.id.radio_group_question2);
        radio_group_question3 = (RadioGroup) findViewById(R.id.radio_group_question3);
        radio_group_question4 = (RadioGroup) findViewById(R.id.radio_group_question4);
        radio_group_question5 = (RadioGroup) findViewById(R.id.radio_group_question5);
        radio_group_question6 = (RadioGroup) findViewById(R.id.radio_group_question6);
        radio_group_question8 = (RadioGroup) findViewById(R.id.radio_group_question8);
        radio_group_question9 = (RadioGroup) findViewById(R.id.radio_group_question9);
        radio_group_question10 = (RadioGroup) findViewById(R.id.radio_group_question10);

        question7_A = (CheckBox) findViewById(R.id.question_7_choiceA);
        question7_B = (CheckBox) findViewById(R.id.question_7_choiceB);
        question7_C = (CheckBox) findViewById(R.id.question_7_choiceC);
        question7_D = (CheckBox) findViewById(R.id.question_7_choiceD);

    }

    public void finishQuiz(View view) {

        buildResultDialog();

        if (Integer.valueOf(question1_answer.getText().toString()) == 2003) score++;
        if (radio_group_question2.getCheckedRadioButtonId() == R.id.question_2_choiceB) score++;
        if (radio_group_question3.getCheckedRadioButtonId() == R.id.question_3_choiceC) score++;
        if (radio_group_question4.getCheckedRadioButtonId() == R.id.question_4_choiceD) score++;
        if (radio_group_question5.getCheckedRadioButtonId() == R.id.question_5_choiceD) score++;
        if (radio_group_question6.getCheckedRadioButtonId() == R.id.question_6_choiceB) score++;
        if (question7_A.isChecked() == false & question7_B.isChecked() == true & question7_C.isChecked() == true & question7_D.isChecked() == false) score++;
        if (radio_group_question8.getCheckedRadioButtonId() == R.id.question_8_choiceA) score++;
        if (radio_group_question9.getCheckedRadioButtonId() == R.id.question_9_choiceC) score++;
        if (radio_group_question10.getCheckedRadioButtonId() == R.id.question_10_choiceA) score++;

        Toast.makeText(this, Integer.toString(score), Toast.LENGTH_LONG).show();

        score = 0;
    }

    public void buildResultDialog() {
        FragmentManager fm = getSupportFragmentManager();
        ResultsDialog dialog = ResultsDialog.newInstance("False");
        dialog.show(fm,"TAG");
    }

    public ArrayList buildResultArray() {
        
    }
}

