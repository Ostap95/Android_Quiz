package com.ostap_kozak.android_quiz;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ostapkozak on 06/02/2017.
 */

public class ResultsDialog extends DialogFragment {
    private CardView cardView_question1, cardView_question2, cardView_question3, cardView_question4, cardView_question5
            , cardView_question6, cardView_question7, cardView_question8, cardView_question9, cardView_question10;

    private RadioGroup radio_group_question2, radio_group_question3, radio_group_question4, radio_group_question5
            , radio_group_question6, radio_group_question8, radio_group_question9, radio_group_question10;

    private CheckBox question7_A, question7_B, question7_C, question7_D;

    private EditText editText_question1;

    private int score;

    public ResultsDialog() {
        // Empty constructor required for DialogFragment
    }

    public static ResultsDialog newInstance(ArrayList<Integer> radioButtons, boolean[] checkBoxes, ArrayList<String> editTexts) {
        ResultsDialog frag = new ResultsDialog();
        Bundle args = new Bundle();
        args.putIntegerArrayList("radioButtons", radioButtons);
        args.putBooleanArray("checkBoxes", checkBoxes);
        args.putStringArrayList("editTexts", editTexts);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = (LayoutInflater)getContext() .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.result_dialog, null);

        score = 0; // resets the score variable

        initializeLayoutViews(view);
        buildEditTextResult(view, getArguments().getStringArrayList("editTexts"));
        buildRadioButtonsResult(view, getArguments().getIntegerArrayList("radioButtons"));
        buildCheckBoxResult(view, getArguments().getBooleanArray("checkBoxes"));
        
