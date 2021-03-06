package com.ostap_kozak.android_quiz;

import android.content.res.Resources;
import android.support.annotation.IntegerRes;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private ArrayList<Integer> radioButtonResults;
    private ArrayList<String> editTextResults;
    private boolean[] checkBoxResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonResults = new ArrayList<>();
        editTextResults = new ArrayList<>();
        checkBoxResults = new boolean[]{false, false, false, false};

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
    }

    public void buildResultDialog() {
        buildQuizResult();
        FragmentManager fm = getSupportFragmentManager();
        ResultsDialog dialog = ResultsDialog.newInstance(radioButtonResults, checkBoxResults, editTextResults);
        dialog.show(fm,"TAG");
    }


    /**
     * Stores quiz choices inside arrays
     */
    public void buildQuizResult() {
        radioButtonResults.clear();
        editTextResults.clear();

        radioButtonResults.add(radio_group_question2.getCheckedRadioButtonId());
        radioButtonResults.add(radio_group_question3.getCheckedRadioButtonId());
        radioButtonResults.add(radio_group_question4.getCheckedRadioButtonId());
        radioButtonResults.add(radio_group_question5.getCheckedRadioButtonId());
        radioButtonResults.add(radio_group_question6.getCheckedRadioButtonId());
        radioButtonResults.add(radio_group_question8.getCheckedRadioButtonId());
        radioButtonResults.add(radio_group_question9.getCheckedRadioButtonId());
        radioButtonResults.add(radio_group_question10.getCheckedRadioButtonId());

        editTextResults.add(question1_answer.getText().toString());

        checkBoxResults[0] = question7_A.isChecked();
        checkBoxResults[1] = question7_B.isChecked();
        checkBoxResults[2] = question7_C.isChecked();
        checkBoxResults[3] = question7_D.isChecked();
    }

}