        Toast.makeText(getContext(), "Your score: "+ score + "/10", Toast.LENGTH_LONG).show();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Your score: "+ score + "/10");
        alertDialogBuilder.setView(view);
        alertDialogBuilder.setPositiveButton(android.R.string.ok,  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // on success
                dialog.dismiss();
            }
        });
        return alertDialogBuilder.create();
    }

    public void buildEditTextResult(View view, ArrayList<String> list) {
        editText_question1.setText(list.get(0));

        if (Integer.valueOf(list.get(0)) == 2003) {
            cardView_question1.setCardBackgroundColor(Color.parseColor("#4CAF50"));
            score++;
        } else {
            cardView_question1.setCardBackgroundColor(Color.parseColor("#F44336"));
        }
    }

    public void buildRadioButtonsResult(View view, ArrayList<Integer> list) {
        // 2nd question
        radio_group_question2.check(list.get(0));
        if (list.get(0) == R.id.question_2_choiceB) {
            score++;
            cardView_question2.setCardBackgroundColor(Color.parseColor("#4CAF50"));
        } else {
            cardView_question2.setCardBackgroundColor(Color.parseColor("#F44336"));
        }

        // 3rd question
        radio_group_question3.check(list.get(1));
        if (list.get(1) == R.id.question_3_choiceC) {
            score++;
            cardView_question3.setCardBackgroundColor(Color.parseColor("#4CAF50"));
        } else {
            cardView_question3.setCardBackgroundColor(Color.parseColor("#F44336"));
        }

        // 4th question
        radio_group_question4.check(list.get(2));
        if (list.get(2) == R.id.question_4_choiceD) {
            score++;
            cardView_question4.setCardBackgroundColor(Color.parseColor("#4CAF50"));
        } else {
            cardView_question4.setCardBackgroundColor(Color.parseColor("#F44336"));
        }

        // 5th question
        radio_group_question5.check(list.get(3));
        if (list.get(3) == R.id.question_5_choiceD) {
            score++;
            cardView_question5.setCardBackgroundColor(Color.parseColor("#4CAF50"));
        } else {
            cardView_question5.setCardBackgroundColor(Color.parseColor("#F44336"));
        }

        // 6th question
        radio_group_question6.check(list.get(4));
        if (list.get(4) == R.id.question_6_choiceB) {
            score++;
            cardView_question6.setCardBackgroundColor(Color.parseColor("#4CAF50"));
        } else {
            cardView_question6.setCardBackgroundColor(Color.parseColor("#F44336"));
        }

        // 8th question
        radio_group_question8.check(list.get(5));
        if (list.get(5) == R.id.question_8_choiceA) {
            score++;
            cardView_question8.setCardBackgroundColor(Color.parseColor("#4CAF50"));
        } else {
            cardView_question8.setCardBackgroundColor(Color.parseColor("#F44336"));
        }


        // 9th question
        radio_group_question9.check(list.get(6));
        if (list.get(6) == R.id.question_9_choiceC) {
            score++;
            cardView_question9.setCardBackgroundColor(Color.parseColor("#4CAF50"));
        } else {
            cardView_question9.setCardBackgroundColor(Color.parseColor("#F44336"));
        }

        // 10th question
        radio_group_question10.check(list.get(7));
        if (list.get(7) == R.id.question_10_choiceA) {
            score++;
            cardView_question10.setCardBackgroundColor(Color.parseColor("#4CAF50"));
        } else {
            cardView_question10.setCardBackgroundColor(Color.parseColor("#F44336"));
        }
    }

    public void buildCheckBoxResult(View view, boolean[] list) {

        question7_A.setChecked(list[0]);
        question7_B.setChecked(list[1]);
        question7_C.setChecked(list[2]);
        question7_D.setChecked(list[3]);

        if (question7_A.isChecked() == false & question7_B.isChecked() == true & question7_C.isChecked() == true & question7_D.isChecked() == false) {
            score++;
            cardView_question7.setCardBackgroundColor(Color.parseColor("#4CAF50"));
        } else {
            cardView_question7.setCardBackgroundColor(Color.parseColor("#F44336"));
        }

    }

    public void initializeLayoutViews(View view) {
        cardView_question1 = (CardView) view.findViewById(R.id.card_view_question1);
        editText_question1 = (EditText) view.findViewById(R.id.question_1_edit_text);

        radio_group_question2 = (RadioGroup) view.findViewById(R.id.radio_group_question2);
        radio_group_question3 = (RadioGroup) view.findViewById(R.id.radio_group_question3);
        radio_group_question4 = (RadioGroup) view.findViewById(R.id.radio_group_question4);
        radio_group_question5 = (RadioGroup) view.findViewById(R.id.radio_group_question5);
        radio_group_question6 = (RadioGroup) view.findViewById(R.id.radio_group_question6);
        radio_group_question8 = (RadioGroup) view.findViewById(R.id.radio_group_question8);
        radio_group_question9 = (RadioGroup) view.findViewById(R.id.radio_group_question9);
        radio_group_question10 = (RadioGroup) view.findViewById(R.id.radio_group_question10);

        cardView_question2 = (CardView) view.findViewById(R.id.card_view_question2);
        cardView_question3 = (CardView) view.findViewById(R.id.card_view_question3);
        cardView_question4 = (CardView) view.findViewById(R.id.card_view_question4);
        cardView_question5 = (CardView) view.findViewById(R.id.card_view_question5);
        cardView_question6 = (CardView) view.findViewById(R.id.card_view_question6);
        cardView_question7 = (CardView) view.findViewById(R.id.card_view_question7);
        cardView_question8 = (CardView) view.findViewById(R.id.card_view_question8);
        cardView_question9 = (CardView) view.findViewById(R.id.card_view_question9);
        cardView_question10 = (CardView) view.findViewById(R.id.card_view_question10);

        question7_A = (CheckBox) view.findViewById(R.id.question_7_choiceA);
        question7_B = (CheckBox) view.findViewById(R.id.question_7_choiceB);
        question7_C = (CheckBox) view.findViewById(R.id.question_7_choiceC);
        question7_D = (CheckBox) view.findViewById(R.id.question_7_choiceD);

    }
}
